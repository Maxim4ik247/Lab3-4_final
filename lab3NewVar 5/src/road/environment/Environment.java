package road.environment;

import plants.AbstractPlant;
import plants.*;

import java.util.Objects;

public class Environment {
    private AbstractPlant plant = null;
    public Environment(AbstractPlant plant) {
        this.plant = plant;
    }

    public void printInfo(){
        System.out.println("На участке дороги:");
        try {
            Flower flower = (Flower) plant;
            System.out.println(this.getName() + " с стеблями высотой " + flower.getHeight() + " - " + this.getDescription());
            return;
        } catch (Exception e){

        }

        try {
            Plant plant_ = (Plant) plant;
            if (plant_.isHasStem()){
                System.out.println(this.getName() + " с зелеными стеблями - " + this.getDescription());
            } else{
                System.out.println(this.getName() + " без стебельков - " + this.getDescription());
            }
            return;
        } catch (Exception e){

        }

        try {
            Tree tree = (Tree) plant;
            if (tree.getHeight() > 10){
                System.out.println(this.getName() + " высокие деревья  - " + this.getDescription());
            } else {
                System.out.println(this.getName() + " - " + this.getDescription());
            }
            return;
        } catch (Exception e){

        }
    }

    public String getName() {
        return plant.getName();
    }

    public String getDescription() {
        return plant.getDescription();
    }

    public Color getColor() {
        return plant.getColor();
    }

    public AbstractPlant getPlant() {
        return plant;
    }

    public void setPlant(AbstractPlant plant) {
        this.plant = plant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Environment that)) return false;
        return Objects.equals(plant, that.plant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plant);
    }

    @Override
    public String toString() {
        return "Environment{" +
                "plant=" + plant +
                '}';
    }
}
