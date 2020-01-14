package pl.edu.pl;

public abstract class Animal extends Creature {

    private static long animalCount = 1;
    private Person owner;
    private Position position;

    public Animal(String firstName, int age, Gender gender, Person owner) {
        super(animalCount, firstName, age, gender);
        animalCount++;
        this.owner = owner;
        this.position = new Position(0, 0);
    }

    public void infooo() {
        System.out.println("Id: " + getId());
        System.out.println(getFirstName());
        System.out.println("Wiek: " + getAge());
        System.out.println("Plec: " + getGender().getValuePL());
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
