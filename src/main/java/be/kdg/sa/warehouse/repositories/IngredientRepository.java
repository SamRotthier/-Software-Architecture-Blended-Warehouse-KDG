package be.kdg.sa.warehouse.repositories;

import be.kdg.sa.warehouse.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {

    public Ingredient findIngredientByIngredientId(UUID ingredientId);
    public Ingredient getIngredientByIngredientId(UUID ingredientId);

}
