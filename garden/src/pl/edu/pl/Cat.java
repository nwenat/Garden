package pl.edu.pl;

public class Cat extends Animal implements Writable{

    private String breed;

    public Cat(String firstName, int age, Gender gender, long ownerId, String breed, Position position) {
        super(firstName, age, gender, ownerId, position);
        this.breed = breed;
    }

    public Cat(Position position) {
        super(position);
    }

    @Override
    public void info() {
        super.infoBegining();
        System.out.println("Rasa: " + breed);
        System.out.println("--------------");
    }

    @Override
    public String getDataToSave() {
        String result = "";
        result += getDataToSaveBeginning();
        result += getBreed() + ",";
        result += "k\n";
        return result;
    }

    @Override
    public String getFileName() {
        return "animals.txt";
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
