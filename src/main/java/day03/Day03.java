package day03;

import java.util.List;
import java.util.function.Function;

public class Day03 {
    static int solve(String[] grid, List<Function<Integer, Integer>> move) {
        var trees = 0;

        int x = 0, y = 0;
        var cmd = 0;

        while (y != grid.length) {
            if (grid[y].charAt(x % grid[y].length()) == '#' && cmd == 0) {
                trees++;
            }

            x = move.get(cmd++).apply(x);
            y = move.get(cmd++).apply(y);
            cmd = cmd % move.size();
        }

        return trees;
    }
}
