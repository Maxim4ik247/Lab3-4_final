package plants;

import road.environment.Color;

public class Plant extends AbstractPlant{
    boolean hasStem;
    public Plant(String name, Color color, String description, boolean hasStem) {
        super(name, color, description);
        this.hasStem = hasStem;
    }

    public boolean isHasStem() {
        return hasStem;
    }

    public void setHasStem(boolean hasStem) {
        this.hasStem = hasStem;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "hasStem=" + hasStem +
                '}';
    }
}
