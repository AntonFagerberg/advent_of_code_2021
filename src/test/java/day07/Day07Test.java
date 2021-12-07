package day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Day07Test {

    @Test
    void part1Example() {
        var line = Utils.INSTANCE.readFile("day07/example").get(0).split(",");
        var input = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        Assertions.assertEquals(37, Day07.solve(input, false));
    }

    @Test
    void part1() {
        var line = Utils.INSTANCE.readFile("day07/input").get(0).split(",");
        var input = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        Assertions.assertEquals(333755, Day07.solve(input, false));
    }

    @Test
    void part2Example() {
        var line = Utils.INSTANCE.readFile("day07/example").get(0).split(",");
        var input = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        Assertions.assertEquals(168, Day07.solve(input, true));
    }

    @Test
    void part2() {
        var line = Utils.INSTANCE.readFile("day07/input").get(0).split(",");
        var input = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList());
        Assertions.assertEquals(94017638, Day07.solve(input, true));
    }

}
