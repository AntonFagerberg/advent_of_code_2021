package day13;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class Day13 {

    static int part1(List<String> input) {
        var coordinates = new ArrayList<Pair<Integer, Integer>>();
        var maxX = 0;
        var maxY = 0;
        var folds = new ArrayList<Pair<String, Integer>>();

        for (var line : input) {
            if (line.contains(",")) {
                var pieces = line.split(",");
                var x = Integer.valueOf(pieces[0]);
                var y = Integer.valueOf(pieces[1]);

                coordinates.add(Pair.of(x, y));

                if (x > maxX) {
                    maxX = x;
                }

                if (y > maxY) {
                    maxY = y;
                }
            } else if (line.contains("x")) {
                folds.add(Pair.of("x", Integer.parseInt(line.split("=")[1])));
            } else if (line.contains("y")) {
                folds.add(Pair.of("y", Integer.parseInt(line.split("=")[1])));
            }
        }

        var grid = new boolean[maxY + 1][maxX + 1];
        for (var xy : coordinates) {
            grid[xy.getRight()][xy.getLeft()] = true;
        }

        var fold = folds.get(0);
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (fold.getLeft().equals("y") && y >= fold.getRight() && grid[y][x]) {
                    grid[fold.getRight() - (y - fold.getRight())][x] = true;
                    grid[y][x] = false;
                } else if (fold.getLeft().equals("x") && x >= fold.getRight() && grid[y][x]) {
                    grid[y][fold.getRight() - (x - fold.getRight())] = true;
                    grid[y][x] = false;
                }
            }
        }

        var count = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x]) {
                    count++;
                }
            }
        }

        return count;
    }

    static String part2(List<String> input) {
        var coordinates = new ArrayList<Pair<Integer, Integer>>();
        var maxX = 0;
        var maxY = 0;
        var folds = new ArrayList<Pair<String, Integer>>();

        for (var line : input) {
            if (line.contains(",")) {
                var pieces = line.split(",");
                var x = Integer.valueOf(pieces[0]);
                var y = Integer.valueOf(pieces[1]);

                coordinates.add(Pair.of(x, y));

                if (x > maxX) {
                    maxX = x;
                }

                if (y > maxY) {
                    maxY = y;
                }
            } else if (line.contains("x")) {
                folds.add(Pair.of("x", Integer.parseInt(line.split("=")[1])));
            } else if (line.contains("y")) {
                folds.add(Pair.of("y", Integer.parseInt(line.split("=")[1])));
            }
        }

        var grid = new boolean[maxY + 1][maxX + 1];
        for (var xy : coordinates) {
            grid[xy.getRight()][xy.getLeft()] = true;
        }

        for (var fold : folds) {
            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[y].length; x++) {
                    if (fold.getLeft().equals("y") && y >= fold.getRight() && grid[y][x]) {
                        grid[fold.getRight() - (y - fold.getRight())][x] = true;
                        grid[y][x] = false;
                    } else if (fold.getLeft().equals("x") && x >= fold.getRight() && grid[y][x]) {
                        grid[y][fold.getRight() - (x - fold.getRight())] = true;
                        grid[y][x] = false;
                    }
                }
            }
        }

        var result = new StringBuilder();
        for (int y = 0; y < grid.length; y++) {
            var line = new StringBuilder();
            for (int x = 0; x < grid[y].length; x++) {
                line.append(grid[y][x] ? "#" : ".");
            }
            if (line.toString().contains("#")) {
                result.append(line.substring(0, line.toString().lastIndexOf('#') + 1)).append("\n");
            }
        }

        return result.toString();
    }

}
