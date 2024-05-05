package be.kdg.sa.warehouse.controller;

import be.kdg.sa.warehouse.controller.dto.IngredientDto;
import be.kdg.sa.warehouse.domain.Ingredient;
import be.kdg.sa.warehouse.services.IngredientService;
import jdk.jfr.Frequency;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @PatchMapping("/{id}/quantity")
    public ResponseEntity<?> changeQuantityOfIngredient(@PathVariable UUID id, @RequestParam double Quantity, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("No quantity could be updated");
        }
        ingredientService.changeQuantityOfIngredient(id,Quantity);
        return ResponseEntity.status(HttpStatus.CREATED).body("The Quantity was changed to " + Quantity);
    }



    private IngredientDto convertToIngredientDto(Ingredient ingredient){
        return new IngredientDto(
                ingredient.getingredientId(),
                ingredient.getingredientName(),
                ingredient.getingredientQuantity()
        );
    }
}
