package moe.yaeger.aoc2018.day02;

import java.util.HashMap;
import java.util.Map;

public class Day02_Puzzle1 {

    private static final int COUNT_BEGIN = 1;

    private static final int DOUBLE_COUNT = 2;
    private static final int TRIPLE_COUNT = 3;

    /**
     * Analyse Box Ids for double and triple chars
     */
    public void solvePuzzle() {

        final HashMap<String,HashMap<Character, Integer>> scannedBoxes = new HashMap<>();
        InputDay02.BOX_IDS.forEach(id -> {

            final HashMap<Character, Integer> analysedId = new HashMap<>();
            for(char c : id.toCharArray()) {

                if(analysedId.containsKey(c)) {
                    int count = analysedId.get(c);
                    count++;
                    analysedId.put(c, count);
                }
                else {
                    analysedId.put(c, COUNT_BEGIN);
                }
            }

            scannedBoxes.put(id, analysedId);
        });

        // get number of boxes with double and triple chars
        int countDouble = 0;
        int countTriple = 0;

        for(Map.Entry<String, HashMap<Character, Integer>> boxId : scannedBoxes.entrySet()) {

            final HashMap<Character, Integer> boxData = boxId.getValue();
            if(boxData.containsValue(DOUBLE_COUNT)) {
                countDouble++;
            }
            if(boxData.containsValue(TRIPLE_COUNT)) {
                countTriple++;
            }
        }

        int checksum = countDouble * countTriple;
        System.out.println("Day02 # Checksum of Boxes: " + checksum);
    }

}
