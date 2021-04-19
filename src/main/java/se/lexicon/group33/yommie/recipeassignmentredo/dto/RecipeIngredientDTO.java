package se.lexicon.group33.yommie.recipeassignmentredo.dto;

import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Ingredient;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Recipe;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeIngredient;
import se.lexicon.group33.yommie.recipeassignmentredo.model.meas.Measurement;

import java.io.Serializable;

public class RecipeIngredientDTO implements Serializable {

    private String recipeIngredientId;
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    private Recipe recipes;

    public RecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        this.recipeIngredientId = recipeIngredient.getRecipeIngredientID();
        this.ingredient = recipeIngredient.getIngredient();
        this.amount = recipeIngredient.getAmount();
        this.measurement = recipeIngredient.getMeasurement();
        this.recipes = recipeIngredient.getRecipes();
    }

    public RecipeIngredientDTO() {
    }

    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipe recipes) {
        this.recipes = recipes;
    }
}
