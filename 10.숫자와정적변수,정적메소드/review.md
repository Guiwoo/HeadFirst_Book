# 숫자는 정말 중요합니다.

## 🚀 Math 메소드 : 거의 전역 메소드 입니다.

    - Math 클래스 안에 들어있는 수많은 함수.

- 메소드 는 인스턴스 를 사용하지 않는다.

  - ? Math myMath = new Math();
    - Compile Error;
  - 왜 안 필요한가 ? 정적 메소드 이기 때문에 필요하지 않다.

- 일반 메소드 vs 정적 메소드

  - Static 이라는 키워드의 차이에서 일반,정적 메소드를 구분한다.
    - 페러의 인스턴스 없이 메소드를 실행할수 있다.

- 정적 메소드를 호출할때 는 클래스명 을 사용한다.

  - Cat.meow();

- 정적 메소드 안에서는 인스턴스 변수를 사용할수 없다.

```java
class Cat{
    // How to handle it ?
    // private static String name;
    private String name;
    public static void main(){
        System.out.println(name); // Compile Error!
    }
}
```

- 정적 메소드 에서는 정적 메소드가 아닌 메소드도 사용할수 없다.

```java
public class Cat{
    // How to handle it ?
    private String name;
    public static void main(){
        meow(); //Compile Error
    }
    //public static void meow(){}
    public void meow(){}
}
```

### ⭐️ 정적변수

    - 클래스의 어떤 인스턴스에서든 값이 똑같습니다.
    - 정적변수 는 한클래스 의 모든 인스턴스 에서 공유한다.

```java
public class Duck{
    private int size;
    private static int duckCount = 0;
    public Duck(){
        duckCount++; //<-- duckCount 는 0 으로 재설정 되지 않음
    }
}
```

- 정적변수 초기화
  - 클래스가 로딩 될떄 초기화 된다.
  - 즉 클래스의 객체가 만들어지기 전에 초기화가 된다.

```java
class Player{
    static int playerCnt;
    public Player(){
        playerCnt++;
    }
}
class TestOut{
    public static void main(String[] args){
        System.out.println(Player.playerCnt); //0
        Player p = new Player();
        System.out.println(Player.playerCnt); // 1
    }
}
```

- static final 은 변경 불가능한 상수 입니다. (const);
  - 상수의 변수명은 모두 대문자로 작성합니다.
- static initializer "블록은 정적 변수를 초기화 하기에 딱 좋은곳"
  - static {x=42} ;
- final 키워드는 다양한곳에 사용가능
  - 메소드를 오버라이드 혹은 하위클래스 만드는것을 방지하는 용도.

## 원시유형을 포장하는 방법

    - 모든 원시유형에는 레퍼 가 있다.
    - 대문자 모시꺵이

- 값을 포장하는 방법
  - int i = 128
  - Integer iWrap = new Integer(i);
- 자바 5.0 전에는 이렇게 레핑해서 arraylist 에 집어넣어야 했음

- 자바 5.0 이후 autoboxing 자바에서 변환을 자동으로 처리해준다.

  - ArrayList<Integer> thing = new ArrayList<Integer>();

- 레핑 에는 정적 유틸리티 메소드가 있다
  - String 을 원시 값으로 해주는 마법
    - xxx.parseXxx();
  - 텍스트 로 바꿔주는 마법
    - xxx.toString();

### 숫자 포매팅

    - String.format("%, d",100000)
        -   3자리 마다 , 가 들어감.

```java
NumberFormat nf = NumberFormat.getInstance(Locale.US);
nf.format(any_number);

NumberFormat myFormat = NumberFormat.getInstance();
myFormat.setGroupingUsed(true);
myFormat.format(any_number)
```

- %[인자번호][플래그][너비][.정밀도] 유형
- format("%,6.1f",42.0000);
- [플래그] = ",",[너비] = "6" , [.정밀도] = ".1", [유형] = "f";

### 날짜 포매팅

```java
// 날짜 시간 전부
String.format("%tc",new Date());
// 시간만
String.format("%tr",new Date());
// 요일 월 일
String.format("%tA %tB %td",new Date(),new Date(),new Date());
// 세련되게 위거를
String.format("%tA %<tB %td",new Date());
```

### 시간을 앞뒤로 ?

    - Calendar 쓰자.

```java
Calendar c = Calendar.getInstance();
c.set(2004,0,7,15,40) //2004년 1월 7일 15시40분 임
long day1 = c.getTimeInMillis(); // 밀리초단위로 환산
day1 += 1000*60*60;
c.setTimeInMillis(day1) // 1시간 뒤로 미룹니다.
c.add(c.DATE,35) // 35일 더합니다.
c.roll(c.DATE,35) // 35일 뒤로 넘깁니다. 달은 바뀌지 않음
c.set(c.DATE,1) // 날자를 1로 설정
```

### 정적 임포트

```java
import static java.lang.System.out;
class Test{
    public static void main(String[] args){
        out.println("work ? yes ?")
    }
}
```
