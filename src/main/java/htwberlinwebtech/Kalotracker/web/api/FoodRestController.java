package htwberlinwebtech.Kalotracker.web.api;


import htwberlinwebtech.Kalotracker.web.api.Food;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NahrungsmittelRestController {

    private List<Food> foodlist;

    public NahrungsmittelRestController() {
        foodlist = new ArrayList<>();
        foodlist.add(new Food(1, "Banane", 30, 20, 39, 200));
        foodlist.add(new Food(2, "Apfel", 100, 8, 12, 400));
    }

    @GetMapping(path = "/api/v1/food")
    public ResponseEntity<List<Food>> fetchFood()  {
        return ResponseEntity.ok(foodlist);
    }
}