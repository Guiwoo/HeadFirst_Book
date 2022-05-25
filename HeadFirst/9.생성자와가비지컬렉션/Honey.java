class Bees {
  Honey [] beeHA;
}
class Raccoon{
  Kit K;
  Honey rh;
}
class Kit{
  Honey kh;
}
class Bear{
  Honey huny;
}

public class Honey{
  public static void main(String[] args){
    Honey honeyPot = new Honey();
    Honey[] ha = {honeyPot,honeyPot,honeyPot,honeyPot};
    Bees b1 = new Bees();
    b1.beeHa = ha;
    Bear[] ba = new Bear[5];
    for (int i=0;i<5;i++){
      ba[i] = new Bear();
      ba[i].huny = honeyPot;
    }
    Kit k = new Kit();
    k.kh = honeyPot;
    Raccoon r= new Raccoon();
    r.rh = k;
    k = null;
  }
}
