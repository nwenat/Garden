package pl.edu.pl;

public class Garden {

    private final int SIZE = 5;
    private GardenPlan gardenPlan = new GardenPlan(SIZE);
    private DataBase dataBase = new DataBase(gardenPlan);

    public void start(){

        Menu menu = new Menu();
        menu.showMenu(dataBase, gardenPlan);
    }
}
