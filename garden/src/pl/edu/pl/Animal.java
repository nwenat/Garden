package pl.edu.pl;

public abstract class Animal extends Creature {

    private static long animalCount = 1;
    private long ownerId;
    private Position position;

    public Animal(String firstName, int age, Gender gender, long ownerId) {
        super(animalCount, firstName, age, gender);
        animalCount++;
        this.ownerId = ownerId;

    }

    public void infooo() {
        System.out.println("Id: " + getId());
        System.out.println(getFirstName());
        System.out.println("Wiek: " + getAge());
        System.out.println("Plec: " + getGender().getValuePL());
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////


    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
