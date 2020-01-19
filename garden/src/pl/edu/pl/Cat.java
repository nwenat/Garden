package pl.edu.pl;

public class Cat extends Animal{

    private String breed;

    public Cat(String firstName, int age, Gender gender, long ownerId, String breed) {
        super(firstName, age, gender, ownerId);
        this.breed = breed;
    }

    public Cat() {
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
