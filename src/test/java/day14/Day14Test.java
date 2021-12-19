package day14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Utils;

import java.io.IOException;

public class Day14Test {

    @Test
    void part1Example() throws IOException {
        var input = Utils.INSTANCE.readFile("day14/example");
        Assertions.assertEquals(1588, Day14.solve(input, 10));
    }

    @Test
    void part1() throws IOException {
        var input = Utils.INSTANCE.readFile("day14/input");
        Assertions.assertEquals(3306, Day14.solve(input, 10));
    }

    @Test
    void part2() throws IOException {
        var input = Utils.INSTANCE.readFile("day14/input");
        Assertions.assertEquals(1588, Day14.solve(input, 40));
    }

}
