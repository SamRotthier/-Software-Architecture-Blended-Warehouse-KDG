package be.kdg.sa.warehouse.repositories;

import be.kdg.sa.warehouse.domain.Ingredient;
import be.kdg.sa.warehouse.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {


}
