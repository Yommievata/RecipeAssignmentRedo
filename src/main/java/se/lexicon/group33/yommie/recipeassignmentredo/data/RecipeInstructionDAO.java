package se.lexicon.group33.yommie.recipeassignmentredo.data;

import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeInstruction;

import java.util.Collection;

public interface RecipeInstructionDAO {
    RecipeInstruction findById(Integer recipeInstructionId);
    Collection<RecipeInstruction> findAll();
    RecipeInstructionDAO create(RecipeInstructionDAO recipeInstruction);
    RecipeInstructionDAO update(RecipeInstructionDAO recipeInstruction);
    void delete (Integer recipeInstructionId);
}
