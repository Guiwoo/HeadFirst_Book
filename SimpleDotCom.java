public class SimpleDotCom {
    int[] locationsCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs) {
        locationsCells = locs;
    }

    public String checkYourself(String stringGuess) {
        int guess = Integer.parseInt(stringGuess);
        String result = "miss";

        for (int i = 0; i < locationsCells.length; i++) {
            if (guess == locationsCells[i]) {
                result = "hit";
                numOfHits++;
                break;
            }
        }

        if (numOfHits == locationsCells.length) {
            result = "kill";
        }
        System.out.println(result);

        return result;
    }
}