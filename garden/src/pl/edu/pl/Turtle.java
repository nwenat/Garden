package pl.edu.pl;

public class Turtle extends Animal {

    public enum Condition {
        HIDDEN("schowany w skorupie"),
        ACTIVE("aktywny");

        private String valuePL;
        Condition(String valuePL) {
            this.valuePL = valuePL;
        }

        public String getValuePL() {
            return valuePL;
        }
    }

    private Condition condition;

    public Turtle(String firstName, int age, Gender gender, long ownerId) {
        super(firstName, age, gender, ownerId);
        this.condition = Condition.ACTIVE;
    }

    public Turtle() {
    }

    @Override
    public void info() {
        super.infooo();
        System.out.println("Stan: " + condition.getValuePL());
        System.out.println("--------------");
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
