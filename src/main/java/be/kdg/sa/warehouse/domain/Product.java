package be.kdg.sa.warehouse.domain;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="wa_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID ingredientId;

    private String productName;

    @OneToMany(mappedBy = "product")
    private List<ProductIngredient> ingredientList;


    public Product() {

    }

    public Product(UUID ingredientId, String productName, List<ProductIngredient> ingredientList) {
        this.ingredientId = ingredientId;
        this.productName = productName;
        this.ingredientList = ingredientList;
    }

    public String getProductName() {
        return productName;
    }

    public List<ProductIngredient> getIngredientList() {
        return ingredientList;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setIngredientList(List<ProductIngredient> ingredientList) {
        this.ingredientList = ingredientList;
    }


}
