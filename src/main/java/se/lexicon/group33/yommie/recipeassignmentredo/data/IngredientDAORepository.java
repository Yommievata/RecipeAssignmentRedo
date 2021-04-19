package se.lexicon.group33.yommie.recipeassignmentredo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Ingredient;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.Optional;

public class IngredientDAORepository implements IngredientDAO{

    private final EntityManager entityManager;

    @Autowired
    private IngredientDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional(readOnly = true)
    public Ingredient findById(Integer ingredientId) {
        return entityManager.find(Ingredient.class, ingredientId);
    }


    @Override
    @Transactional(readOnly = true)
    public Collection<Ingredient> findAll() {
        return entityManager.createQuery("SELECT ingredient FROM Ingredient ingredient", Ingredient.class).getResultList();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Ingredient create(Ingredient ingredient) {
        entityManager.persist(ingredient);
        return ingredient;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Ingredient update(Ingredient ingredient) {
        return entityManager.merge(ingredient);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void delete(Integer ingredientId) {
       Ingredient toDelete = findById(ingredientId);
       if (toDelete != null){
           entityManager.remove(toDelete);
           System.out.println("Ingredient with ID " + ingredientId + " has been removed ");
       } else {
           throw new IllegalArgumentException("Ingredient with ID " + ingredientId + " not found.");
       }
    }
}
