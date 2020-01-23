package pl.edu.pl;

public class Dog extends Animal implements Writable{

    private String breed;

    public Dog(Position position) {
        super(position);
    }

    public Dog(long id, Position position) {
        super(id, position);
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
