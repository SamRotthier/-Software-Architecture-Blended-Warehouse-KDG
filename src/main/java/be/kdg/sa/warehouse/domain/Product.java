package be.kdg.sa.warehouse.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="wa_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID productId;

    private String Name;

    @OneToMany(mappedBy = "product")
    private List<ProductIngredient> ingredientList;


    public Product() {

    }

    public Product(UUID Id, String Name, List<ProductIngredient> ingredientList) {
        this.productId = Id;
        this.Name = Name;
        this.ingredientList = ingredientList;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getName() {
        return Name;
    }

    public List<ProductIngredient> getIngredientList() {
        return ingredientList;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setIngredientList(List<ProductIngredient> ingredientList) {
        this.ingredientList = ingredientList;
    }


}
