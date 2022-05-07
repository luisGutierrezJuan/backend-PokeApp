package ps.pokappdex.project.model;

public class Move {
    private String name;
    private String description;
    private String basePower;
    private String baseAccuracy;
    private String type;
    private String category;

    public Move() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBasePower() {
        return basePower;
    }

    public void setBasePower(String basePower) {
        this.basePower = basePower;
    }

    public String getBaseAccuracy() {
        return baseAccuracy;
    }

    public void setBaseAccuracy(String baseAccuracy) {
        this.baseAccuracy = baseAccuracy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
