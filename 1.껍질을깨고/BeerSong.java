public class BeerSong{
	public static void main(String[] args){
		int beer = 99;
		while(beer != 0){
			if(beer == 1){
				System.out.println("bottle");
			}
			System.out.println("Beer left :"+beer+" On the wall");
			System.out.println("Take one down");
			System.out.println("pass it around");
			beer--;
			System.out.println("Beer left :"+beer);
		}
		System.out.println("No more bottles of beer on  the wall");
	}
}
