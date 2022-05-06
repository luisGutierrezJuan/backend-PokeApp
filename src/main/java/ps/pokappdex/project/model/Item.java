package ps.pokappdex.project.model;

public class Item {
    private String name;
    private String category;     //category
    private String description;    //description
    private String image;

    public Item() {

    }

    public Item(String name, String category, String description){
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
