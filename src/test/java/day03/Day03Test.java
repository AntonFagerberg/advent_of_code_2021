package day03;

import org.junit.jupiter.api.Test;
import utils.Utils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day03Test {

    Function<Integer, Integer> inc = x -> ++x;
    Function<Integer, Integer> nop = x -> x;

    @Test
    void part1_example() {
        var input = String.join("\n", Utils.INSTANCE.readFile("day03/example"));

        var move = List.of(inc, nop,
                inc, nop,
                inc, nop,
                nop, inc);
        assertEquals(7, Day03.solve(input.split("\n"), move));
    }

    @Test
    void part1() {
        var input = String.join("\n", Utils.INSTANCE.readFile("day03/input"));
        var move = List.of(inc, nop,
                inc, nop,
                inc, nop,
                nop, inc);
        assertEquals(254, Day03.solve(input.split("\n"), move));
    }

    @Test
    void part2() {
        var moves = List.of(
                List.of(inc, nop,
                        nop, inc),

                List.of(inc, nop,
                        inc, nop,
                        inc, nop,
                        nop, inc),

                List.of(inc, nop,
                        inc, nop,
                        inc, nop,
                        inc, nop,
                        inc, nop,
                        nop, inc),

                List.of(inc, nop,
                        inc, nop,
                        inc, nop,
                        inc, nop,
                        inc, nop,
                        inc, nop,
                        inc, nop,
                        nop, inc),

                List.of(inc, nop,
                        nop, inc,
                        nop, inc)
        );

        var input = String.join("\n", Utils.INSTANCE.readFile("day03/input"));

        var result = moves.stream()
                .map(move -> Day03.solve(input.split("\n"), move))
                .reduce(1, (x, y) -> x * y);

        assertEquals(1666768320, result);
    }

}
