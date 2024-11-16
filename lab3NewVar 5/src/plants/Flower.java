package plants;

import road.environment.Color;

public class Flower extends AbstractPlant {
    private int height;
    public Flower(String name, Color color, String description, int height) {
        super(name, color, description);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "height=" + height +
                '}';
    }
}
