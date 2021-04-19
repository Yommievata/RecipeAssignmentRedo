package se.lexicon.group33.yommie.recipeassignmentredo.dto;

import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Recipe;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeCategory;

import java.io.Serializable;
import java.util.Collection;

public class RecipeCategoryDTO implements Serializable {

    private int recipeCategoryId;
    private String category;
    private Collection<Recipe> recipes;

    public RecipeCategoryDTO(RecipeCategory recipeCategory) {
        if (recipeCategory != null) {
            this.recipeCategoryId = recipeCategory.getRecipeCategoryId();
            this.category = recipeCategory.getCategory();
            this.recipes = recipeCategory.getRecipes();
        }
    }

    public RecipeCategoryDTO() {
    }

    public int getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Collection<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Collection<Recipe> recipes) {
        this.recipes = recipes;
    }
}
