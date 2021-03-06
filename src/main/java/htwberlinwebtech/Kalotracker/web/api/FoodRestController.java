package htwberlinwebtech.Kalotracker.web.api;


import htwberlinwebtech.Kalotracker.service.FoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class FoodRestController {

    private final FoodService foodService;

    public FoodRestController(FoodService foodService) {
        this.foodService = foodService;
    }


    @GetMapping(path = "/api/v1/food")
    public ResponseEntity<List<Food>> fetchFood()  {
        return ResponseEntity.ok(foodService.findAll());
    }

    @GetMapping(path = "/api/v1/food/{id}")
    public ResponseEntity<Food> fetchFoodById(@PathVariable Long id){
        var food = foodService.findById(id);
        return food != null? ResponseEntity.ok(food) : ResponseEntity.notFound().build();

    }

    @PostMapping(path = "/api/v1/food")
    public ResponseEntity<Void> createFood(@RequestBody FoodManipulationRequest request) throws URISyntaxException {
        var food= foodService.create(request);
        URI uri = new URI("/api/v1/food/" + food.getId());
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(path = "/api/v1/food/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody FoodManipulationRequest request) {
        var food = foodService.update(id, request);
        return food != null? ResponseEntity.ok(food) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/food/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        boolean successful = foodService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}