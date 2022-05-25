public class PhraseOMatic {
public static void main(String[] args){
String[] wordListOne={"24/7","multi-Tier","30,000 feet","B-to-B","win-win","front-end","web-base","pervasive","smart","six-sigma","critical-path","dynamic"};
String[] wordListTwo={"empowered","sticky","valued-added","oriented","centric","distributed","clustered"};
String[] wordListThree={"process","tipping-point","solution","architectrue","core competency","paradigm","mission"};

int oneLength = wordListOne.length;
int twoLength = wordListTwo.length;
int threeLength = wordListThree.length;

int rand1 = (int) (Math.random()*oneLength);
int rand2 = (int) (Math.random()*twoLength);
int rand3 = (int) (Math.random()*threeLength);

String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
System.out.println(phrase);
}
}