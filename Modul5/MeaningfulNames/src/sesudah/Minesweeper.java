package sesudah;

import java.util.ArrayList;
import java.util.List;

public class Minesweeper {
    public final static int STATUS_VALUE = 0;
    public final static int FLAGGED = 4;

    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<int[]>();

        int[][] gameBoard = {
                { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }
        };

        for (int[] cell : gameBoard)
            if (cell[STATUS_VALUE] == FLAGGED)
                flaggedCells.add(cell);
        return flaggedCells;
    }
}
