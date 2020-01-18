package pl.edu.pl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DataBase {

    private Set<Person> ownersList = new HashSet<>();
    private Set<Animal> animalsList = new HashSet<>();
    private Scanner scanner = new Scanner(System.in);

    public void addUser(){
        Person owner = new Person();
        System.out.println("Podaj imie: ");
        owner.setFirstName(scanner.nextLine());
        System.out.println("Podaj nazwisko: ");
        owner.setLastName(scanner.nextLine());
        System.out.println("Podaj wiek: ");
        int age = 0;
        do {
            try {
                age = scanner.nextInt();
            } catch (Exception e) {
                scanner.next();
            }
            if(age < 1){
                System.out.println("Bledna wartosc, podaj wiek jeszcze raz");
            }
        } while (age < 1);
        owner.setAge(age);
        Creature.Gender gender = null;
        String genderSymbol = "";
        do {
            System.out.println("Podaj plec K / M: ");
            genderSymbol = scanner.next();
            if(genderSymbol.toLowerCase().equals("k")){
                gender = Creature.Gender.FEMALE;
            } else if(genderSymbol.toLowerCase().equals("m")){
                gender = Creature.Gender.MALE;
            } else {
                System.out.println("bledna wartosc, podaj jeszcze raz K / M: ");
            }
        } while (gender == null);
        owner.setGender(gender);
        ownersList.add(owner);
        System.out.println("Nowy uzytkownik zostal dodany.");
    }

    public void removeUser(){
        showOwnerList();
        System.out.println("Podaj id wlasciciela ktory ma zostac usuniety: ");
        long idUserToRemove = 0;
        do{
            try{
                idUserToRemove = scanner.nextLong();
            } catch (Exception e){
                scanner.next();
                System.out.println("Bledna wartosc, podaj numer: ");
            }
        } while (idUserToRemove < 0);

        Person ownerToRemove = null;
        for (Person person : ownersList) {
            if (person.getId() == idUserToRemove){
                ownerToRemove = person;
            }
        }
        if (ownerToRemove != null){
            ownersList.remove(ownerToRemove);
            System.out.println("Wlasciciel zostal usuniety");
        } else{
            System.out.println("Blednie podany id, nie ma tekiego wlasciciela");
        }
    }

    public void showOwnerList(){
        System.out.println("----LISTA WLASCICIELI----");
        ownersList.stream().forEach(o -> o.info());
    }

    public void addAnimal(Animal animal){
        animalsList.add(animal);
    }

    public void removeAnimal(Animal animal){
        animalsList.remove(animal);
    }

    public void showAnimalsList(){
        animalsList.stream().forEach(o -> o.info());
    }

    public DataBase() {
        Person p1 = new Person("Jan", "Kowalski", 29, Creature.Gender.MALE);
        Person p2 = new Person("Janina", "Kowalska", 31, Creature.Gender.FEMALE);
        Person p3 = new Person("Kasia", "Turman", 31, Creature.Gender.FEMALE);
        //Person p4 = new Person("Michal", "Doro", 29, Creature.Gender.MALE);

        Animal a1 = new Cat("Filemon", 10, Creature.Gender.FEMALE, 2, "dachowiec");
        Animal a2 = new Turtle("Zolwik", 20, Creature.Gender.FEMALE, 3);

        ownersList.add(p1);
        ownersList.add(p2);
        ownersList.add(p3);
        //ownersList.add(p4);

        animalsList.add(a1);
        animalsList.add(a2);
    }
}
