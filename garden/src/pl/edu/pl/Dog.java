package pl.edu.pl;

public class Dog extends Animal{

    private String breed;

    public Dog(String firstName, int age, Gender gender, long ownerId, String breed, Position position) {
        super(firstName, age, gender, ownerId, position);
        this.breed = breed;
    }

    public Dog(Position position) {
        super(position);
    }

    @Override
    public void info() {
        super.infooo();
        System.out.println("Rasa: " + breed);
        System.out.println("--------------");
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
