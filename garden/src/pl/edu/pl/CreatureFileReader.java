package pl.edu.pl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreatureFileReader {

    private List<Person> ownersList = new ArrayList<>();
    private List<Animal> animalsList = new ArrayList<>();

    public List<Person> readUsers(){

        File file = new File("users.txt");
        BufferedReader br = null;

        try {
            br = new BufferedReader( new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                String[] pData = st.split(",");
                Person owner = new Person();
                owner.setFirstName(pData[0]);
                owner.setLastName(pData[1]);
                owner.setGender(Creature.Gender.valueOf(pData[2]));
                owner.setAge(Integer.valueOf(pData[3]));

                ownersList.add(owner);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku users.txt");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Inny nieznany blad");
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Blad przy zamykaniu pliku");
                    e.printStackTrace();
                }
            }
        }
        return ownersList;
    }

    public List<Animal> readAnimals(){

        File file = new File("animals.txt");
        BufferedReader br = null;

        try {
            br = new BufferedReader( new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                String[] aData = st.split(",");
                Animal animal = null;
                Position position = new Position(Integer.valueOf(aData[3]), Integer.valueOf(aData[4]));

                String animalSymbol = aData[7];
                if(animalSymbol.toLowerCase().equals("z")){
                    animal = new Turtle(position);
                } else if(animalSymbol.toLowerCase().equals("k")){
                    animal = new Cat(position);
                } else if(animalSymbol.toLowerCase().equals("p")){
                    animal = new Dog(position);
                }

                animal.setFirstName(aData[0]);
                animal.setGender(Creature.Gender.valueOf(aData[1]));
                animal.setAge(Integer.valueOf(aData[2]));
                animal.setOwnerId(Integer.valueOf(aData[5]));

                if(animal instanceof Cat){
                    ((Cat)animal).setBreed(aData[6]);
                } else if (animal instanceof Dog){
                    ((Dog)animal).setBreed(aData[6]);
                } else if (animal instanceof Turtle){
                    ((Turtle)animal).setCondition(Turtle.Condition.valueOf(aData[6]));
                }

                animalsList.add(animal);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku users.txt");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Inny nieznany blad");
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Blad przy zamykaniu pliku");
                    e.printStackTrace();
                }
            }
        }
        return animalsList;
    }
}
