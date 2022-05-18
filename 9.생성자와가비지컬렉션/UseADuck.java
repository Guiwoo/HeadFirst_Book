public class UseADuck{
  public static void main(String[] args){
    Duck d = new Duck(42);
  }
}

class Duck{
  int size;
  public Duck(int duckSize){
    System.out.println("Quack");
    size = duckSize;
    System.out.println("Size = "+size);
  }
  public Duck(){
    System.out.println("Normal Duck without Size");
  }
}
