package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ND on 3/20/2017.
 */

@RestController
public class ThingsController {

    @RequestMapping("/things")
    public List<Thing> thing(@RequestParam(value = "id")String id) {

        if(id.equals("1"))
            return Arrays.asList(new Thing(1L,"Rascheska",12L),
                                 new Thing(2L,"Maskara",14L)
                                );
        if(id.equals("2"))
            return Arrays.asList(new Thing(3L,"Dremel",16L),
                    new Thing(4L,"Shurupovert",16L)
            );


        return Arrays.asList(new Thing(5L,"Nothing Founded, id was == " + id,0L)    );
    }
}
