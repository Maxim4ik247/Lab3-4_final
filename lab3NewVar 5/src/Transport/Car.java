package Transport;

import Exceptions.CarOverloadException;
import Traveller.Traveller;
import Traveller.interfaces.ToSeat;
import Traveller.interfaces.ToSee;
import road.Road;
import road.environment.Color;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Car {
    private String name;
    private int capacity;
    private ArrayList<Traveller> humans = new ArrayList<>();


    public Car(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void go(Road road){
        int number = road.getSectionOfRoads().size();
        boolean upIsOver = false;
        for (int i = 0; i<number; i++){
            System.out.println("-------------------");
            switch (road.getSectionOfRoads().get(i).getGradient()){
                case UP:
                    System.out.println("Дорога идет вверх вверх");
                    System.out.println("Путешественники еду среди:");
                    road.getSectionOfRoads().get(i).getEnvironment().printInfo();
                    upIsOver = true;
                    break;
                case DOWN:
                    System.out.println("Дорога пошла вниз");
                    road.getSectionOfRoads().get(i).getEnvironment().printInfo();
                    break;
                case STREIGHT:
                    System.out.println("Машина едет вперед, путешественников окружает:");
                    road.getSectionOfRoads().get(i).getEnvironment().printInfo();

                    if(upIsOver){
                        System.out.println("Подъем закончился, перед путешественниками открылась картина:");

                        HashSet<Color> colors = road.getView(i);

                        boolean nobodySaw = true;
                        for (Traveller traveller: humans){
                            if (traveller.haveSeen(colors)){
                                System.out.println("==" + traveller.getName() + " уже видел подобный пейзаж==");
                                nobodySaw = false;
                            }
                        }
                        if (nobodySaw){
                            System.out.println("==Никто из пассажиров никогда не видел такой картины==");
                        }
                        humans.forEach(traveller -> traveller.see(colors));

                        upIsOver = false;
                    }
                    break;
            }
            System.out.println("-------------------");
        }
    }

    public void seat(ToSeat passenger){
        if (capacity>0) {
            humans.add((Traveller) passenger);
            capacity-=1;
        }
        else {
            throw new CarOverloadException("транспорт перегружен");
            }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return capacity == car.capacity && Objects.equals(name, car.name) && Objects.equals(humans, car.humans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity, humans);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", humans=" + humans +
                '}';
    }
}
