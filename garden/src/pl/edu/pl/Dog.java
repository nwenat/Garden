package pl.edu.pl;

public class Dog extends Animal{

    private String breed;

    public Dog(String firstName, int age, Gender gender, Person owner, String breed) {
        super(firstName, age, gender, owner);
        this.breed = breed;
    }

    @Override
    public void info() {
        System.out.println("Dog info");
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
