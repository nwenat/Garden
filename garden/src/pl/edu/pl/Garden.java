package pl.edu.pl;

import java.util.Scanner;

public class Garden {

    private Scanner scanner = new Scanner(System.in);

    public void start(){

        Menu menu = new Menu();
        menu.showMenu(scanner);

    }
}
