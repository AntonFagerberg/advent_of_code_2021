package day12;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day12 {

    static int part1(List<String> input) {
        return pathsPart1("start", parse(input), Set.of()).size();
    }

    static int part2(List<String> input) {
        return pathsPart2("start", parse(input), Set.of(), false).size();
    }

    static Map<String, Set<String>> parse(List<String> input) {
        var paths = new HashMap<String, Set<String>>();

        for (var path : input) {
            var parts = path.split("-");
            if (paths.containsKey(parts[0])) {
                paths.get(parts[0]).add(parts[1]);
            } else {
                var set = new HashSet<String>();
                set.add(parts[1]);
                paths.put(parts[0], set);
            }

            if (paths.containsKey(parts[1])) {
                paths.get(parts[1]).add(parts[0]);
            } else {
                var set = new HashSet<String>();
                set.add(parts[0]);
                paths.put(parts[1], set);
            }
        }

        return paths;
    }

    static List<List<String>> pathsPart1(String current, Map<String, Set<String>> paths, Set<String> visited) {
        var newVisited = new HashSet<>(visited);
        if (current.toLowerCase().equals(current)) {
            newVisited.add(current);
        }

        if (current.equals("end")) {
            var endPath = new ArrayList<String>();
            endPath.add(current);
            var result = new ArrayList<List<String>>();
            result.add(endPath);
            return result;
        }

        return paths.get(current)
                .stream()
                .filter(path -> !newVisited.contains(path))
                .flatMap(path -> Day12.pathsPart1(path, paths, newVisited).stream())
                .peek(path -> path.add(current))
                .collect(Collectors.toList());
    }

    static List<List<String>> pathsPart2(String current, Map<String, Set<String>> paths, Set<String> visited, boolean single) {
        if (current.equals("end")) {
            var endPath = new ArrayList<String>();
            endPath.add(current);
            var result = new ArrayList<List<String>>();
            result.add(endPath);
            return result;
        }

        var newVisited = new HashSet<>(visited);

        if (current.toLowerCase().equals(current)) {
            newVisited.add(current);
        }

        if (!current.equals("start") && !single) {
            return paths.get(current)
                    .stream()
                    .filter(path -> !visited.contains(path))
                    .flatMap(path -> Stream.concat(Day12.pathsPart2(path, paths, visited, true).stream(),
                            Day12.pathsPart2(path, paths, newVisited, false).stream()))
                    .peek(path -> path.add(current))
                    .distinct()
                    .collect(Collectors.toList());
        } else {
            return paths.get(current)
                    .stream()
                    .filter(path -> !newVisited.contains(path))
                    .flatMap(path -> Day12.pathsPart2(path, paths, newVisited, single).stream())
                    .peek(path -> path.add(current))
                    .distinct()
                    .collect(Collectors.toList());
        }

    }

}
