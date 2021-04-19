package se.lexicon.group33.yommie.recipeassignmentredo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.RecipeCategory;

import javax.persistence.EntityManager;
import java.util.Collection;

public class RecipeCategoryDAORepository implements RecipeCategoryDAO{

    private final EntityManager entityManager;

    @Autowired
    public RecipeCategoryDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public RecipeCategory findById(Integer recipeCategoryId) {
        return entityManager.find(RecipeCategory.class, recipeCategoryId);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<RecipeCategory> findAll() {
        return entityManager.createQuery("SELECT recipeCategory FROM RecipeCategory recipeCategory", RecipeCategory.class).getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeCategory create(RecipeCategory recipeCategory) {
        entityManager.persist(recipeCategory);
        return recipeCategory;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RecipeCategory update(RecipeCategory recipeCategory) {
        return entityManager.merge(recipeCategory);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer recipeCategoryId) {
        RecipeCategory toDelete = findById(recipeCategoryId);
        if (recipeCategoryId != null){
            entityManager.remove(toDelete);
            System.out.println("Recipe category with ID " + recipeCategoryId + "has been removed.");
        }
        throw new IllegalArgumentException("Recipe category " + recipeCategoryId + " can't be found.");
    }
}
