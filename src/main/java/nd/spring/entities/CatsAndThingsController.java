package nd.spring.entities;

import nd.spring.RESTControllers.CategoriesListAndThingsListWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ND on 3/22/2017.
 */
@RestController
public class CatsAndThingsController {
    @RequestMapping(value = "/catsAndThings", method = RequestMethod.POST)
        public  ResponseEntity<CategoriesListAndThingsListWrapper> catsAndThings() {

            Category category1 = new Category(1L, "fintiflushki");
            Category category2 = new Category(2L, "instrument");
            List<Category> categoryList =  Arrays.asList(category1,category2);

            List<Thing> thingList =  Arrays.asList(
                    new Thing(1L,"Rascheska",12L),
                    new Thing(2L,"Maskara",14L)
            );


            CategoriesListAndThingsListWrapper wrappedObjs = new CategoriesListAndThingsListWrapper(categoryList,thingList);
            return new ResponseEntity<CategoriesListAndThingsListWrapper>(wrappedObjs, HttpStatus.OK);

        }

    }

