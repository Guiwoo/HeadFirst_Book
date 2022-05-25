public class MakeHippo{
  public static void main(String[] args){
    Hipo h = new Hipo("Buffy");
    System.out.println(h.getName());
  }
}

class Hipo extends Animal{
  public Hipo(String name){
    super(name);
  }
}

abstract class Animal{
  private String name;
  public String getName(){return name;}
  public Animal(String theName){
    name = theName;
  }
}
