package be.kdg.sa.warehouse.controller.dto;

import java.util.UUID;

public class ProductIngredientDto {
    private UUID id;
    private String name;
    private Integer quantity;

    public ProductIngredientDto() {
    }

    public ProductIngredientDto(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public ProductIngredientDto(UUID id, String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}


