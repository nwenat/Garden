package pl.edu.pl;

import java.util.*;
import java.util.stream.Collectors;

public class DataBase {

    private List<Person> ownersList = new ArrayList<>();
    private List<Animal> animalsList = new ArrayList<>();
    private GardenPlan gardenPlan;
    private QuestionsToUser query = new QuestionsToUser();

    public DataBase(GardenPlan gardenPlan) {
        this.gardenPlan = gardenPlan;
    }

    public void addUser(){
        Person owner = new Person();
        owner.setFirstName(query.askForName("imie"));
        owner.setLastName(query.askForName("nazwisko"));
        owner.setAge(query.askForAge());
        owner.setGender(query.askForGender());

        ownersList.add(owner);
        System.out.println("Nowy uzytkownik zostal dodany.");
    }

    public void removeUser(){
        showOwnerList();

        long idUserToRemove = query.askForId("wlasciciela ktory ma zostac usuniety");
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
        Animal newAnimal = query.askWhichAnimal(gardenPlan);

        newAnimal.setFirstName(query.askForName("imie"));
        newAnimal.setAge(query.askForAge());
        newAnimal.setGender(query.askForGender());
        newAnimal.setOwnerId(query.askForId("wlasciciela"));

        if(newAnimal instanceof Cat){
            ((Cat)newAnimal).setBreed(query.askForName("rase"));
        } else if (newAnimal instanceof Dog){
            ((Dog)newAnimal).setBreed(query.askForName("rase"));
        }
        gardenPlan.addAnimalToTable(newAnimal);
        animalsList.add(newAnimal);

        System.out.println("Nowe zwierze zostalo dodane.");
    }

    public void removeAnimal(){
        showAnimalsList();

        long idAnimalToRemove = query.askForId("zwierzecia ktore ma zostac usuniete");
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
        long idTurtle = query.askForId("zolwia ktory ma zostac nakarmiony");

        Animal animal = animalFromId(idTurtle);
        if (animal != null && animal instanceof Turtle){
            ((Turtle)animal).feed();
        } else{
            System.out.println("Blednie podany id, nie ma tekiego zwierzecia");
        }
    }

    public void moveAnimal(){
        showAnimalsList();
        long idAnimalForMove = query.askForId("zwierzecia ktore ma byc przesuniete");
        Animal animalForMove = animalFromId(idAnimalForMove);
        if (animalForMove != null){
            if(animalForMove instanceof Turtle && ((Turtle) animalForMove).getCondition() == Turtle.Condition.HIDDEN){
                System.out.println("Zolw jest schowany i nie mozna go przesunac, najpierw go nakarm.");
            } else {
                Direction direction = query.askForDirection();
                gardenPlan.move(animalForMove, direction);
            }
        }
    }

    private void showTurtleList(){
        System.out.println("----LISTA ZOLWI----");
        animalsList.stream().filter(a -> a instanceof Turtle)
                .forEach(o -> o.info());
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
