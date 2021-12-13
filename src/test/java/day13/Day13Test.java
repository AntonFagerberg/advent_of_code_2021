package day13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

public class Day13Test {

    @Test
    void part1Example() {
        var input = Utils.INSTANCE.readFile("day13/example");
        Assertions.assertEquals(17, Day13.part1(input));
    }

    @Test
    void part1() {
        var input = Utils.INSTANCE.readFile("day13/input");
        Assertions.assertEquals(678, Day13.part1(input));
    }

    @Test
    void part2() {
        var input = Utils.INSTANCE.readFile("day13/input");
        var expected = """
                ####..##..####.#..#.#....#..#.####.####
                #....#..#.#....#..#.#....#..#....#.#
                ###..#....###..####.#....####...#..###
                #....#....#....#..#.#....#..#..#...#
                #....#..#.#....#..#.#....#..#.#....#
                ####..##..#....#..#.####.#..#.####.#
                """;
        Assertions.assertEquals(expected, Day13.part2(input));
    }

}
