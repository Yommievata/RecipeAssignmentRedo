package se.lexicon.group33.yommie.recipeassignmentredo.model.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int recipeCategoryId;
    private String category;

   @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private Collection<Recipe> recipes;

    public RecipeCategory(int recipeCategoryId, String category, Collection<Recipe> recipes) {
        this.recipeCategoryId = recipeCategoryId;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategory() {
    }

    public int getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Collection<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Collection<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return recipeCategoryId == that.recipeCategoryId && Objects.equals(category, that.category) && Objects.equals(recipes, that.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeCategoryId, category, recipes);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "recipeCategoryId=" + recipeCategoryId +
                ", category='" + category + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
