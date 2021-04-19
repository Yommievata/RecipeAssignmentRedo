package se.lexicon.group33.yommie.recipeassignmentredo.data;


import se.lexicon.group33.yommie.recipeassignmentredo.model.entities.Ingredient;


import java.util.Collection;

public interface IngredientDAO {

    Ingredient findById(Integer ingredientId);
    Collection<Ingredient> findAll();
    Ingredient create(Ingredient ingredient);
    Ingredient update(Ingredient ingredient);
    void delete(Integer ingredientId);
}
