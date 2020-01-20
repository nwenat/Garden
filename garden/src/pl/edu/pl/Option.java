package pl.edu.pl;

import java.util.Arrays;

public enum Option {
    UNKNOW("-1", "Blad"),
    CLOSE("0", "Zakoncz program"),
    ADD_USER("1", "Dodaj wlasciciela"),
    REMOVE_USER("2", "Usun wlasciciela"),
    LIST_OF_USERS("3", "Wyswietl liste wlascicieli"),
    ADD_ANIMAL("4", "Dodaj zwierze"),
    REMOVE_ANIMAL("5", "Usun zwierze"),
    LIST_OF_ANIMAL("6", "Wyswietl liste zwierzat"),
    MOVE_ANIMAL("7", "Przesun zwierze"),
    FEED_TURTLE("8", "Nakarm zolwia"),
    SHOW_GARDEN("9", "Pokaz ogrod");

    private String optionId;
    private String valuePL;

    Option(String optionId, String valuePL) {
        this.optionId = optionId;
        this.valuePL = valuePL;
    }

    public static Option fromId(String id){
        return Arrays.stream(Option.values())
                .filter(o -> o.optionId.equals(id))
                .findFirst()
                .orElse(UNKNOW);
    }

    public String getValuePL() {
        return valuePL;
    }
    public String getOptionId() {
        return optionId;
    }
}
