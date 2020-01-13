package pl.edu.pl;

public class Cat extends Animal{

    private String breed;

    public Cat(String firstName, int age, Gender gender, Person owner, String breed) {
        super(firstName, age, gender, owner);
        this.breed = breed;
    }

    @Override
    public void info() {
        System.out.println("Cat info");
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
