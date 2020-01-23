package pl.edu.pl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreatureFileReader {

    public List<Person> readUsers(){

        List<Person> ownersList = new ArrayList<>();

        File file = new File("users.txt");
        BufferedReader br = null;

        try {
            br = new BufferedReader( new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                String[] pData = st.split(",");
                int id = Integer.valueOf(pData[0]);
                Person owner = new Person(id);
                owner.setFirstName(pData[1]);
                owner.setLastName(pData[2]);
                owner.setGender(Creature.Gender.valueOf(pData[3]));
                owner.setAge(Integer.valueOf(pData[4]));

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

        List<Animal> animalsList = new ArrayList<>();

        File file = new File("animals.txt");
        BufferedReader br = null;

        try {
            br = new BufferedReader( new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                String[] aData = st.split(",");
                Animal animal = null;
                int id = Integer.valueOf(aData[0]);
                Position position = new Position(Integer.valueOf(aData[4]), Integer.valueOf(aData[5]));

                String animalSymbol = aData[8];
                if(animalSymbol.toLowerCase().equals("z")){
                    animal = new Turtle(id, position);
                } else if(animalSymbol.toLowerCase().equals("k")){
                    animal = new Cat(id, position);
                } else if(animalSymbol.toLowerCase().equals("p")){
                    animal = new Dog(id, position);
                }

                animal.setFirstName(aData[1]);
                animal.setGender(Creature.Gender.valueOf(aData[2]));
                animal.setAge(Integer.valueOf(aData[3]));
                animal.setOwnerId(Integer.valueOf(aData[6]));

                if(animal instanceof Cat){
                    ((Cat)animal).setBreed(aData[7]);
                } else if (animal instanceof Dog){
                    ((Dog)animal).setBreed(aData[7]);
                } else if (animal instanceof Turtle){
                    ((Turtle)animal).setCondition(Turtle.Condition.valueOf(aData[7]));
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
