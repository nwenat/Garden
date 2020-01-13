package pl.edu.pl;

public class Person extends Creature {

    private static long personCount = 0;
    private long id;
    private String lastName;

    public Person(String firstName, String lastName, int age, Gender gender) {
        super(firstName, age, gender);
        this.id = ++personCount;
        this.lastName = lastName;
    }

    @Override
    public void info() {
        System.out.println("Person info");
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
