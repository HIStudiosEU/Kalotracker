package htwberlinwebtech.Kalotracker.service;

import htwberlinwebtech.Kalotracker.persistence.FoodEntity;
import htwberlinwebtech.Kalotracker.persistence.FoodRepository;
import htwberlinwebtech.Kalotracker.web.api.Food;
import htwberlinwebtech.Kalotracker.web.api.FoodManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> findAll() {
        List<FoodEntity> foodlist = foodRepository.findAll();
        return foodlist.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());

    }

    public Food create(FoodManipulationRequest request) {
        var foodEntity = new FoodEntity(request.getName(), request.getCarbs(), request.getFat(), request.getProteins(), request.getKalories());
        foodEntity = foodRepository.save(foodEntity);
        return transformEntity(foodEntity);
    }

    private Food transformEntity(FoodEntity foodEntity){
        return new Food(
                foodEntity.getId(),
                foodEntity.getName(),
                foodEntity.getCarbs(),
                foodEntity.getFat(),
                foodEntity.getProteins(),
                foodEntity.getKalories()
        );
    }

    public Food findById(Long id){
        var foodEntity = foodRepository.findById(id);
        return foodEntity.map(this::transformEntity).orElse(null);
    }
    public Food update(Long id, FoodManipulationRequest request) {
        var foodEntityOptional = foodRepository.findById(id);
        if (foodEntityOptional.isEmpty()) {
            return null;
        }
        var foodEntity = foodEntityOptional.get();
        foodEntity.setName(request.getName());
        foodEntity.setCarbs(request.getCarbs());
        foodEntity.setFat(request.getFat());
        foodEntity.setProteins(request.getProteins());
        foodEntity.setKalories(request.getKalories());
        foodEntity = foodRepository.save(foodEntity);

        return transformEntity(foodEntity);
    }

    public boolean deleteById(Long id) {
        if (!foodRepository.existsById(id)) {
            return false;
        }

        foodRepository.deleteById(id);
        return true;
    }

}
