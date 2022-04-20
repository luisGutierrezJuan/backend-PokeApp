package ps.pokappdex.project.model;

public class Item {
    private String name;
    private String catg;     //category
    private String desc;    //description


    public Item(String name, String category, String description){
        this.name = name;
        this.catg = category;
        this.desc = description;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.catg;
    }

    public String getDescription() {
        return this.desc;
    }
}
