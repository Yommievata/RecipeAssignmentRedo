package se.lexicon.group33.yommie.recipeassignmentredo.data;

import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Ingredient;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeIngredient;

import java.util.Collection;

public interface RecipeIngredientDAO {
   RecipeIngredient findById(Integer recipeIngredientId);
   Collection<RecipeIngredient> findAll();
   RecipeIngredient create(RecipeIngredient recipeIngredient);
   RecipeIngredient update(RecipeIngredient recipeIngredient);
   void delete (Integer recipeIngredientId);
}
