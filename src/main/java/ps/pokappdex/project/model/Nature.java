package ps.pokappdex.project.model;

public class Nature {
    private String name;
    private String plus;
    private String minus;

    public Nature(String name, String plus, String minus) {
        this.name = name;
        this.plus = plus;
        this.minus = minus;
    }

    public String getName() {
        return name;
    }

    public String getPlus() {
        return plus;
    }

    public String getMinus() {
        return minus;
    }
}
