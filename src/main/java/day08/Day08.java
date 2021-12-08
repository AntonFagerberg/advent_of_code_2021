package day08;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Day08 {

    static long part1(List<String> input) {
        return solve(input).stream()
                .flatMap(Collection::stream)
                .filter(i -> i == 1 || i == 4 || i == 7 || i == 8)
                .count();
    }

    static long part2(List<String> input) {
        return solve(input)
                .stream()
                .map(l -> l.stream().map(String::valueOf).collect(Collectors.joining()))
                .map(Integer::valueOf)
                .reduce(0, Integer::sum);
    }

    static List<List<Integer>> solve(List<String> input) {
        var parsedInput = input.stream()
                .map(line -> line.split(" \\| "))
                .map(parts -> Pair.of(parts[0].split(" "), parts[1].split(" ")))
                .collect(Collectors.toList());

        return parsedInput.stream().map(pair -> {
            var points = Arrays.stream(pair.getLeft())
                    .map(Day08::stringToIntSet)
                    .collect(Collectors.toList());

            var mapping = crack(points);

            return Arrays.stream(pair.getRight())
                    .map(Day08::stringToIntSet)
                    .map(mapping::get)
                    .collect(Collectors.toList());
        }).collect(Collectors.toList());
    }

    static Map<Set<Integer>, Integer> crack(List<Set<Integer>> input) {
        var mapping = new HashMap<Integer, Set<Integer>>();

        while (mapping.size() != 10) {
            for (var piece : input) {
                if (piece.size() == 2) {
                    mapping.put(1, piece);
                } else if (piece.size() == 4) {
                    mapping.put(4, piece);
                } else if (piece.size() == 3) {
                    mapping.put(7, piece);
                } else if (piece.size() == 7) {
                    mapping.put(8, piece);
                } else if (piece.size() == 6 &&
                        mapping.containsKey(4) &&
                        piece.containsAll(mapping.get(4))) {
                    mapping.put(9, piece);
                } else if (piece.size() == 6 &&
                        mapping.containsKey(4) &&
                        mapping.containsKey(1) &&
                        piece.containsAll(mapping.get(1)) &&
                        !piece.containsAll(mapping.get(4))) {
                    mapping.put(0, piece);
                } else if (piece.size() == 6 &&
                        mapping.containsKey(1) &&
                        !piece.containsAll(mapping.get(1))) {
                    mapping.put(6, piece);
                } else if (piece.size() == 5 &&
                        mapping.containsKey(1) &&
                        piece.containsAll(mapping.get(1))) {
                    mapping.put(3, piece);
                } else if (piece.size() == 5 &&
                        mapping.containsKey(9) &&
                        mapping.get(9).containsAll(piece)) {
                    mapping.put(5, piece);
                } else if (mapping.size() == 9) {
                    mapping.put(2, piece);
                }
            }
        }

        return mapping.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    static Set<Integer> stringToIntSet(String input) {
        return input.codePoints().boxed().collect(Collectors.toSet());
    }

}
