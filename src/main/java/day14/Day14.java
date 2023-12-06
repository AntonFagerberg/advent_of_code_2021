package day14;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Day14 {

    Map<Character, Map<Character, Character>> mapping;
    Map<Character, Long> result;
    String polymer;

    public Day14(String[] input) {
        mapping = new HashMap<>();
        result = new HashMap<>();

        this.polymer = input[0];

        for (int i = 2; i < input.length; i++) {
            char a = input[i].charAt(0);
            char b = input[i].charAt(1);
            char c = input[i].charAt(6);

            Map<Character, Character> inner = mapping.getOrDefault(a, new HashMap<>());
            inner.put(b, c);
            mapping.put(a, inner);
        }
    }

    long solve(int iterations) throws InterruptedException {
        result.put(polymer.charAt(0), 1L);

        var executorService = Executors.newFixedThreadPool(polymer.length() - 2);

        for (int i = 0; i < polymer.length() - 1; i++) {
            final var j = i;
            System.out.println(i);
            executorService.submit(() ->
                    recurse(polymer.charAt(j), polymer.charAt(j + 1), iterations)
            );
        }

        executorService.shutdown();
        executorService.awaitTermination(365, TimeUnit.DAYS);

        System.out.println(result);

        var min = result.values().stream()
                .min(Long::compareTo);

        var max = result.values().stream()
                .max(Long::compareTo);

        return max.orElseThrow() - min.orElseThrow();
    }

    synchronized void update(char b) {
        result.put(b, result.getOrDefault(b, 0L) + 1L);
    }

    void recurse(char a, char b, int step) {
        if (step <= 0) {
            update(b);
            return;
        }

        var c = mapping.get(a).get(b);

        if (c == null) {
            return;
        }

        recurse(a, c, step - 1);
        recurse(c, b, step - 1);
    }

}
