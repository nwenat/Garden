package pl.edu.pl;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {


    private DataBase dataBase = new DataBase();
    private Option selectedOption;

    public void showMenu(Scanner scanner){
        do{
            printMenu();
            selectedOption = Option.fromId(scanner.nextLine());

            switch (selectedOption) {
                case CLOSE:
                    System.out.println("Zapisanie i zamknięnie programu ///////");
                    break;
                case ADD_USER:
                    dataBase.addUser();
                    break;
                case REMOVE_USER:
                    dataBase.removeUser();
                    break;
                case LIST_OF_USERS:
                    dataBase.showOwnerList();
                    break;
                case ADD_ANIMAL:
                    System.out.println("Dodaj ziwerze ///////");
                    break;
                case REMOVE_ANIMAL:
                    System.out.println("Usun zwierze ///////");
                    break;
                case LIST_OF_ANIMAL:
                    dataBase.showAnimalsList();
                    break;
                case MOVE_ANIMAL:
                    System.out.println("Przesun zwierze ///////");
                    break;
                case FEED_TURTLE:
                    System.out.println("Nakarm zolwia ///////");
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
                .forEach(o -> System.out.println(o.getOptionId() + " - " + o.getValuePL()));
        System.out.println("Wybierz opcje: ");
    }
}
