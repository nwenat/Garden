package pl.edu.pl;

import java.util.Objects;

public class Person extends Creature implements Writable {

    private static long personCount = 1;

    private String secondName;
    private String lastName;

    public Person() {
        super(personCount);
        personCount++;
    }

    public Person(long id) {
        super(id);
        if(personCount < id){
            personCount = id + 1;
        }
    }

    @Override
    public void info() {
        System.out.println("Wlasciciel id: " + getId());
        System.out.println(getFirstName() + ", " + secondName + " " + getLastName());
        System.out.println("Wiek: " + getAge());
        System.out.println("Plec: " + (getGender() == null ? "NIE PODANO" : getGender().getValuePL()));
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

    @Override
    public String getDataToSave() {
        String result = "";
        result += getId() + ",";
        result += getFirstName() + ",";
        result += getSecondName() + ",";
        result += getLastName() + ",";
        result += getGender() + ",";
        result += getAge() + "\n";

        return result;
    }

    @Override
    public String getFileName() {
        return "users.txt";
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////


    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
