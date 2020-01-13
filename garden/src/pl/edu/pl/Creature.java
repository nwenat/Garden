package pl.edu.pl;

public abstract class Creature {

    public enum Gender {
        MALE("M"),
        FEMALE("K");

        private String valuePL;
        Gender(String valuePL) {
            this.valuePL = valuePL;
        }
    }

    private String firstName;
    private int age;
    private Gender gender;

    public Creature(String firstName, int age, Gender gender) {
        this.firstName = firstName;
        this.age = age;
        this.gender = gender;
    }

    public abstract void info();

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
