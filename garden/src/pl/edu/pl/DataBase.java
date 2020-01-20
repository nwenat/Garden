package pl.edu.pl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class DataBase {

    private Set<Person> ownersList = new HashSet<>();
    private Set<Animal> animalsList = new HashSet<>();
    private Scanner scanner = new Scanner(System.in);

    public void addUser(){
        Person owner = new Person();
        owner.setFirstName(askForName("imie"));
        owner.setLastName(askForName("nazwisko"));
        owner.setAge(askForAge());
        owner.setGender(askForGender());

        ownersList.add(owner);
        System.out.println("Nowy uzytkownik zostal dodany.");
    }

    public void removeUser(){
        showOwnerList();

        long idUserToRemove = askForId("wlasciciela ktory ma zostac usuniety");
        Person ownerToRemove = personFromId(idUserToRemove);

        if (ownerToRemove != null){
            ownersList.remove(ownerToRemove);
            System.out.println("Wlasciciel zostal usuniety");
        } else{
            System.out.println("Blednie podany id, nie ma tekiego wlasciciela");
        }
    }

    public void showOwnerList(){
        System.out.println("----LISTA WLASCICIELI----");
        for (Person person : ownersList) {
            person.info();
            Set<Animal> ownerPets = animalsList.stream().filter(a -> a.getOwnerId() == person.getId())
                    .collect(Collectors.toSet());
            if (!ownerPets.isEmpty()){
                System.out.println("   Zwierzaki: ");
                ownerPets.stream().forEach(p -> p.info());
            }
            System.out.println("//////////////////////");
        }
    }

    public void showAnimalsList(){
        animalsList.stream().forEach(o -> o.info());
        System.out.println("//////////////////////");
    }

    public void addAnimal(){
        Animal newAnimal = askWhichAnimal();

        newAnimal.setFirstName(askForName("imie"));
        newAnimal.setAge(askForAge());
        newAnimal.setGender(askForGender());

        newAnimal.setOwnerId(askForId("wlasciciela"));

        if(newAnimal instanceof Cat || newAnimal instanceof Dog){
            ((Cat)newAnimal).setBreed(askForName("rase"));
        }

        System.out.println("Nowe zwierze zostalo dodane.");
    }

    public void removeAnimal(){
        showAnimalsList();

        long idAnimalToRemove = askForId("zwierzecia ktore ma zostac usuniete");

        Animal animalToRemove = animalFromId(idAnimalToRemove);

        if (animalToRemove != null){
            animalsList.remove(animalToRemove);
            System.out.println("Zwierze zostalo usuniete");
        } else{
            System.out.println("Blednie podany id, nie ma tekiego zwierzecia");
        }
    }

    public void feedTurtle(){
        showTurtleList();
        long idTurtle = askForId("zolwia ktory ma zostac nakarmiony");

        Animal animal = animalFromId(idTurtle);
        if (animal != null && animal instanceof Turtle){
            ((Turtle)animal).feed();
        } else{
            System.out.println("Blednie podany id, nie ma tekiego zwierzecia");
        }
    }

    public void moveAnimal(){
        showAnimalsList();
        long idAnimalForMove = askForId("zwierzecia ktore ma byc przesuniete");
        Animal animalForMove = animalFromId(idAnimalForMove);
        if (animalForMove != null){
            Direction direction = askForDirection();
            System.out.println("Jakos sie przesunie, albo i nie??????");
        }
    }

    private void showTurtleList(){
        System.out.println("----LISTA ZOLWI----");
        animalsList.stream().filter(a -> a instanceof Turtle)
                .forEach(o -> o.info());
    }

    private String askForName(String name){
        String word;
        System.out.println("Podaj " + name + ": ");
        word = scanner.nextLine();
        return word;
    }

    private int askForAge(){
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
        return age;
    }

    private Creature.Gender askForGender(){
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
        return gender;
    }

    private Direction askForDirection(){
        Direction direction = null;
        String directionSymbol = "";
        do {
            System.out.println("Podaj kierunek przesuniecia\n   G\nL     P\n   D");
            directionSymbol = scanner.next();
            if(directionSymbol.toLowerCase().equals("g")){
                direction = Direction.UP;
            } else if(directionSymbol.toLowerCase().equals("d")){
                direction = Direction.DOWN;
            }else if(directionSymbol.toLowerCase().equals("l")){
                direction = Direction.LEFT;
            }else if(directionSymbol.toLowerCase().equals("p")){
                direction = Direction.RIGHT;
            } else {
                System.out.println("bledna wartosc!");
            }
        } while (direction == null);
        return direction;
    }

    private Animal askWhichAnimal(){
        Animal animal = null;
        String animalSymbol = "";
        do {
            System.out.println("Podaj jakie chcesz storzyc ziwerze: \n zolw - z    kot - k    pies -p");
            animalSymbol = scanner.next();
            if(animalSymbol.toLowerCase().equals("z")){
                animal = new Turtle();
            } else if(animalSymbol.toLowerCase().equals("k")){
                animal = new Cat();
            } else if(animalSymbol.toLowerCase().equals("p")){
                animal = new Dog();
            }else {
                System.out.println("bledna wartosc, podaj jeszcze raz z / k / p ");
            }
        } while (animal == null);
        return animal;
    }

    private long askForId(String name){
        System.out.println("Podaj id " + name + ": ");
        long id = 0;
        do {
            try {
                id = scanner.nextLong();
            } catch (Exception e) {
                scanner.next();
            }
            if(id < 1){
                System.out.println("Bledna wartosc, podaj id jeszcze raz");
            }
        } while (id < 1);
        return id;
    }

    private Animal animalFromId(long id){
        for (Animal animal : animalsList) {
            if (animal.getId() == id){
                return animal;
            }
        }
        return null;
    }

    private Person personFromId(long id){
        for (Person person : ownersList) {
            if (person.getId() == id){
                return person;
            }
        }
        return null;
    }

    private Creature creatureFromId(Set<Creature> set, long id){

        for (Creature creature : set) {
            if (creature.getId() == id){
                return creature;
            }
        }
        return null;
    }

    public DataBase() {
        Person p1 = new Person("Jan", "Kowalski", 29, Creature.Gender.MALE);
        Person p2 = new Person("Janina", "Kowalska", 31, Creature.Gender.FEMALE);
        Person p3 = new Person("Kasia", "Turman", 31, Creature.Gender.FEMALE);
        Person p4 = new Person("Michal", "Doro", 29, Creature.Gender.MALE);

        Animal a1 = new Cat("Filemon", 10, Creature.Gender.FEMALE, 2, "dachowiec");
        Animal a2 = new Turtle("Zolwik", 20, Creature.Gender.FEMALE, 3);

        ownersList.add(p1);
        ownersList.add(p2);
        ownersList.add(p3);
        ownersList.add(p4);

        animalsList.add(a1);
        animalsList.add(a2);
    }
}
