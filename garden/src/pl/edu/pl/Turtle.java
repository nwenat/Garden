package pl.edu.pl;

public class Turtle extends Animal implements Writable{

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

    public Turtle(Position position) {
        super(position);
        this.condition = Condition.ACTIVE;
    }

    public Turtle(long id, Position position) {
        super(id, position);
    }

    public void feed(){
        if(this.condition == Condition.HIDDEN){
            this.condition = Condition.ACTIVE;
            System.out.println("Zwierze zostalo nakarmione.");
        } else {
            System.out.println("Zwierze nie jest glodne.");
        }
    }

    public void hide(){
        if(this.condition == Condition.ACTIVE){
            this.condition = Condition.HIDDEN;
            System.out.println("Zolw schowal sie do skorupy.");
        }
    }

    @Override
    public void info() {
        super.infoBegining();
        System.out.println("Stan: " + condition.getValuePL());
        System.out.println("--------------");
    }

    @Override
    public String getDataToSave() {
        String result = "";
        result += getDataToSaveBeginning();
        result += getCondition() + ",";
        result += "z\n";
        return result;
    }

    @Override
    public String getFileName() {
        return "animals.txt";
    }

    ///////////////////////////// GETERS AND SETERS ///////////////////////////////

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
