package be.kdg.sa.warehouse.services;

import be.kdg.sa.warehouse.domain.Ingredient;
import be.kdg.sa.warehouse.repositories.IngredientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.UUID;

@Service
public class IngredientService {
    private static final Logger logger = LoggerFactory.getLogger(IngredientService.class);
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository){
        this.ingredientRepository=ingredientRepository;
    }


    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientById(UUID IngredientId){
        return ingredientRepository.getIngredientByIngredientId(IngredientId);
    }

    @Transactional
    public void changeQuantityOfIngredient (UUID ingredientId, double Quantity){
        Ingredient ingredient = ingredientRepository.findIngredientByIngredientId(ingredientId);
        ingredient.setingredientQuantity(Quantity);
        logger.info("The ingredient quantity was changed for: {} to quantity: {}", ingredient.getingredientName(), Quantity);
        ingredientRepository.save(ingredient);
    }
}
