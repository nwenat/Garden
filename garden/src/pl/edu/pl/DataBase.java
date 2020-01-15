package pl.edu.pl;

import java.util.HashSet;
import java.util.Set;

public class DataBase {

    private Set<Person> ownersList = new HashSet<>();
    private Set<Animal> animalsList = new HashSet<>();

    public void addUser(Person owner){
        ownersList.add(owner);
    }

    public void removeUser(Person owner){
        ownersList.remove(owner);
    }

    public void showOwnerList(){
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
        Person p4 = new Person("Michal", "Doro", 29, Creature.Gender.MALE);

        Animal a1 = new Cat("Filemon", 10, Creature.Gender.FEMALE, p1, "dachowiec");
        Animal a2 = new Turtle("Zolwik", 20, Creature.Gender.FEMALE, p3);

        ownersList.add(p1);
        ownersList.add(p2);
        ownersList.add(p3);
        ownersList.add(p4);

        animalsList.add(a1);
        animalsList.add(a2);
    }
}
