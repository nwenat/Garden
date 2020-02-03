package pl.edu.pl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CratureFileWriter {

    public void saveAllPeople(List<Person> personList){

        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(personList.get(0).getFileName());
            bw = new BufferedWriter(fw);

            for (Writable w : personList) {
                bw.write(w.getDataToSave());
            }

        } catch (IOException e) {
            System.out.println("Blad podczas otwierania pliku");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Inny nieznany blad");
            e.printStackTrace();
        }finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Blad przy zamykaniu pliku");
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveAllAnimals(List<Animal> animalList){

        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(animalList.get(0).getFileName());
            bw = new BufferedWriter(fw);

            for (Animal w : animalList) {
                bw.write(w.getDataToSave());
            }

        } catch (IOException e) {
            System.out.println("Blad podczas otwierania pliku");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Inny nieznany blad");
            e.printStackTrace();
        }finally {
            if(bw != null){
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Blad przy zamykaniu pliku");
                    e.printStackTrace();
                }
            }
        }
    }
}
