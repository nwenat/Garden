package pl.edu.pl;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private List<Person> ownersList = new ArrayList<>();
    private List<Animal> animalsList = new ArrayList<>();

    public void addUser(){
        System.out.println("Dodamy uzytkownika za momencik....");

    }

    public void removeUser(){
        System.out.println("Usuniemy uzytkownika za momencik....");

    }
}
