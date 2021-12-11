package day11;

import java.util.List;

public class Day11 {

    static int part1(List<String> input) {
        var grid = new int[input.size()][input.get(0).length()];
        for (var x = 0; x < input.size(); x++) {
            var y = 0;
            for (var number : input.get(x).split("")) {
                grid[x][y] = Integer.parseInt(number);
                y++;
            }
        }

        var flashed = 0;
        for (var a = 0; a < 100; a++) {
            flashed += mutate(grid);
        }


        return flashed;
    }

    static int part2(List<String> input) {
        var grid = new int[input.size()][input.get(0).length()];
        for (var x = 0; x < input.size(); x++) {
            var y = 0;
            for (var number : input.get(x).split("")) {
                grid[x][y] = Integer.parseInt(number);
                y++;
            }
        }

        var maxSize = grid.length * grid[0].length;
        var x = 1;

        while (mutate(grid) != maxSize) {
            x++;
        }

        return x;
    }

    static int mutate(int[][] grid) {
        for (var x = 0; x < grid.length; x++) {
            for (var y = 0; y < grid[x].length; y++) {
                grid[x][y]++;
            }
        }

        var flashed = 0;
        var flashedBefore = -1;

        while (flashedBefore != flashed) {
            flashedBefore = flashed;
            for (var x = 0; x < grid.length; x++) {
                for (var y = 0; y < grid[x].length; y++) {
                    if (grid[x][y] > 9) {
                        grid[x][y] = 0;
                        flashed++;
                        for (var xx = -1; xx <= 1; xx++) {
                            for (var yy = -1; yy <= 1; yy++) {
                                flash(grid, x + xx, y + yy);
                            }
                        }
                    }
                }
            }
        }

        return flashed;
    }

    static void flash(int[][] grid, int x, int y) {
        try {
            if (grid[x][y] > 0) {
                grid[x][y]++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // Skip
        }
    }

}
