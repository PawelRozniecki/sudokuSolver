public class Sudoku {

    public static int[][] GRID_TO_SOLVE = {
            {0,0,0, 2,6,0, 7,0,1},
            {6,8,0, 0,7,0, 0,9,0},
            {1,9,0, 0,0,4, 5,0,0},

            {8,2,0, 1,0,0, 0,4,0},
            {0,0,4, 6,0,2, 9,0,0},
            {0,5,0, 0,0,3, 0,2,8},

            {0,0,9, 3,0,0, 0,7,4},
            {0,4,0, 0,5,0, 0,3,6},
            {7,0,3, 0,1,8, 0,0,0},
    };

    public int[][] grid;
    public  static final int SIZE = 9;

    public static  final int EMPTY_CELL = 0;





    public Sudoku(int[][] grid){


        this.grid = new int[SIZE][SIZE];



        for(int i=0; i<SIZE; i++){

            for(int j = 0 ; j<SIZE;j++){

                this.grid[i][j] = grid[i][j];

            }
        }
    }


    private boolean isInRow(int row, int number) {
        for (int i = 0; i < SIZE; i++)
            if (grid[row][i] == number)
                return true;

        return false;
    }

    // we check if a possible number is already in a column
    private boolean isInCol(int col, int number) {
        for (int i = 0; i < SIZE; i++)
            if (grid[i][col] == number)
                return true;

        return false;
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(String.format("%4d",  grid[i][j]));
            }

            System.out.println();
        }

        System.out.println();
    }
    public boolean validSubGrid(int row, int col, int num){


        int currentRow= row - row%3;
        int currentCol = col - col%3;

        for(int i= currentRow;i<currentRow+3;i++){
            for(int j  = currentCol; j<currentCol+3;j++){

                if(grid[i][j]==num){
                    return true;
                }

            }
        }
        return false;

    }

    private boolean isOK(int row, int col, int num){

        return !isInRow(row,num)&& !isInCol(col,num)&&!validSubGrid(row,col,num);

    }



    public boolean solveSudoku() {


        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // we search an empty cell
                if (grid[row][col] == EMPTY_CELL) {
                    // we try possible numbers
                    for (int number = 1; number <= SIZE; number++) {
                        if (isOK(row, col, number)) {
                            // number ok. it respects sudoku constraints
                            grid[row][col] = number;

                            if (solveSudoku()
                            ) { // we start backtracking recursively
                                return true;
                            } else { // if not a solution, we empty the cell and we continue
                                grid[row][col] = EMPTY_CELL;
                            }
                        }
                    }

                    return false; // we return false
                }
            }
        }

        return true; // sudoku solved
    }



    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku(GRID_TO_SOLVE);
        System.out.println("Sudoku grid to solve");
        sudoku.display();

        // we try resolution
        if (sudoku.solveSudoku()) {
            System.out.println("SOLVED!");
            sudoku.display();
        } else {
            System.out.println("Unsolvable");
        }
    }

}

