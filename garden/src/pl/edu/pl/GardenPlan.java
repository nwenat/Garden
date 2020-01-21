package pl.edu.pl;

public class GardenPlan {

    private String[][] table;
    private int size;

    public GardenPlan(int size) {
        this.size = size;
        table = new String[size][size];
        fillEmptyTable();
    }

    public void showGarden(){
        System.out.println("------ OGROD ------");
        viewFence(size);
        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(table[i][j]);
            }
            System.out.print("|\n");
        }
        viewFence(size);
    }

    public void addAnimalToTable(Animal animal){
        Position pos = animal.getPosition();
        if (animal instanceof Cat){
            table[pos.getX()][pos.getY()] = "K";
        } else if (animal instanceof Dog){
            table[pos.getX()][pos.getY()] = "P";
        } else if (animal instanceof Turtle){
            table[pos.getX()][pos.getY()] = "Z";
        }
    }

    public void removeAnimalFromTable(Animal animal){
        Position pos = animal.getPosition();
        table[pos.getX()][pos.getY()] = " ";
    }

    public Position nextFreeSpot(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(table[i][j].equals(" ")){
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    public void move(Animal animal, Direction direction){
        Position position = animal.getPosition();
        int var = 20;
        Position newPosition = null;
        switch (direction) {
            case UP:
                var = position.getX() - 1;
                newPosition = new Position(var, position.getY());
                break;
            case DOWN:
                var = position.getX() + 1;
                newPosition = new Position(var, position.getY());
                break;
            case LEFT:
                var = position.getY() - 1;
                newPosition = new Position(position.getX(), var);
                break;
            case RIGHT:
                var = position.getY() + 1;
                newPosition = new Position(position.getX(), var);
                break;
        }

        if(var >= 0 && var < size){
            if(table[newPosition.getX()][newPosition.getY()].equals(" ")){
                removeAnimalFromTable(animal);
                animal.setPosition(newPosition);
                addAnimalToTable(animal);
                System.out.println("Przesuniecie sie powiodlo. Z pozycji: ("
                        + position.getX() + "," + position.getY() + ") na pozycje ("
                        + newPosition.getX() + "," + newPosition.getY() + ").");
                if (animal instanceof Turtle){
                    ((Turtle) animal).hide();
                }
            } else {
                System.out.println("To pole jest juz zajete.");
            }
        }else {
            System.out.println("Pole nie miesci sie w ogrodzie.");
        }
        showGarden();
    }

    private void fillEmptyTable(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = " ";
            }
        }
    }

    private void viewFence(int size){
        System.out.print("|");
        for (int i = 0; i < size; i++) {
            System.out.print("-");
        }
        System.out.print("|\n");
    }
}
