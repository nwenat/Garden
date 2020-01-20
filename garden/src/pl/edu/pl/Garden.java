package pl.edu.pl;

import java.util.Scanner;

public class Garden {

    private final int SIZE = 10;
    private DataBase dataBase = new DataBase();
    private Scanner scanner = new Scanner(System.in);

    public void start(){

        Menu menu = new Menu();
        //menu.showMenu(dataBase);

        new GardenView().showGarden(SIZE);

    }
}
