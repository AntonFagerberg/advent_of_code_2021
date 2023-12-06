package day14;

import org.junit.jupiter.api.Test;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day14Test {

    @Test
    void part1Example() throws InterruptedException {
        var input = String.join("\n", Utils.INSTANCE.readFile("day14/example"));
        var day14 = new Day14(input.split("\n"));

        assertEquals(1588, day14.solve(10));
    }

    @Test
    void part1() throws InterruptedException {
        var input = String.join("\n", Utils.INSTANCE.readFile("day14/input"));
        var day14 = new Day14(input.split("\n"));

        assertEquals(3306, day14.solve(10));
    }

    @Test
    void part2() throws InterruptedException {
        var input = String.join("\n", Utils.INSTANCE.readFile("day14/input"));
        var day14 = new Day14(input.split("\n"));
        assertEquals(3306, day14.solve(40));
    }

}
