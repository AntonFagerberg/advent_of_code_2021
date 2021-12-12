package day12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

public class Day12Test {

    @Test
    void part1Example() {
        var input = Utils.INSTANCE.readFile("day12/example");
        Assertions.assertEquals(226, Day12.part1(input));
    }

    @Test
    void part1() {
        var input = Utils.INSTANCE.readFile("day12/input");
        Assertions.assertEquals(5920, Day12.part1(input));
    }

    @Test
    void part2Example() {
        var input = Utils.INSTANCE.readFile("day12/example");
        Assertions.assertEquals(3509, Day12.part2(input));
    }

    @Test
    void part2() {
        var input = Utils.INSTANCE.readFile("day12/input");
        Assertions.assertEquals(155477, Day12.part2(input));
    }

}
