package com.example.demo.infraestructure.ingredientinfraestructure;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.ingredientdomain.Ingredient;
import com.example.demo.domain.ingredientdomain.IngredientProjection;
import com.example.demo.domain.ingredientdomain.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientRepositoryImp implements IngredientRepository {

    private final IngredientJPARepository ingredientJPARepository; // creas una instancia del jpa repository

    @Autowired
    // constructor
    public IngredientRepositoryImp(final IngredientJPARepository ingredientJPARepository) {
        this.ingredientJPARepository = ingredientJPARepository;
    }

    @Override
    public void add(Ingredient ingredient) {
        this.ingredientJPARepository.save(ingredient);
    }

    @Override
    public Optional<Ingredient> findById(UUID id) {
        return this.ingredientJPARepository.findById(id);
    }

    @Override
    public void update(Ingredient ingredient) {
        this.ingredientJPARepository.save(ingredient);
    }

    @Override
    public void delete(Ingredient ingredient) {
        this.ingredientJPARepository.delete(ingredient);
    }

    @Override
    public List<IngredientProjection> getAll(String name, int page, int size) {
       return this.ingredientJPARepository.findByCriteria(
           name,
           PageRequest.of(page, size, Sort.by("name").descending())
       );
    }

}
