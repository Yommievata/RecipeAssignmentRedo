package se.lexicon.group33.yommie.recipeassignmentredo.dto;

import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeInstruction;

import java.io.Serializable;

public class RecipeInstructionDTO implements Serializable {

    private String recipeInstructionId;
    private String recipeInstruction;

    public RecipeInstructionDTO(RecipeInstruction recipeInstruction) {
        this.recipeInstructionId = recipeInstruction.getRecipeInstructionId();
        this.recipeInstruction = recipeInstruction.getRecipeInstruction();
    }

    public RecipeInstructionDTO() {
    }

    public String getRecipeInstructionId() {
        return recipeInstructionId;
    }

    public String getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(String recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }
}
