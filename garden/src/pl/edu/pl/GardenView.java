package pl.edu.pl;

public class GardenView {

    int[][] tablica;

    public void showGarden(int size){

        System.out.println("------ OGROD ------");
        tablica = new int [size][size];
        System.out.print("|");
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.print("|\n");


        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(" ");
            }
            System.out.print("|\n");
        }

        System.out.print("|");
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.print("|");

    }
}
