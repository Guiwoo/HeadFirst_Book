class MovieTestDrive{
  public static void main(String[] args){
    Movie one = new Movie();
    one.title = "Star wars 1";
    one.genre = "SF,Adventure";
    one.rating = 5;

    Movie two = new Movie();
    two.title = "Avengers";
    two.genre = "Adventure";
    two.rating = 3;
    two.playIt();

    Movie three = new Movie();
    three.title = "End game";
    three.genre = "HOLY";
    three.rating = 4;
  }
}

class Movie{
String title;
String genre;
int rating;

void playIt(){
System.out.println("Start a movie !!!....");
}
}
