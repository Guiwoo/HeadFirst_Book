import java.util.*;

public class DotCom {
  private ArrayList<String> locationCells;
  private String name;

  public void setLocationCells(ArrayList loc) {
    this.locationCells = loc;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String checkYourself(String userInput) {
    String status = "miss";
    int index = locationCells.indexOf(userInput);

    if (index > 0) {
      locationCells.remove(index);
      if (locationCells.isEmpty()) {
        status = "kill";
        System.out.println("Ouch! You sunk" + name + " : (");
      } else {
        status = "hit";
      }
    }
    return status;
  }
}
