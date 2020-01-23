package pl.edu.pl;

public class Cat extends Animal implements Writable{

    private String breed;

    public Cat(Position position) {
        super(position);
    }

    public Cat(long id, Position position) {
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
