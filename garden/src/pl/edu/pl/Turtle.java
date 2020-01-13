package pl.edu.pl;

public class Turtle extends Animal {

    public enum Condition {
        HIDDEN("schowany w skorupie"),
        ACTIVE("aktywny");

        private String valuePL;
        Condition(String valuePL) {
            this.valuePL = valuePL;
        }
    }

    private Condition condition;

    public Turtle(String firstName, int age, Gender gender, Person owner) {
        super(firstName, age, gender, owner);
        condition = Condition.ACTIVE;
    }

    @Override
    public void info() {
        System.out.println("Turtle info");
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
