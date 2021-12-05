package day05;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.List;

public class Day05 {

    public long solve(List<String> input, boolean includeDiagonal) {
        var coordinates = new HashMap<Pair<Integer, Integer>, Integer>();

        input.forEach(line -> {
            var parts = line.split(" -> ");
            var xy1 = parts[0].split(",");
            var xy2 = parts[1].split(",");
            var x1 = Integer.parseInt(xy1[0]);
            var x2 = Integer.parseInt(xy2[0]);
            var y1 = Integer.parseInt(xy1[1]);
            var y2 = Integer.parseInt(xy2[1]);

            if ((x1 == x2 && y1 != y2) || (x1 != x2 && y1 == y2)) {
                for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                    for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                        var coordinate = Pair.of(x, y);
                        coordinates.put(coordinate, 1 + coordinates.getOrDefault(coordinate, 0));
                    }
                }
            } else if (includeDiagonal) {
                var x = x1;
                var y = y1;

                while (true) {
                    var coordinate = Pair.of(x, y);
                    coordinates.put(coordinate, 1 + coordinates.getOrDefault(coordinate, 0));
                    if (x == x2) {
                        break;
                    }
                    x += x1 < x2 ? 1 : -1;
                    y += y1 < y2 ? 1 : -1;
                }
            }
        });

        return coordinates.values().stream().filter(i -> i > 1).count();
    }

}
