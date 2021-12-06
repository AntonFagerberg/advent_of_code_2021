package day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day06Test {

    @Test
    void part1Example() {
        var line = Utils.INSTANCE.readFile("day06/example").get(0).split(",");
        var input = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        Assertions.assertEquals(26, Day06.solve(input, 18));
        Assertions.assertEquals(5934, Day06.solve(input, 80));
    }

    @Test
    void part1() {
        var line = Utils.INSTANCE.readFile("day06/input").get(0).split(",");
        var input = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        Assertions.assertEquals(353274, Day06.solve(input, 80));
    }

    @Test
    void part2() {
        var line = Utils.INSTANCE.readFile("day06/input").get(0).split(",");
        var input = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        Assertions.assertEquals(1609314870967L, Day06.solve(input, 256));
    }

}
