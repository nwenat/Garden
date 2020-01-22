package pl.edu.pl;

public class Dog extends Animal implements Writable{

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
        super.infoBegining();
        System.out.println("Rasa: " + breed);
        System.out.println("--------------");
    }

    @Override
    public String getDataToSave() {
        String result = "";
        result += getDataToSaveBeginning();
        result += getBreed() + ",";
        result += "p\n";
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
