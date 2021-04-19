package se.lexicon.group33.yommie.recipeassignmentredo.dto;

import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Recipe;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeCategory;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeIngredient;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeInstruction;

import java.io.Serializable;
import java.util.Collection;

public class RecipeDTO implements Serializable {

    private int recipeId;
    private String recipeName;
    private Collection<RecipeIngredient> recipeIngredients;
    private RecipeInstruction recipeInstruction;
    private Collection<RecipeCategory> recipeCategories;

    public RecipeDTO(Recipe recipe) {
        if (recipe != null) {
            this.recipeId = recipe.getRecipeId();
            this.recipeName = recipe.getRecipeName();
            this.recipeIngredients = recipe.getRecipeIngredients();
            this.recipeInstruction = recipe.getRecipeInstruction();
            this.recipeCategories = recipe.getRecipeCategories();
        }
    }

    public RecipeDTO() {
    }

    public int getRecipeId() {
        return recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Collection<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Collection<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public Collection<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(Collection<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }
}
