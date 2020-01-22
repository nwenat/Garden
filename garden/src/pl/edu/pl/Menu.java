package pl.edu.pl;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

    private Option selectedOption;
    private Scanner scanner = new Scanner(System.in);
    private CratureFileWriter cratureFileWriter = new CratureFileWriter();
    private CreatureFileReader creatureFileReader = new CreatureFileReader();

    public Menu() {

    }

    public void showMenu(DataBase dataBase, GardenPlan gardenPlan){
        do{
            printMenu();
            selectedOption = Option.fromId(scanner.nextLine());

            switch (selectedOption) {
                case CLOSE:
                    if( !dataBase.getOwnersList().isEmpty()) {
                        cratureFileWriter.saveAllPeople(dataBase.getOwnersList());
                    }
                    if ( !dataBase.getAnimalsList().isEmpty()) {
                        cratureFileWriter.saveAllAnimals(dataBase.getAnimalsList());
                    }
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
                    dataBase.addAnimal();
                    break;
                case REMOVE_ANIMAL:
                    dataBase.removeAnimal();
                    break;
                case LIST_OF_ANIMAL:
                    dataBase.showAnimalsList();
                    break;
                case MOVE_ANIMAL:
                    dataBase.moveAnimal();
                    break;
                case FEED_TURTLE:
                    dataBase.feedTurtle();
                    break;
                case SHOW_GARDEN:
                    gardenPlan.showGarden();
                    break;
                case UNKNOW:
                    System.out.println("Blednie wybrana opcja");
                    break;
            }
        }while (!selectedOption.equals(Option.CLOSE));
    }

    private void printMenu(){
        System.out.println("------------- MENU -------------");
        Arrays.stream(Option.values())
                .filter(o -> !o.getOptionId().equals("-1"))
                .forEach(o -> System.out.println(o.getOptionId() + " - " + o.getValuePL()));
        System.out.println("Wybierz opcje: ");
    }
}
