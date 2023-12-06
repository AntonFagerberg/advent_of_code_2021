package day14;

import java.util.*;

public class Day14 {

    Map<String, List<String>> mapping;
    Map<String, Long> result;
    String polymer;

    public Day14(String[] input) {
        mapping = new HashMap<>();
        result = new HashMap<>();

        this.polymer = input[0];

        for (int i = 2; i < input.length; i++) {
            char a = input[i].charAt(0);
            char b = input[i].charAt(1);
            char c = input[i].charAt(6);

            var l = mapping.getOrDefault("" + a + b, new ArrayList<>());
            l.add("" + a + c);
            l.add("" + c + b);
            mapping.put("" + a + b, l);
        }

        for (int i = 0; i < polymer.length() - 1; i++) {
            bump(polymer.charAt(i), polymer.charAt(i + 1));
        }

        bump(polymer.charAt(polymer.length() - 1), '-');
    }

    void bump(char... cs) {
        bump(1, cs);
    }

    void bump(long i, char... cs) {
        String key = "" + cs[0] + cs[1];
        result.put(key, i + result.getOrDefault(key, 0L));
    }

    long solve(int iterations) {
        for (int i = 0; i < iterations; i++) {
            var oldResult = Map.copyOf(result);
            result = new HashMap<>();
            for (var e : oldResult.entrySet()) {
                if (!e.getKey().contains("-")) {
                    mapping.get(e.getKey()).forEach(r -> bump(e.getValue(), r.toCharArray()));
                }
            }
        }

        var r = new HashMap<Character, Long>();
        r.put(polymer.charAt(polymer.length() - 1), 1L);

        for (var e : result.entrySet()) {
            r.put(e.getKey().charAt(0), e.getValue() + r.getOrDefault(e.getKey().charAt(0), 0L));
        }

        var min = Long.MAX_VALUE;
        var max = Long.MIN_VALUE;
        for (var e : r.values()) {
            min = Math.min(min, e);
            max = Math.max(max, e);
        }

        return max - min;
    }


//    Map<Character, Map<Character, Character>> mapping;
//    Map<Character, Long> result;
//    String polymer;
//
//    public Day14(String[] input) {
//        mapping = new HashMap<>();
//        result = new HashMap<>();
//
//        this.polymer = input[0];
//
//        for (int i = 2; i < input.length; i++) {
//            char a = input[i].charAt(0);
//            char b = input[i].charAt(1);
//            char c = input[i].charAt(6);
//
//            Map<Character, Character> inner = mapping.getOrDefault(a, new HashMap<>());
//            inner.put(b, c);
//            mapping.put(a, inner);
//        }
//    }
//
//    long solve(int iterations) throws InterruptedException {
//        result.put(polymer.charAt(0), 1L);
//
//        var executorService = Executors.newFixedThreadPool(polymer.length() - 2);
//
//        for (int i = 0; i < polymer.length() - 1; i++) {
//            final var j = i;
//            System.out.println(i);
//            executorService.submit(() ->
//                    recurse(polymer.charAt(j), polymer.charAt(j + 1), iterations)
//            );
//        }
//
//        executorService.shutdown();
//        executorService.awaitTermination(365, TimeUnit.DAYS);
//
//        System.out.println(result);
//
//        var min = result.values().stream()
//                .min(Long::compareTo);
//
//        var max = result.values().stream()
//                .max(Long::compareTo);
//
//        return max.orElseThrow() - min.orElseThrow();
//    }
//
//    synchronized void update(char b) {
//        result.put(b, result.getOrDefault(b, 0L) + 1L);
//    }
//
//    void recurse(char a, char b, int step) {
//        if (step <= 0) {
//            update(b);
//            return;
//        }
//
//        var c = mapping.get(a).get(b);
//
//        if (c == null) {
//            return;
//        }
//
//        recurse(a, c, step - 1);
//        recurse(c, b, step - 1);
//    }

}
