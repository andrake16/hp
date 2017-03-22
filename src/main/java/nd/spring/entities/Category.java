package nd.spring.entities;

/**
 * Created by ND on 3/20/2017.
 */
public class Category {
    private Long id;
    private String CategoryName;

    public Category() {
    }

    public Category(Long id, String categoryName) {
        this.id = id;
        CategoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
