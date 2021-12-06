package day06;

import java.util.Arrays;
import java.util.List;

public class Day06 {

    static long solve(List<Integer> input, int days) {
        long[] fish = new long[9];

        input.forEach(i -> fish[i]++);

        while (days-- > 0) {
            var spawn = fish[0];
            System.arraycopy(fish, 1, fish, 0, fish.length - 1);
            fish[6] += spawn;
            fish[8] = spawn;
        }

        return Arrays.stream(fish).sum();
    }

}
