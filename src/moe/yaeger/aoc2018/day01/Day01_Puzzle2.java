package moe.yaeger.aoc2018.day01;

import java.util.HashSet;
import java.util.Set;

public final class Day01_Puzzle2 {

    /**
     * Find the first frequency that appears twice.
     */
    public static void solvePuzzle() {

        Set<Integer> frequencies = new HashSet<>();
        int currentFrequency = 0;
        boolean adjust = true;

        // loop frequency list until the correct frequency is found
        while ( adjust ) {

            for(int i : InputDay01.FREQ_CHANGES) {

                currentFrequency += i;

                // we have it, stop adjusting
                if( frequencies.contains(currentFrequency) ) {
                    adjust = false;
                    break;
                }

                // add to pool
                frequencies.add(currentFrequency);
            }
        }

        System.out.println("Frequency: " + currentFrequency);
    }

}
