package pl.edu.pl;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public enum Option {
        UNKNOW("-1", "Blad"),
        CLOSE("0", "Zakoncz program"),
        ADD_USER("1", "Dodaj wlasciciela"),
        REMOVE_USER("2", "Usun wlasciciela"),
        LIST_OF_USERS("3", "Wyswietl liste wlascicieli");

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



    public void showMenu(Scanner scanner){

        Option selectedOption;
        do{
            printMenu();
            selectedOption = Option.fromId(scanner.nextLine());

            switch (selectedOption) {
                case CLOSE:
                    System.out.println("Zapisanie i zamknięnie programu ///////");
                    break;
                case ADD_USER:
                    System.out.println("Dodanie uzytkownika ///////");
                    break;
                case REMOVE_USER:
                    System.out.println("Usunięcie uzytkownika ///////");
                    break;
                case LIST_OF_USERS:
                    System.out.println("Wyświetlenie listy uzytkownikow ///////");
                    break;
                case UNKNOW:
                    System.out.println("Blednie wybrana opcja");
                    break;
            }

        }while (!selectedOption.equals(Option.CLOSE));

    }

    private void printMenu(){
        System.out.println("-------------MENU-------------");
        Arrays.stream(Option.values())
                .filter(o -> !o.getOptionId().equals("-1"))
                .forEach(o -> System.out.println(o.getOptionId() + " - " + o.valuePL));
        System.out.println("Wybierz opcje: ");
    }
}
