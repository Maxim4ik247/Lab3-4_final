package road;

import road.environment.Color;

import java.util.ArrayList;
import java.util.HashSet;

public class Road {

    private ArrayList<SectionOfRoad> sectionOfRoads = new ArrayList<>();

    public void addToRoad(SectionOfRoad sectionOfRoad){
        try {
            sectionOfRoads.add(sectionOfRoad);
        }
        catch (StackOverflowError e){
            System.out.println("Слишком много участков трассы");
        }
    }

    public HashSet<Color> getView(int index){
        int count  = sectionOfRoads.size();

        HashSet<Color> colors = new HashSet<>();
        ArrayList<Color> colors1 = new ArrayList<>();
        ArrayList<Color> colors2 = new ArrayList<>();
        ArrayList<Color> colors3 = new ArrayList<>();

        // УМНАЯ ФОРМУЛА
        for(SectionOfRoad sectionOfRoad: sectionOfRoads){
            colors.add(sectionOfRoad.getEnvironment().getColor());
            colors1.add(sectionOfRoad.getEnvironment().getColor()); // 40%
            colors2.add(sectionOfRoad.getEnvironment().getColor()); // 40%
            colors3.add(sectionOfRoad.getEnvironment().getColor()); // 20%
        }

        for (int i=index; i<count; i++){
            colors.add(sectionOfRoads.get(i).getEnvironment().getColor());
        }

        if (colors.size() >= 3){
            System.out.println("Словно кто-то раскатал по земле тысячи рулонов пестрых материй");
        }

        System.out.println("Ближе всего были круги: " + colors1);
        System.out.println("Ближе расположились полоски: " + colors2);
        System.out.println("Самые дальние холмы были в крапинку: " + colors3);

        return colors;
    }

    public ArrayList<SectionOfRoad> getSectionOfRoads() {
        return sectionOfRoads;
    }

    public void setSectionOfRoads(ArrayList<SectionOfRoad> sectionOfRoads) {
        this.sectionOfRoads = sectionOfRoads;
    }
}

