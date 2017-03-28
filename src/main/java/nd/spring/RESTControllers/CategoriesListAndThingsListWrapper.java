package nd.spring.RESTControllers;

import nd.entities.Category;
import nd.entities.Thing;

import java.util.List;

/**
 * Created by ND on 3/22/2017.
 */
public class CategoriesListAndThingsListWrapper {
    private List<Category> Categories;
    private List<Thing> Things;

    public CategoriesListAndThingsListWrapper() {
    }

    public CategoriesListAndThingsListWrapper(List<Category> categories, List<Thing> things) {
        Categories = categories;
        Things = things;
    }

    public List<Category> getCategories() {
        return Categories;
    }

    public void setCategories(List<Category> categories) {
        Categories = categories;
    }

    public List<Thing> getThings() {
        return Things;
    }

    public void setThings(List<Thing> things) {
        Things = things;
    }
}
