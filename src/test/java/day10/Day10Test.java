package day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

public class Day10Test {

    @Test
    void part1Example() {
        var input = Utils.INSTANCE.readFile("day10/example");
        Assertions.assertEquals(26397, Day10.part1(input));
    }

    @Test
    void part1() {
        var input = Utils.INSTANCE.readFile("day10/input");
        Assertions.assertEquals(319233, Day10.part1(input));
    }

    @Test
    void part2Example() {
        var input = Utils.INSTANCE.readFile("day10/example");
        Assertions.assertEquals(288957, Day10.part2(input));
    }

    @Test
    void part2() {
        var input = Utils.INSTANCE.readFile("day10/input");
        Assertions.assertEquals(1118976874, Day10.part2(input));
    }

}
