package pl.edu.pl;

import java.util.Scanner;

public class Garden {

    private final int SIZE = 10;
    private Scanner scanner = new Scanner(System.in);

    public void start(){

        Person p1 = new Person("Jan", "Kowalski", 29, Creature.Gender.MALE);
        Person p2 = new Person("Janina", "Kowalska", 31, Creature.Gender.FEMALE);

        Menu menu = new Menu();
        //menu.showMenu(scanner);

        Animal a1 = new Cat("Filemon", 10, Creature.Gender.FEMALE, p1, "dachowiec");
        Animal a2 = new Turtle("Zolwik", 20, Creature.Gender.FEMALE, p1);

        a1.info();
        a2.info();

    }
}
