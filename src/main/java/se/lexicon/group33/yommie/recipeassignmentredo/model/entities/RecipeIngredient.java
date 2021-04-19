package se.lexicon.group33.yommie.recipeassignmentredo.model.entities;

import org.hibernate.annotations.GenericGenerator;
import se.lexicon.group33.yommie.recipeassignmentredo.model.meas.Measurement;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeIngredientID;

    @ManyToOne(
            cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY
    )
    @JoinColumn( table = "ingredient")
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;

    @ManyToOne(
            cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH}, fetch = FetchType.LAZY
    )
    @JoinColumn(table = "recipes")
    private Recipe recipes;

    public RecipeIngredient(String recipeIngredientID, Ingredient ingredient, double amount, Measurement measurement, Recipe recipes) {
        this.recipeIngredientID = recipeIngredientID;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipes = recipes;
    }

    public RecipeIngredient(Measurement measurement, Recipe recipes) {
        this.measurement = measurement;
        this.recipes = recipes;
    }

    public RecipeIngredient() {
    }


    public String getRecipeIngredientID() {
        return recipeIngredientID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(recipeIngredientID, that.recipeIngredientID) && Objects.equals(ingredient, that.ingredient) && measurement == that.measurement && Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeIngredientID, ingredient, amount, measurement, recipes);
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeIngredientID='" + recipeIngredientID + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", recipes=" + recipes +
                '}';
    }
}
