package Module;

public class Animal {
    private String name;
    private String type;
    private int area;
    private int id;

    public Animal(int id, String name, String type, int area) {
        this.name = name;
        this.type = type;
        this.area = area;
        this.id = id;
    }

    @Override
    public String toString() {
        return name +
                "," + type +
                "," + area +
                "," + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
