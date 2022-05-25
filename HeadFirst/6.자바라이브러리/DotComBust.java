import java.util.*;

public class DotComBust {
  public static void main(String[] args) {
    DotComBust game = new DotComBust();
    game.setUpGame();
    game.startPlaying();
  }

  private GameHelper helper = new GameHelper();
  private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
  private int numOfGuesses = 0;

  private void setUpGame() {
    DotCom one = new DotCom();
    one.setName("Pets.com");
    dotComsList.add(one);

    DotCom two = new DotCom();
    two.setName("eToys.com");
    dotComsList.add(two);

    DotCom three = new DotCom();
    three.setName("Go2.com");
    dotComsList.add(three);

    System.out.println("Your goal is to sink there dot coms.");
    System.out.println("Pets.com, eToys.com, Go2.com");
    System.out.println("Try to sink them all in the fewest number of guesses");

    for (DotCom dotComToSet : dotComsList) {
      ArrayList<String> newLocation = helper.placeDotCom(3);
      dotComToSet.setLocationCells(newLocation);
    }
  }

  private void startPlaying() {
    while (!dotComsList.isEmpty()) {
      String userGuess = helper.getUserInput("Enter a Guess");
      checkUserGuess(userGuess);
    }
    this.finishGame();
  }

  private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "miss";
    for (DotCom dotComToTest : dotComsList) {
      result = dotComToTest.checkYourself(userGuess);
      if (result.equals("hit")) {
        break;
      }
      if (result.equals("kill")) {
        dotComsList.remove(dotComToTest);
        System.out.println(result);
      }
    }
  }

  private void finishGame() {
    System.out.println("All Dot Coms are daed! YOur stock is now worthless.");
    if (numOfGuesses < 18) {
      System.out.println("It only took you " + numOfGuesses + " guess .");
      System.out.println("You got out before your options snak.");
    } else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
      System.out.println("Fish are dancing with your options.");
    }
  };

}
