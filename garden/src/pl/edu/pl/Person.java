package pl.edu.pl;

public class Person extends Creature {

    private static long personCount = 1;

    private String lastName;

    public Person(String firstName, String lastName, int age, Gender gender) {
        super(personCount, firstName, age, gender);
        personCount++;
        this.lastName = lastName;
    }

    @Override
    public void info() {
        System.out.println("Id: " + getId());
        System.out.println(getFirstName() + " " + getLastName());
        System.out.println("Wiek: " + getAge());
        System.out.println("Plec: " + getGender().getValuePL());
        System.out.println("--------------");
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
