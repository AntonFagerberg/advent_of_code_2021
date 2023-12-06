package day15;

import java.util.*;
import java.util.stream.Collectors;

public class Day15 {

    static int part1(String[] input) {
        var connection = new HashMap<String, Map<String, Integer>>();
        var nodeWeight = new HashMap<String, Integer>();
        var unprocessed = new HashSet<String>();

        for (int y = 0; y < input.length; y++) {
            for (int x = 0; x < input[y].length(); x++) {
                String node = "%s,%s".formatted(x, y);
                nodeWeight.put(node, Integer.MAX_VALUE);
                unprocessed.add(node);

                for (var dest : List.of("%s,%s".formatted(x + 1, y),
                        "%s,%s".formatted(x - 1, y),
                        "%s,%s".formatted(x, y + 1),
                        "%s,%s".formatted(x, y - 1))) {
                    try {
                        connection.putIfAbsent(node, new HashMap<>());
                        var parts = dest.split(",");
                        connection.get(node).put(dest, Integer.parseInt(String.valueOf(input[Integer.parseInt(parts[1])].charAt(Integer.parseInt(parts[0])))));
                    } catch (IndexOutOfBoundsException e) {

                    }
                }
            }
        }

        nodeWeight.put("0,0", 0);

        while (!unprocessed.isEmpty()) {
            int minVal = Integer.MAX_VALUE;
            var minNode = "";
            for (var node : unprocessed) {
                Integer weight = nodeWeight.get(node);
                if (weight <= minVal) {
                    minVal = weight;
                    minNode = node;
                }
            }

            for (var entry : connection.get(minNode).entrySet()) {
                int weight = minVal + entry.getValue();

                if (weight < nodeWeight.get(entry.getKey())) {
                    nodeWeight.put(entry.getKey(), weight);
                }
            }

            unprocessed.remove(minNode);
        }

        return nodeWeight.get("%s,%s".formatted(input[0].length() - 1, input.length - 1));
    }

    // TODO add priority queue for what node to process next?
    static int part2(String[] input) {
        var newInput = new String[input.length * 5];

        for (int i = 0; i < newInput.length; i++) {
            var ex = input[i % input.length];
            var line = "";

            for (int j = 0; j < 5; j++) {
                final int ii = i / input.length;
                final int jj = j;
                var l = Arrays.stream(ex.split(""))
                        .map(Integer::parseInt)
                        .map(v -> {
                            v += ii + jj;
                            while (v > 9) {
                                v -= 9;
                            }
                            return v;
                        })
                        .map(Objects::toString)
                        .collect(Collectors.joining());

                line += l;
            }
            newInput[i] = line;
        }

        return part1(newInput);
    }

}
