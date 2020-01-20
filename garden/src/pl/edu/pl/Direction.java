package pl.edu.pl;

public enum Direction {
    UP("G"),
    DOWN("D"),
    LEFT("L"),
    RIGHT("P");

    private String valuePL;

    Direction(String valuePL) {
        this.valuePL = valuePL;
    }

    public String getValuePL() {
        return valuePL;
    }
}
