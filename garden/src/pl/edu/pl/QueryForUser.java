package pl.edu.pl;

import java.util.Scanner;

public class QueryForUser {

    private Scanner scanner = new Scanner(System.in);


    public String askForName(String name){
        String word;
        System.out.println("Podaj " + name + ": ");
        word = scanner.next();
        return word;
    }

    public int askForAge(){
        System.out.println("Podaj wiek: ");
        int age = -1;
        do {
            try {
                age = scanner.nextInt();
            } catch (Exception e) {
                scanner.next();
            }
            if(age < 0){
                System.out.println("Bledna wartosc, podaj wiek jeszcze raz");
            }
        } while (age < 0);
        return age;
    }

    public Creature.Gender askForGender(){
        Creature.Gender gender = null;
        String genderSymbol = "";
        do {
            System.out.println("Podaj plec K / M: ");
            genderSymbol = scanner.next();
            if(genderSymbol.toLowerCase().equals("k")){
                gender = Creature.Gender.FEMALE;
            } else if(genderSymbol.toLowerCase().equals("m")){
                gender = Creature.Gender.MALE;
            } else {
                System.out.println("Bledna wartosc!");
            }
        } while (gender == null);
        return gender;
    }

    public Direction askForDirection(){
        Direction direction = null;
        String directionSymbol = "";
        do {
            System.out.println("Podaj kierunek przesuniecia\n   G\nL     P\n   D");
            directionSymbol = scanner.next();
            if(directionSymbol.toLowerCase().equals("g")){
                direction = Direction.UP;
            } else if(directionSymbol.toLowerCase().equals("d")){
                direction = Direction.DOWN;
            }else if(directionSymbol.toLowerCase().equals("l")){
                direction = Direction.LEFT;
            }else if(directionSymbol.toLowerCase().equals("p")){
                direction = Direction.RIGHT;
            } else {
                System.out.println("Bledna wartosc!");
            }
        } while (direction == null);
        return direction;
    }

    public Animal askWhichAnimal(GardenPlan gardenPlan){
        Animal animal = null;
        String animalSymbol = "";
        do {
            System.out.println("Podaj jakie chcesz storzyc ziwerze: \n zolw - z    kot - k    pies -p");
            animalSymbol = scanner.next();
            if(animalSymbol.toLowerCase().equals("z")){
                animal = new Turtle(gardenPlan.nextFreeSpot());
            } else if(animalSymbol.toLowerCase().equals("k")){
                animal = new Cat(gardenPlan.nextFreeSpot());
            } else if(animalSymbol.toLowerCase().equals("p")){
                animal = new Dog(gardenPlan.nextFreeSpot());
            }else {
                System.out.println("Bledna wartosc!");
            }
        } while (animal == null);
        return animal;
    }

    public long askForId(String name){
        System.out.println("Podaj id " + name + ": ");
        long id = 0;
        do {
            try {
                id = scanner.nextLong();
            } catch (Exception e) {
                scanner.next();
            }
            if(id < 1){
                System.out.println("Bledna wartosc, podaj id jeszcze raz");
            }
        } while (id < 1);
        return id;
    }
}
