package pl.edu.pl;

import java.util.Objects;

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
        System.out.println("Zwierzaki: ....");
        System.out.println("--------------");
    }

    @Override
    public int hashCode() {
        return (int)getId();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj instanceof Person){
            Person p = (Person)obj;
            if(p.getId() == this.getId() && p.getFirstName().equals(this.getFirstName())
            && p.getLastName().equals(this.getLastName()) && p.getAge() == this.getAge()
            && Objects.equals(p.getGender(), this.getGender())){
                result = true;
            }
        }
        return result;
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
