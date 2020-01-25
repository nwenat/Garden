package pl.edu.pl;

public abstract class Animal extends Creature {

    private static long animalCount = 1;
    private long ownerId;
    private Position position;

    public Animal(Position position) {
        super(animalCount);
        animalCount++;
        this.position = position;
    }

    public Animal(long id, Position position) {
        super(id);
        this.position = position;
        if(animalCount < id){
            animalCount = id + 1;
        }
    }

    public void infoBegining() {
        System.out.println("Zwierzak id: " + getId());
        System.out.println(getFirstName());
        System.out.println("Wiek: " + getAge());
        System.out.println("Plec: " + getGender().getValuePL());
        System.out.println("Pozycja: (" + getPosition().getX() + "," + getPosition().getY() + ")");
    }

    public String getDataToSaveBeginning() {
        String result = "";
        result += getId() + ",";
        result += getFirstName() + ",";
        result += getGender() + ",";
        result += getAge() + ",";
        result += getPosition().getX() + ",";
        result += getPosition().getY() + ",";
        result += getOwnerId() + ",";

        return result;
    }

    public abstract String getDataToSave();

    public abstract String getFileName();

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
