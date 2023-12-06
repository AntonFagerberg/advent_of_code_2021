package day15;

import org.junit.jupiter.api.Test;
import utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day15Test {

    @Test
    void part1_example() {
        String input = String.join("\n", Utils.INSTANCE.readFile("day15/example"));
        assertEquals(40, Day15.part1(input.split("\n")));
    }

    @Test
    void part1() {
        String input = String.join("\n", Utils.INSTANCE.readFile("day15/input"));
        assertEquals(581, Day15.part1(input.split("\n")));
    }

    @Test
    void part2_example() {
        String input = String.join("\n", Utils.INSTANCE.readFile("day15/example"));
        assertEquals(315, Day15.part2(input.split("\n")));
    }

    @Test
    void part2() {
        String input = String.join("\n", Utils.INSTANCE.readFile("day15/input"));
        assertEquals(2916, Day15.part2(input.split("\n")));
    }

}
