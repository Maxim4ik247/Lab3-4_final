package plants;

import road.environment.Color;

public class Tree extends AbstractPlant {
    private int height;
    private int age;
    public Tree(String name, Color color, String description, int height, int age) {
        super(name, color, description);
        this.height = height;
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "height=" + height +
                '}';
    }
}
