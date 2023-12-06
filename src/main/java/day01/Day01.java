package day01;

import java.util.List;

public class Day01 {

    static int part1(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                int i1 = Integer.parseInt(input.get(i));
                int i2 = Integer.parseInt(input.get(j));
                if (i1 + i2 == 2020) {
                    return i1 * i2;
                }
            }
        }

        return -1;
    }

    static int part2(List<String> input) {
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                for (int k = j + 1; k < input.size(); k++) {
                    int i1 = Integer.parseInt(input.get(i));
                    int i2 = Integer.parseInt(input.get(j));
                    int i3 = Integer.parseInt(input.get(k));
                    if (i1 + i2 + i3 == 2020) {
                        return i1 * i2 * i3;
                    }
                }
            }
        }

        return -1;
    }
}
