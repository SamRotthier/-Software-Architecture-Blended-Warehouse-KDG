package be.kdg.sa.warehouse.repositories;

import be.kdg.sa.warehouse.domain.ProductIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductIngredientRepository extends JpaRepository<ProductIngredient, UUID> {

}
