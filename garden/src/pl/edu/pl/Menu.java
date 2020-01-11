package pl.edu.pl;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public enum Options {
        CLOSE(0, "Zakoncz program"),
        ADD_USER(1, "Dodaj wlasciciela"),
        REMOVE_USER(2, "Usun wlasciciela"),
        LIST_OF_USERS(3, "Wyswietl liste wlascicieli");

        private int optionId;
        private String valuePL;

        Options(int optionId, String valuePL) {
            this.optionId = optionId;
            this.valuePL = valuePL;
        }

        public String getValuePL() {
            return valuePL;
        }

        public int getOptionId() {
            return optionId;
        }
    }

    private int selectedOptions;

    public void showMenu(Scanner scanner){
        System.out.println("-------------MENU-------------");
        Arrays.stream(Options.values())
                .forEach(o -> System.out.println(o.getOptionId() + " - " + o.valuePL));
        System.out.println("Wybierz opcje: ");

        selectedOptions = scanner.nextInt();




    }
}
