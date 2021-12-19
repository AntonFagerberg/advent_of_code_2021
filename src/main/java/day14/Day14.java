package day14;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class Day14 {

    static Map<String, Long> res = new HashMap<>();

    static void growCount(String a, String b, Map<String, String> lookup, int depth) {
        if (depth == 0) {
//            var result = new HashMap<2String, Long>();
            res.put(a, res.getOrDefault(a, 0L) + 1L);
//            return result;
//            return Map.of(a, 1L);
//            return Map.of(a, 1L);
//            return a.equals(b) ? Map.of(a, 2L) : Map.of(a, 1L, b, 1L);
        } else {
            var c = lookup.get(a + b);
//            var result = new HashMap<String, Long>();
//            result.put(a, 1L);
//            result.put(c, 1L);
            growCount(a, c, lookup, depth - 1);
            growCount(c, b, lookup, depth - 1);

//            for (var e : r1.entrySet()) {
//                result.put(e.getKey(), e.getValue() + result.getOrDefault(e.getKey(), 0L));
//            }
//            for (var e : r2.entrySet()) {
//                r1.put(e.getKey(), e.getValue() + r1.getOrDefault(e.getKey(), 0L));
//            }


//            return res;
//
////            var result = new HashMap<>(growCount(a, c, lookup, depth - 1));
////
////            for (var e : growCount(b, c, lookup, depth - 1).entrySet()) {
////                result.put(e.getKey(), e.getValue() + result.getOrDefault(e.getKey(), 0L));
////            }
////
////            return result;
        }
    }

    static long solve(List<String> input, int steps) throws IOException {
        var polymer = input.get(0).split("");
        var mapping = new HashMap<String, String>();
        for (var i = 2; i < input.size(); i++) {
            var line = input.get(i).split(" -> ");
            mapping.put(line[0], line[1]);
        }

//        var count = new HashMap<String, Long>();
//        count.put(polymer.get(0), 1L);

//        var result = new HashMap<String, Long>();

//        for (var a : polymer) {
//            result.put(a, result.getOrDefault(a, 0L) + 1L);
//        }



        for (var j = 0; j < polymer.length - 1; j++) {
            System.out.println(" => " + polymer[j] + polymer[j + 1]);
            growCount(polymer[j], polymer[j + 1], mapping, steps);

//            for (var e : growCount(polymer[j], polymer[j + 1], mapping, steps).entrySet()) {
//                result.put(e.getKey(), e.getValue() + result.getOrDefault(e.getKey(), 0L));
//            }

//            var subPolymer = new ArrayList<String>();
//            subPolymer.add(polymer.get(j));
//            subPolymer.add(polymer.get(j + 1));


//            System.out.println(" -> " + subPolymer);

//            for (var i = 0; i < steps; i++) {
//                var tempPolymer = new ArrayList<String>();
//                tempPolymer.add(subPolymer.get(0));
//                for (var k = 0; k < subPolymer.size() - 1; k++) {
//                    var first = subPolymer.get(k);
//                    var last = subPolymer.get(k + 1);
//                    tempPolymer.add(mapping.get(first + last));
//                    tempPolymer.add(last);
//                }
////                tempPolymer.remove(0);
//                subPolymer = tempPolymer;
////                System.out.println(subPolymer);
//            }

//            subPolymer.remove(0);

//
//            subPolymer.forEach(s -> {
//                count.put(s, count.getOrDefault(s, 0L) + 1L);
//            });
//            System.out.println(subPolymer);
        }

        res.put(polymer[polymer.length - 1], res.getOrDefault(polymer[polymer.length - 1], 0L) + 1L);

        System.out.println(res);
//
//        var counts = Arrays.stream(polymer)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
        var max = Long.MIN_VALUE;
        var min = Long.MAX_VALUE;

        for (var entry : res.entrySet()) {
            System.out.println(entry);
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
        }

        return max - min;
    }

}
