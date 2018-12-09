package moe.yaeger.aoc2018.day02;

/**
 * What letters are common between the two correct box IDs? The correct boxes will have IDs which differ by exactly one
 * character at the same position in both strings.
 * <p>
 * We will assume there are only two IDs that differ in one char!
 */
public class Day02_Puzzle2 {

    public void solvePuzzle() {

        StringBuilder builder = new StringBuilder();

        // for every id
        for (String boxId : InputDay02.BOX_IDS) {

            // check every other id
            for (String boxIdToCompare : InputDay02.BOX_IDS) {
                // skip self
                if (boxId.equals(boxIdToCompare)) {
                    continue;
                }

                // check if we differ in only one char
                for (int i = 1; i < boxId.length(); i++) {

                    // special case, start of string
                    if (i == 1) {
                        if (boxId.substring(1).equals(boxIdToCompare.substring(1))) {
                            builder.append(boxId.substring(1));
                        }
                    }
                    // special case, end of string
                    else if (i == boxId.length() - 1) {
                        if (boxId.substring(0, boxId.length() - 1)
                                .equals(boxIdToCompare.substring(0, boxId.length() - 1))) {
                            builder.append(boxId, 0, boxId.length() - 1);
                        }
                    } else {

                        if (boxId.substring(0, i).equals(boxIdToCompare.substring(0, i)) && boxId
                                .substring(i + 1, boxId.length())
                                .equals(boxIdToCompare.substring(i + 1, boxId.length()))) {
                            builder.append(boxId, 0, i);
                            builder.append(boxId, i + 1, boxId.length());
                        }
                    }
                }

                // stop searching
                if (builder.length() != 0) {
                    break;
                }
            }

            // stop searching
            if (builder.length() != 0) {
                break;
            }
        }

        // we have a result
        if (builder.length() != 0) {
            System.out.println("Day02 # Characters: " + builder.toString());
        }
    }
}
