package moe.yaeger.aoc2018.day01;

public final class Day01_Puzzle1 {

    /**
     * Just sum up all frequencies.
     */
    public void solvePuzzle() {

        int frequency = InputDay01.FREQ_CHANGES.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Day01 # Frequency after applying all changes: " + frequency);
    }


}
