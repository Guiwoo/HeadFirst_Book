public class GC{
 
  public static GC doStuff(){
    GC newGC = new GC();
    doStuff2(newGC);
    return newGC; 
  }
  
  public static void main(String[] args){
    GC gc1;
    GC gc2 = new GC();
    GC gc3 = new GC();
    GC gc4 = new GC();
    gcl = doStuff();
    // 메소드를 호출한다.
    // gc2 = null 
    // gc1 = null
    // gc4 = null
    // gc3 = gc2
    // gc1 = gc4
    // gc = null
  }

  public static void doStuff2(GC copyGC){
    GC localGC = copyGC();
  }
}
