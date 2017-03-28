package nd.spring.RESTControllers;

import nd.entities.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ND on 3/20/2017.
 */
@RestController
public class CategoryController {
    @RequestMapping(value = "/getCategories")
    public List<Category> getCategories(@RequestParam(value = "categoryName", defaultValue = "name is not specified") String name) {
        return Arrays.asList(
                new Category(1L, "fintiflushki"),
                new Category(2L, "instrument")
        );
    }

    @RequestMapping(value = "/categoriesWOParams",method = RequestMethod.POST)
    public ResponseEntity<Category> categoriesWOParams() {
        Category category1 = new Category(1L, "fintiflushki");
        Category category2 = new Category(2L, "instrument");
        return new ResponseEntity<Category>(category1, HttpStatus.OK);
    }

    @RequestMapping(value = "/categoriesWOParams2",method = RequestMethod.POST)
    public Category categoriesWOParams2() {
        Category category1 = new Category(1L, "fintiflushki");
        Category category2 = new Category(2L, "instrument");
        return category1;
    }

    @RequestMapping(value = "/categories",method = RequestMethod.POST)
    public ResponseEntity<List<Category>> categories(@RequestBody List<Category> category) {
        Category category1 = new Category(1L, "fintiflushki");
        Category category2 = new Category(2L, "instrument");

        return new ResponseEntity<List<Category>>(Arrays.asList(category1,category2), HttpStatus.OK);
    }



    @RequestMapping(value = "/categoryUpdate",method = RequestMethod.POST)
    public ResponseEntity<Category> categoryUpdate(@RequestBody Category category) {
        Logger.getAnonymousLogger().info("************" + category.toString());
        return new ResponseEntity<Category>(category, HttpStatus.OK);


    }
}
