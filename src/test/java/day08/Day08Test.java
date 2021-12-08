package day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

public class Day08Test {

    @Test
    void part1Example() {
        var input = Utils.INSTANCE.readFile("day08/example");
        Assertions.assertEquals(26, Day08.part1(input));
    }

    @Test
    void part1() {
        var input = Utils.INSTANCE.readFile("day08/input");
        Assertions.assertEquals(245, Day08.part1(input));
    }

    @Test
    void part2Example() {
        var input = Utils.INSTANCE.readFile("day08/example");
        Assertions.assertEquals(61229, Day08.part2(input));
    }

    @Test
    void part2() {
        var input = Utils.INSTANCE.readFile("day08/input");
        Assertions.assertEquals(983026, Day08.part2(input));
    }

}
