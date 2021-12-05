package day05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

class Day05Test {

    Day05 sut = new Day05();

    @Test
    void part1Example() {
        var input = Utils.INSTANCE.readFile("day05/example");
        Assertions.assertEquals(5, sut.solve(input, false));
    }

    @Test
    void part1() {
        var input = Utils.INSTANCE.readFile("day05/input");
        Assertions.assertEquals(6397, sut.solve(input, false));
    }

    @Test
    void part2Example() {
        var input = Utils.INSTANCE.readFile("day05/example");
        Assertions.assertEquals(12, sut.solve(input, true));
    }

    @Test
    void part2() {
        var input = Utils.INSTANCE.readFile("day05/input");
        Assertions.assertEquals(22335, sut.solve(input, true));
    }

}
