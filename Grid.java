import java.util.Arrays;

public class Grid {
    private Cell[][] grid = new Cell[6][7];

    public Grid() {
        for (Cell[] row : grid) {
            Arrays.fill(row, Cell.EMPTY);
        }
    }

    public void drop(int column, Cell player) {

        // Check column bounds
        if (column < 0 || column > 5) {
            System.out.println("Column " + column + " is out of bounds");
            return;
        }

            // Check whether column is full
        if (grid[column][6] != Cell.EMPTY) {
            System.out.println("Column is full");
            return;
        }

        for (int i = 0; i < 7; i++) {
            if (grid[column][i] != Cell.EMPTY) {
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
        int piecesInARowCount = 0;
        Cell piecesInARowColour = null;
        for (Cell[] column : grid) {
            for (Cell cell: column) {
                if (cell != piecesInARowColour) {
                    piecesInARowCount = 1;
                    piecesInARowColour = cell;
                }
                else {
                    piecesInARowCount += 1;
                }
                if (piecesInARowCount == 4) {
                    System.out.println(piecesInARowColour + "wins!!!");
                    gameOver(piecesInARowColour);
                }
                
            }
        }

    }
    private void checkHorizontalWin() {

    }
    private void checkDiagonalWin() {

    }

    private void gameOver(Cell winningColour){

    }
    

}
