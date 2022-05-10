class Hobbits{
 String name;

 public static void main(String[] args){
 
  Hobbits [] h = new Hobbits[3];
  int z = 0;

  while(z<h.length){
    h[z] = new Hobbits();
    h[z].name = "Billbo";
    if(z==1){
      h[z].name = "Frodo";
    }
    if(z==2){
      h[z].name = "SAM";
    }
    System.out.print(h[z].name + "is a");
    System.out.println("Good Hobbit name..!");
    z++;
  }
 }
}
