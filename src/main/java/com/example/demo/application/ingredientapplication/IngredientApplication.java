package com.example.demo.application.ingredientapplication;

import java.util.UUID;

import com.example.demo.dto.ingredientdtos.CreateOrUpdateIngredientDTO;
import com.example.demo.dto.ingredientdtos.IngredientDTO;

public interface IngredientApplication {
    public IngredientDTO add(CreateOrUpdateIngredientDTO dto);
    public IngredientDTO get(UUID id);
    public void update(UUID id, CreateOrUpdateIngredientDTO dtos); 
    public void delete(UUID id);
}
