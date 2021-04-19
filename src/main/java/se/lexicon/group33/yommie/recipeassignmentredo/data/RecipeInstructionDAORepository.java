package se.lexicon.group33.yommie.recipeassignmentredo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeInstruction;

import javax.persistence.EntityManager;
import java.util.Collection;

public class RecipeInstructionDAORepository implements RecipeInstructionDAO {

    @Autowired
    private final EntityManager entityManager;

    @Autowired
    public RecipeInstructionDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional(readOnly = true)
    public RecipeInstruction findById(Integer recipeInstructionId) {
        return entityManager.find(RecipeInstruction.class, recipeInstructionId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<RecipeInstruction> findAll() {
        return entityManager.createQuery("select recipeInstruction from RecipeInstruction recipeInstruction", RecipeInstruction.class).getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeInstructionDAO create(RecipeInstructionDAO recipeInstruction) {
        entityManager.persist(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeInstructionDAO update(RecipeInstructionDAO recipeInstruction) {
        return entityManager.merge(recipeInstruction);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer recipeInstructionId) {
        RecipeInstruction toDelete = (RecipeInstruction) findById(recipeInstructionId);
        if (toDelete != null){
            entityManager.remove(toDelete);
            System.out.println("Recipe Instruction " + recipeInstructionId + " has been removed ");
        } else {
            throw new IllegalArgumentException("Recipe Instruction with ID " + recipeInstructionId + " not found.");
        }
    }
}
