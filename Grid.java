import java.util.Arrays;

public class Grid {
    private Cell[][] grid = new Cell[7][6]; // board is [column][row], [0][0] represents bottom left 

    public Grid() {
        for (Cell[] column : grid) {
            Arrays.fill(column, Cell.EMPTY);
        }
    }

    public void drop(int column, Cell player) {

        // Check column bounds
        if (column < 0 || column > 6) {
            System.out.println("Column " + column + " is out of bounds");
            return;
        }

        // Check whether column is full
        if (grid[column][5] != Cell.EMPTY) {
            System.out.println("Column is full");
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (grid[column][i] == Cell.EMPTY) {
                grid[column][i] = player;
                break;
            }
                
        }
        checkWin();
    }

    private void checkWin(){
        checkVerticalWin();
        checkHorizontalWin();
        checkDiagonalWin();
    }

    private void checkVerticalWin() {
        int runLength = 0;
        Cell runColour = null;
        for (Cell[] column : grid) {
            runLength = 0;
            runColour = null;
            for (Cell cell: column) {
                if (cell == Cell.EMPTY) break;
                if (cell != runColour) {
                    runLength = 1;
                    runColour = cell;
                }
                else {
                    runLength += 1;
                }
                if (runLength == 4 && runColour != Cell.EMPTY && runColour != null) {
                    System.out.println(runColour + "wins!!!");
                    gameOver(runColour);
                }
                
            }
        }

    }
    private void checkHorizontalWin() {
        int runLength = 0;
        Cell runColour = null;
        for (Cell[] row : getGridRows()) {
            runLength = 0;
            runColour = null;
            for (Cell cell: row) {
                if (cell != runColour) {
                    runLength = 1;
                    runColour = cell;
                }
                else {
                    runLength += 1;
                }
                if (runLength == 4 && runColour != Cell.EMPTY && runColour != null) {
                    System.out.println(runColour + "wins!!!");
                    gameOver(runColour);
                }
                
            }
        }

    }
    private void checkDiagonalWin() {

    }

    private Cell[][] getGridRows() {
        Cell[][] arrayOfRows = new Cell[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                arrayOfRows[i][j] =  grid[j][i];
            }
        }
        return arrayOfRows;
    }

    private void gameOver(Cell winningColour){

    }
    

}
