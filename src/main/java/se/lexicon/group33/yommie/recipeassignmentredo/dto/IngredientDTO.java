package se.lexicon.group33.yommie.recipeassignmentredo.dto;

import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Ingredient;

import java.io.Serializable;

public class IngredientDTO implements Serializable {

    private int ingredientId;
    private String ingredientName;

    public IngredientDTO(Ingredient ingredient) {
        if (ingredient != null) {
            this.ingredientId = ingredient.getIngredientId();
            this.ingredientName = ingredient.getIngredientName();
        }
    }

    public IngredientDTO() {
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }
}
