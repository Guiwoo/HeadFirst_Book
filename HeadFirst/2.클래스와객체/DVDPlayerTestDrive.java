class DVDPlayer{
	boolean canRecord = false;
	void recordDVD(){
		System.out.print("DVD recording");
	}
	void playDVD(){
		System.out.print("DVD is Playing");
	}	
}

class DVDPlayerTestDrive{
public static void main(String[] args){
	DVDPlayer d = new DVDPlayer();
	d.canRecord = true;
	d.playDVD();
	
	if(d.canRecord){
		d.recordDVD();
	}
}
}
