package day10;

import java.util.*;

public class Day10 {

    static Map<String, String> mapping = Map.of("(", ")",
            "[", "]",
            "{", "}",
            "<", ">");

    static long part1(List<String> lines) {
        var points = Map.of(")", 3,
                "]", 57,
                "}", 1197,
                ">", 25137);

        var errors = new ArrayList<String>();
        var openings = mapping.keySet();
        var closings = mapping.values();

        for (var line : lines) {
            var stack = new ArrayDeque<String>();
            for (var character : line.split("")) {
                if (openings.contains(character)) {
                    stack.push(character);
                } else if (closings.contains(character)) {
                    if (!mapping.get(stack.pop()).equals(character)) {
                        errors.add(character);
                        break;
                    }
                } else {
                    throw new RuntimeException("Unrecognized character: " + character);
                }
            }
        }

        return errors.stream().map(points::get).reduce(0, Integer::sum);
    }

    static long part2(List<String> lines) {
        var points = Map.of(")", 1,
                "]", 2,
                "}", 3,
                ">", 4);

        var openings = mapping.keySet();
        var closings = mapping.values();
        var results = new ArrayList<Long>();

        for (var line : lines) {
            var ignore = false;
            var stack = new ArrayDeque<String>();
            for (var character : line.split("")) {
                if (openings.contains(character)) {
                    stack.push(character);
                } else if (closings.contains(character)) {
                    if (!mapping.get(stack.pop()).equals(character)) {
                        ignore = true;
                        break;
                    }
                } else {
                    throw new RuntimeException("Unrecognized character: " + character);
                }
            }

            if (!ignore && !stack.isEmpty()) {
                var score = stack.stream()
                        .map(mapping::get)
                        .map(points::get)
                        .map(Long::valueOf)
                        .reduce(0L, (acc, a) -> acc * 5 + a);

                results.add(score);
            }
        }

        results.sort(Comparator.naturalOrder());
        return results.get(results.size() / 2);
    }

}
