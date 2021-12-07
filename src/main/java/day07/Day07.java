package day07;

import java.util.HashMap;
import java.util.List;

public class Day07 {

    static int solve(List<Integer> input, boolean part2) {
        var numbers = new HashMap<Integer, Integer>();
        var max = 0;
        var min = 0;

        for (var i : input) {
            numbers.put(i, 1 + numbers.getOrDefault(i, 0));

            if (i > max) {
                max = i;
            }

            if (i < min) {
                min = i;
            }
        }

        var fuel = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            var fuelCount = 0;

            for (var e : numbers.entrySet()) {
                if (part2) {
                    var distance = Math.abs(i - e.getKey());
                    for (var n = 1; n <= distance; n++) {
                        fuelCount += n * e.getValue();
                    }
                } else {
                    fuelCount += Math.abs(i - e.getKey()) * e.getValue();
                }
            }

            if (fuelCount < fuel) {
                fuel = fuelCount;
            }
        }

        return fuel;
    }

}
