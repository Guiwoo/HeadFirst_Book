class PoorDog{
  private int size;
  private char name;

  public int getSize(){
    return size;
  }
  public char getName(){
    return name;
  }
}

class PoorDogTestDrive{
  public static void main(String[] args){
    PoorDog one = new PoorDog();
    System.out.println(one.getSize());
    System.out.println(one.getName());
  }
}
