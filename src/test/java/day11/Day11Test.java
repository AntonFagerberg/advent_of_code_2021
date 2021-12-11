package day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

public class Day11Test {

    @Test
    void part1Example() {
        var input = Utils.INSTANCE.readFile("day11/example");
        Assertions.assertEquals(1656, Day11.part1(input));
    }

    @Test
    void part1() {
        var input = Utils.INSTANCE.readFile("day11/input");
        Assertions.assertEquals(1679, Day11.part1(input));
    }

    @Test
    void part2Example() {
        var input = Utils.INSTANCE.readFile("day11/example");
        Assertions.assertEquals(195, Day11.part2(input));
    }

    @Test
    void part2() {
        var input = Utils.INSTANCE.readFile("day11/input");
        Assertions.assertEquals(519, Day11.part2(input));
    }

}
