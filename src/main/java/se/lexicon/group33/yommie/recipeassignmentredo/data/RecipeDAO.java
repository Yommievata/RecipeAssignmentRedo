package se.lexicon.group33.yommie.recipeassignmentredo.data;

import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Ingredient;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Recipe;

import java.util.Collection;

public interface RecipeDAO {
    Recipe findById(Integer recipeId);
    Collection<Recipe> findAll();
    Recipe create(Recipe recipe);
    Recipe update(Recipe recipe);
    void delete(Integer recipeId);
}
