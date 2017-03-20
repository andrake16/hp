package hello;

/**
 * Created by ND on 3/20/2017.
 */
public class Thing {
    private Long id;
    private String thingName;
    private Long CategoryId;

    public Thing(Long id, String thingName, Long categoryId) {
        this.id = id;
        this.thingName = thingName;
        CategoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }
}