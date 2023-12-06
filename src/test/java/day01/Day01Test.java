package day01;

import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day01Test {

    @Test
    void part1_example() {
        var input = Utils.INSTANCE.readFile("day01/example");
        assertEquals(514579, Day01.part1(input));
    }

    @Test
    void part1() {
        var input = Utils.INSTANCE.readFile("day01/input");
        assertEquals(889779, Day01.part1(input));
    }

    @Test
    void part2() {
        var input = Utils.INSTANCE.readFile("day01/input");
        assertEquals(76110336, Day01.part2(input));
    }
}
