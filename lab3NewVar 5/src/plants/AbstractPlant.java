package plants;

import road.environment.Color;

import java.util.Objects;

public abstract class AbstractPlant {
    private String name;
    private Color color;
    private String description;

    public AbstractPlant(String name, Color color, String description) {
        this.name = name;
        this.color = color;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPlant that)) return false;
        return Objects.equals(name, that.name) && color == that.color && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, description);
    }

    @Override
    public String toString() {
        return "AbstractPlant{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", description='" + description + '\'' +
                '}';
    }
}
