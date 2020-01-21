package pl.edu.pl;

public abstract class Animal extends Creature {

    private static long animalCount = 1;
    private long ownerId;
    private Position position;

    public Animal( String firstName, int age, Gender gender, long ownerId, Position position) {
        super(animalCount, firstName, age, gender);
        animalCount++;
        this.ownerId = ownerId;
        this.position = position;
    }

    public Animal(Position position) {
        super(animalCount);
        animalCount++;
        this.position = position;
    }

    public void infooo() {
        System.out.println("Zwierzak id: " + getId());
        System.out.println(getFirstName());
        System.out.println("Wiek: " + getAge());
        System.out.println("Plec: " + getGender().getValuePL());
        System.out.println("Pozycja: (" + getPosition().getX() + "," + getPosition().getY() + ")");
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
