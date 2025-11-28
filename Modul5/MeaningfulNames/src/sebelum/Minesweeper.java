package sebelum;

import java.util.ArrayList;
import java.util.List;

public class Minesweeper {
    public List<int[]> getThem() {
        List<int[]> list1 = new ArrayList<int[]>();

        int[][] theList = {
                { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }
        };

        for (int[] x : theList)
            if (x[0] == 4)
                list1.add(x);
        return list1;
    }
}
