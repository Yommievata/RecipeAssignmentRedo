package se.lexicon.group33.yommie.recipeassignmentredo.data;

import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Ingredient;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeCategory;

import java.util.Collection;

public interface RecipeCategoryDAO {
    RecipeCategory findById(Integer recipeCategoryId);
    Collection<RecipeCategory> findAll();
    RecipeCategory create(RecipeCategory recipeCategory);
    RecipeCategory update(RecipeCategory recipeCategory);
    void delete(Integer recipeCategoryId);
}
