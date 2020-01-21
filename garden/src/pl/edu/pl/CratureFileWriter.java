package pl.edu.pl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class CratureFileWriter {

    public void saveAll(Set<Person> writables){

        BufferedWriter bw = null;
        try {
            FileWriter fw = new FileWriter(writables.iterator().next().getFileNname());
            bw = new BufferedWriter(fw);

            for (Writable w : writables) {
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
