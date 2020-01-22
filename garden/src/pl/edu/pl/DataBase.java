package pl.edu.pl;

import java.util.*;
import java.util.stream.Collectors;

public class DataBase {

    private List<Person> ownersList = new ArrayList<>();
    private List<Animal> animalsList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private GardenPlan gardenPlan;

    public DataBase(GardenPlan gardenPlan) {
        this.gardenPlan = gardenPlan;
    }

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
            animalsList.stream().filter(a -> a.getOwnerId() == ownerToRemove.getId())
                    .forEach(a -> a.setOwnerId(0));

            System.out.println("Wlasciciel zostal usuniety");
        } else{
            System.out.println("Blednie podany id, nie ma tekiego wlasciciela");
        }
    }

    public void showOwnerList(){
        System.out.println("----LISTA WLASCICIELI----");
        for (Person person : ownersList) {
            person.info();
            List<Animal> ownerPets = animalsList.stream().filter(a -> a.getOwnerId() == person.getId())
                    .collect(Collectors.toList());
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

        if(newAnimal instanceof Cat){
            ((Cat)newAnimal).setBreed(askForName("rase"));
        } else if (newAnimal instanceof Dog){
            ((Dog)newAnimal).setBreed(askForName("rase"));
        }
        gardenPlan.addAnimalToTable(newAnimal);
        animalsList.add(newAnimal);

        System.out.println("Nowe zwierze zostalo dodane.");
    }

    public void removeAnimal(){
        showAnimalsList();

        long idAnimalToRemove = askForId("zwierzecia ktore ma zostac usuniete");
        Animal animalToRemove = animalFromId(idAnimalToRemove);
        if (animalToRemove != null){
            gardenPlan.removeAnimalFromTable(animalToRemove);
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
            if(animalForMove instanceof Turtle && ((Turtle) animalForMove).getCondition() == Turtle.Condition.HIDDEN){
                System.out.println("Zolw jest schowany i nie mozna go przesunac, najpierw go nakarm.");
            } else {
                Direction direction = askForDirection();
                gardenPlan.move(animalForMove, direction);
            }
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
        word = scanner.next();
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
                System.out.println("Bledna wartosc!");
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
                System.out.println("Bledna wartosc!");
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
                animal = new Turtle(gardenPlan.nextFreeSpot());
            } else if(animalSymbol.toLowerCase().equals("k")){
                animal = new Cat(gardenPlan.nextFreeSpot());
            } else if(animalSymbol.toLowerCase().equals("p")){
                animal = new Dog(gardenPlan.nextFreeSpot());
            }else {
                System.out.println("Bledna wartosc!");
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

    public void setAnimalsListAndAddToTable(List<Animal> animalsList) {
        this.animalsList = animalsList;
        animalsList.stream().forEach(a -> gardenPlan.addAnimalToTable(a));
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public List<Person> getOwnersList() {
        return ownersList;
    }

    public List<Animal> getAnimalsList() {
        return animalsList;
    }

    public void setOwnersList(List<Person> ownersList) {
        this.ownersList = ownersList;
    }
}
