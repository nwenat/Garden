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
        this.condition = Condition.ACTIVE;
    }

    public void feed(){
        if(this.condition == Condition.HIDDEN){
            this.condition = Condition.ACTIVE;
            System.out.println("Zwierze zostalo nakarmione");
        } else {
            System.out.println("Zwierze nie jest glodne");
        }
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
