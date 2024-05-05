package be.kdg.sa.warehouse.controller;

import be.kdg.sa.warehouse.controller.dto.IngredientDto;
import be.kdg.sa.warehouse.domain.Ingredient;
import be.kdg.sa.warehouse.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllIngredients() {
        List<Ingredient> allOrders = ingredientService.getAllIngredients();

        if(allOrders.isEmpty()){
            return ResponseEntity.noContent().build();
        } else{
            List<IngredientDto> ingredientDtos = allOrders.stream().map(this::convertToIngredientDto).toList();
            return ResponseEntity.ok(ingredientDtos);
        }

    }

    private IngredientDto convertToIngredientDto(Ingredient ingredient){
        return new IngredientDto(
                ingredient.getingredientId(),
                ingredient.getingredientName(),
                ingredient.getingredientQuantity()
        );
    }
}
