import java.util.Arrays;
import java.util.Random;

public class Main {

    public int[][] grid;
    Random random = new Random();


    public boolean isValidRow(int row){
        return true;
    }

    public boolean isValidColumn(int col){
        return true;
    }
    public boolean validate(int[] check){

        int i =0;
        Arrays.sort(check);

        for(int number:check){
            if(number!=++i){
                return false;
            }
        }
        return true;

    }

    //section = grid[(i/3)*3 +j/3][i*3%9+j%3]

    public boolean isValidSection(int subgrid){
        int row = (subgrid/3)*3;
        int col = (subgrid%3)*3;
        return true;
    }


    public static void main(String[] args) {

        Main m = new Main();

        m.generateEmptyGrid(9, 9);
        m.initGridWithRandomElements();
        m.displayGrid();
    }

    public void initGridWithRandomElements() {

        int g[][] = getGrid();
        int size = getGrid().length;
        int section[][] = new int[3][3];

        for (int i = 0; i < 28; i++) {

            for(int row = 3; row<size;row++){
                for(int column = 3; column<size;column++){
                    section[row][column] =  grid[(row/3)*3 +column/3][row*3%9+column%3];
                }
                System.out.println();
            }


        }



    }

    public void generateEmptyGrid(int x, int y) {

        grid = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                grid[i][j] = 0;
            }
        }


        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {


                setGrid(grid);
            }
        }
    }

    public void displayGrid() {
        for (int i = 0; i < getGrid().length; i++) {
            for (int j = 0; j < getGrid().length; j++) {

                System.out.print(String.format("%4d", getGrid()[i][j]));
            }
            System.out.print("\n");
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {


        this.grid = grid;
    }
}
