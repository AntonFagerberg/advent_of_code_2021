package day09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

public class Day09Test {

    @Test
    void part1Example() {
        var input = Utils.INSTANCE.readFile("day09/example");
        Assertions.assertEquals(15, Day09.part1(input));
    }

    @Test
    void part1() {
        var input = Utils.INSTANCE.readFile("day09/input");
        Assertions.assertEquals(554, Day09.part1(input));
    }

    @Test
    void part2Example() {
        var input = Utils.INSTANCE.readFile("day09/example");
        Assertions.assertEquals(1134, Day09.part2(input));
    }

    @Test
    void part2() {
        var input = Utils.INSTANCE.readFile("day09/input");
        Assertions.assertEquals(1134, Day09.part2(input));
    }

}
