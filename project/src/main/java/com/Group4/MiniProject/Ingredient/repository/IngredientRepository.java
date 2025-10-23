package com.Group4.MiniProject.Ingredient.repository;


import com.Group4.MiniProject.Ingredient.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByUserId(Long userId);
}