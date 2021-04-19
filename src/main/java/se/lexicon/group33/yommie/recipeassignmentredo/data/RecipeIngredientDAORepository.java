package se.lexicon.group33.yommie.recipeassignmentredo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Ingredient;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeIngredient;

import javax.persistence.EntityManager;
import java.util.Collection;

public class RecipeIngredientDAORepository implements RecipeIngredientDAO{
    @Autowired
    private final EntityManager entityManager;

    public RecipeIngredientDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeIngredient findById(Integer recipeIngredientId) {
        return entityManager.find(RecipeIngredient.class, recipeIngredientId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<RecipeIngredient> findAll() {
        return entityManager.createQuery("select recipeIngredient from RecipeIngredient recipeIngredient", RecipeIngredient.class).getResultList();}

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredient create(RecipeIngredient recipeIngredient) {
        entityManager.persist(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeIngredient update(RecipeIngredient recipeIngredient) {
        return entityManager.merge(recipeIngredient);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer recipeIngredientId) {
        RecipeIngredient toDelete = findById(recipeIngredientId);
        if (toDelete != null){
            entityManager.remove(toDelete);
            System.out.println("Recipe Ingredient with ID " + recipeIngredientId + " has been removed ");
        } else {
            throw new IllegalArgumentException("Recipe Ingredient with ID " + recipeIngredientId + " not found.");
        }

    }
}
