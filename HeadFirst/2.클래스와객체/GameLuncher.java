class GuessGame{
 Player p1;
 Player p2;
 Player p3;

 public void startGame(){
  p1 = new Player();
  p2 = new Player();
  p3 = new Player();

  int guessp1 = 0;
  int guessp2 = 0;
  int guessp3 = 0;

  boolean p1isRight = false;
  boolean p2isRight = false;
  boolean p3isRight = false;

  int targetNumber = (int) (Math.random()*10);
  System.out.println("0이상 9이하 숫자를 맞춰보세요");

  while(true){
   System.out.println("맞춰야 할 숫자는"+targetNumber+"입니다.");
   p1.guess();
   p2.guess();
   p3.guess();

   guessp1 = p1.number;
	System.out.println("1번 선수가 찍은 숫자 "+guessp1);
   guessp2 = p2.number;
	System.out.println("2번 선수가 찍은 숫자 "+guessp2);
   guessp3 = p3.number;
	System.out.println("3번 선수가 찍은 숫자 "+guessp3);
   if (guessp1 == targetNumber){
     p1isRight = true;
   }
   if (guessp2 == targetNumber){
     p2isRight = true;
   }
   if (guessp3 == targetNumber){
    p3isRight = true;
   }
  
   if(p1isRight || p2isRight || p3isRight){
    System.out.println("맞춘선수가 있습니다.");
    System.out.println("1번 "+guessp1);
    System.out.println("2번 "+guessp2);
    System.out.println("3번 "+guessp3);
    System.out.println("게임 끝...");
    break;
   }else{
    System.out.println("다시 시도해야합니다.");
   }
  }
 }
}

class Player{
	int number = 0;
	public void guess(){
		number = (int) (Math.random()*10);
		System.out.println("찍은숫자 "+number);
	}
}

public class GameLuncher {
	public static void main(String[] args){
		GuessGame game = new GuessGame();
		game.startGame();
	}
}
