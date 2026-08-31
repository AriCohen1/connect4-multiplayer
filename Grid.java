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

    public void checkWin(){
        
    }

}
