import java.util.ArrayList;

public class DotCom{
    ArrayList<String> locationsCells;
    int numOfHits = 0;
    
    public void setLocation(ArrayList<String> locs){
      locationsCells = locs;
    }

    public String checkYourself(String userInput){
      String result = "missed";
      int index = locationsCells.indexOf(userInput);
      
      if (index > 0){
        locationsCells.remove(index);
        if(locationsCells.isEmpty()){
          result = "kill";
        }else{
          result = "hit";
        }
      }
      return result; 
    }
}
