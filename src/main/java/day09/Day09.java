package day09;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day09 {

    static int part1(List<String> input) {
        var map = new ArrayList<ArrayList<Integer>>();
        var visited = new ArrayList<ArrayList<Boolean>>();

        for (var line : input) {
            var mapLine = new ArrayList<Integer>();
            map.add(mapLine);

            var visitedLine = new ArrayList<Boolean>();
            visited.add(visitedLine);

            for (var number : line.split("")) {
                mapLine.add(Integer.parseInt(number));
                visitedLine.add(false);
            }
        }

        var sum = 0;

        for (int x = 0; x < input.size(); x++) {
            for (int y = 0; y < input.get(0).length(); y++) {
                var result = lowPoint(x, y, map, visited);
                if (result != null)
                    sum += 1 + map.get(result.getLeft()).get(result.getRight());
            }
        }

        return sum;
    }

    static Pair<Integer, Integer> lowPoint(int x, int y, ArrayList<ArrayList<Integer>> map, ArrayList<ArrayList<Boolean>> visited) {
        if (isVisited(x, y, visited))
            return null;

        visited.get(x).set(y, true);
        var current = getCoordinate(x, y, map);

        if (getCoordinate(x, y + 1, map) <= current)
            return lowPoint(x, y + 1, map, visited);

        if (getCoordinate(x, y - 1, map) <= current)
            return lowPoint(x, y - 1, map, visited);

        if (getCoordinate(x + 1, y, map) <= current)
            return lowPoint(x + 1, y, map, visited);

        if (getCoordinate(x - 1, y, map) <= current)
            return lowPoint(x - 1, y, map, visited);

        return Pair.of(x, y);
    }

    static int part2(List<String> input) {
        var map = new ArrayList<ArrayList<Integer>>();
        var visited = new ArrayList<ArrayList<Boolean>>();

        for (var line : input) {
            var mapLine = new ArrayList<Integer>();
            map.add(mapLine);

            var visitedLine = new ArrayList<Boolean>();
            visited.add(visitedLine);

            for (var number : line.split("")) {
                mapLine.add(Integer.parseInt(number));
                visitedLine.add(false);
            }
        }

        var results = new ArrayList<Integer>();

        for (int x = 0; x < input.size(); x++) {
            for (int y = 0; y < input.get(0).length(); y++) {
                results.add(basinSize(x, y, map, visited));
            }
        }

        results.sort(Comparator.comparingInt(i -> i));
        return results.subList(results.size() - 3, results.size())
                .stream()
                .reduce(1, (i, j) -> i * j);
    }

    static int basinSize(int x, int y, ArrayList<ArrayList<Integer>> map, ArrayList<ArrayList<Boolean>> visited) {
        if (isVisited(x, y, visited))
            return 0;

        visited.get(x).set(y, true);
        var current = getCoordinate(x, y, map);

        if (current == 9)
            return 0;

        return 1 + basinSize(x + 1, y, map, visited)
                + basinSize(x - 1, y, map, visited)
                + basinSize(x, y + 1, map, visited)
                + basinSize(x, y - 1, map, visited);
    }

    static int getCoordinate(int x, int y, ArrayList<ArrayList<Integer>> map) {
        try {
            return map.get(x).get(y);
        } catch (IndexOutOfBoundsException e) {
            return Integer.MAX_VALUE;
        }
    }

    static boolean isVisited(int x, int y, ArrayList<ArrayList<Boolean>> visited) {
        try {
            var xValue = visited.get(x);
            if (xValue == null) return false;
            return visited.get(x).get(y);
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    }

}
