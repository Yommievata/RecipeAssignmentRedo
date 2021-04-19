package se.lexicon.group33.yommie.recipeassignmentredo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Recipe;


import javax.persistence.EntityManager;
import java.util.Collection;

public class RecipeDAORepository implements RecipeDAO{

    private final EntityManager entityManager;

    @Autowired
    public RecipeDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public Recipe findById(Integer recipeId) {
        return entityManager.find(Recipe.class,recipeId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Recipe> findAll() {
        return entityManager.createQuery("select recipe from Recipe recipe", Recipe.class).getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Recipe create(Recipe recipe) {
        entityManager.persist(recipe);
        return recipe;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Recipe update(Recipe recipe) {
        return entityManager.merge(recipe);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer recipeId) {
        Recipe toDelete = findById(recipeId);
        if (recipeId != null){
            entityManager.remove(toDelete);
            System.out.println("Recipe with ID " + recipeId + "has been removed.");
        }
        throw new IllegalArgumentException("Recipe with ID " + recipeId + " can't be found.");
    }
}
