package pl.edu.pl;

public class Garden {

    private final int SIZE = 5;
    private GardenPlan gardenPlan = new GardenPlan(SIZE);
    private DataBase dataBase = new DataBase(gardenPlan);
    private CreatureFileReader creatureFileReader = new CreatureFileReader();

    public void start(){

        dataBase.setOwnersList(creatureFileReader.readUsers());
        dataBase.setAnimalsListAndAddToTable(creatureFileReader.readAnimals());
        Menu menu = new Menu();
        menu.showMenu(dataBase, gardenPlan);
    }
}
