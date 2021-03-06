# 심각한 다형성

    - 상속은 시작에 불과하다, 인터페이스 와 추상클래스 를 이용한 정말 필수불가결한 부분!

### 지난번 동물 클래스 의 계층을 기억해보자.

- 클래스 구조 나쁘지 않았다.
- 하위클래스 마다 구현해야 하는 부분은 별도의 오버라이딩을 통해 깔끔하게 구현.

```java
Wolf aWolf = new Wolf(); // wolf 객체
Animal aHipo = new Hipo(); // hipo 객체
Animal anim = new Animl(); // ? 이객체는 그러면 어떻게 생겨먹은거지 ?
```

- 우리가 원하는 것은 wolf hipo, Lion 같은 객체이지, animal 객체가 필요한것이 아님
- 그렇다면 인스턴스를 만들수 없게는 못할까 ? animal 객체가 필요한게 아니니깐 ?
- "abstract" 를 사용하면 이걸 해결할수 있음;

  - abstract class Animal {} 로 구현 할수 있음
  - 컴파일러 측에서 abstract 인스턴스 만드는것을 허락하지 않음.
  - **추상클래스 는 확장하지 않으면 무쓸모,가치도 없음, 추상클래스를 만들어 실행중 에 처리하는 곳은 추상클래스의 하위클래스임**

- 그래서 클래스를 만들때 인스턴스를 만들수 있는 "구상클래스","추상클래스를" 결정해야함

### 추상 VS 구상

    - 클래스는 두가지 추상 혹은 구상이 있다.

- 어떻게 추상,구상 을 할지 정할수 있을까 ?

  - ex) wine ? 은 추상클래스로 만들어야 하지 않는가 ? , Red wine ,White wine 은 ? 애네도 ?
  - 그렇다면 상속계층 어디서 부터 추상클래스를 만들어야 하는가 ?
    - Chardonnay ? 클래스는 추상? 구상 ? => 구상클래스로 구현 해야함 왜 ? 아니 이게 필요해서클래스 만드는데 추상 만들면 객체는 누가만듬

- **추상메소드**

  - 메소드 도 abstract 를 지정할수 있다.
  - public abstract void eat(); // 몸없이 이렇게 선언만 해주면 됨 ㅋㅋ
  - !! 추상 메소드를 위해서는 클래스 또한 추상 클래스 여야함, 아니라면 추상메소드를 선언할수 없음.

  - 장점 ? 이 있나 ? 불필요한 부분이 아닌가 ?
    - 실제 코드를 구성중에 상위 클래스에서 이미 구현할수 없지만 하위클래스에서 구현을 해야하는 경우 추상메소드를 선언함으로써 , 규약을 정의해줄수 있음
    - 다형성의 장점이 더욱 살아남, 이 유형의 하위클래스 는 이 메소드가 있어야 한다는 것을 지정하기 위함.
  - 추상 메소드는 모두 구현해야만 한다.(메소드르 오버라이드 하듯이)
    - Animal 추상, Cannie 추상 , Dog 구상 이라면 ?(Animal<Cannie<Dog)
    - Dog 의 구상클래스에서 Cannie 추상을 구현 해야함
      - Cannie 에도 추상메소드를 구현 안했다면 ? Dog 에서 다처리해줘야함.

### 다형성을 활용해보자.

    - ArrayList 를 모른다는 가정하에, Dog 객체를 집어넣는 클래스를 구현해보자

- Dog 배열을 사용해서, 새로운 Dog 가 Add 될때마다, 인덱스를 늘려 추가를 해주면 된다.
- **!!Cat 객체를 집어넣으려면 ?**
  - Animal 유형의 배열을 만든다. (Animal 객체를 의하는것이 아님)
- **Animal 객체가 아닌경우 라면 ?**
  - Objcet 유형의 객체 !!
- **Java 에서 모든클래스는 Object 클래스의 하위클래스이다.**

  - 명시적으로 다른클래스를 확장하지 않는 클래스는 모두 Object 를 확장한 클래스로 정의된다.
  - 뭐가 들어있는가
    - 1. boolean equals(); //객체의 같음을 판별
    - 2. Class getClass(); // 어떤 클래스의 인자인지 알수 있음.
    - 3. int hashCode(); // 객체에 해당하는 해시코드
    - 4. String toString(); // 이상한 숫자 와 문자 출력
  - Object 클래스는 추상 클래스인가 ?
    - No, 모든클래스에서 오버라이드 할필요없이 메소드를 사용할수 있음.
  - Object 메소드를 오버라이드 할수 있는가 ?
    - 몇몇 개만 가능함,(hashCode , equals,toString 은 오버라이드를 권장);
  - Obejct 는 구상클래스이니 객체를 만들수 있는데 Object도 진짜 객체라기에는 어색하지 않은가 ?
    - Object 객체가 필요한 이유는 그냥 포괄적인 상위 클래스가 필요해서.(별로 만들경우가 없다)
  - Object 는 주로 다형적인 인자 나 리턴유형에 쓰이는가 ?
    - 1. 임의 클래스 에 대해 어떤 작업을 하는 메소드를 만들 떄 다형적 유형으로 사용
    - 2. 모든객체 실행중에 필요한 진짜 메소드 코드를 제공하기 위해.

- **Object 유형의 다형적 레퍼런스 쓸때의 대가**

  - 엄청나게 유연한 메소드를 만들수 있다 , 그러나 문제점을 생각해 봐야 한다.
  - ArrayList<Object> dog = ArrayListM<Object>();
  - Dog d = new Dog(); dog.add(d);
  - Dog takeOut = dog.get(0); ? 에러가 발생함.
    - 컴파일러는 dog 가 오브젝트의 하위클래스 인걸 알지만, 그게 누군지는 모르기 에 에러.
    - 어떤 객체가 저 도그 배열에 들어가도 항상 오브젝트 의 인스턴트로 인식함.
    - 즉 객체가 그 객체의 성질을 잊어버림.
    - 컴파일러에서 어떤 메소드의 호출 여부를 결정기중는 레퍼런스 유형의 기준을 따짐

- 어떻게 피해야 하는가 ?
  - 다형성을 이용해서 피할수 있다.
    - SnowBoard s = new SnowBoard();
    - Object o = s;
  - <object> 에서 꺼낸 Dog 의 기능을 되살리는방법 /
    - Object o = dogArray.get(index);
    - Dog d = (Dog) o;
    - d.bark();

### 다중상속

    - 상위클래스를 두 개 사용하는 접근법.

- 죽음의 다이아 몬드 문제를 야기함.
- 다중 상속을 받아 똑같은 상위클래스의 메소드를 실행하면, 어디의 메소드가 실행 되는것인가 ?

- 해결하기 위해 인터페이스를 제공함.
- 인터페이스 는 100% 순수한 추상클래스
  - interface IPet{...}
  - public class Dog extends Cannie implements IPet{...}
  - interface 는 자동으로 public,abstract 시켜줌

### 어떤 클래스를 하위클래스로 만들지, 추상클래스로 만들지, 인터페이스로 만들지 ?

    - 클래스를 새로 만들려고 할떄 그 클래스가 다른 어떤 유형에 대해서도 'A-B다' 테스트가 통과안되면 그냥 클래스를 만듬.
    - 클래스의 더 구체적인 버전 을 만들고 어떤 메소드를 오버라이드 한다 ? 하위클래스를 만들어야함.
    - 하위클래스 에서 사용하고싶은 틀을 정의하고 싶다면 (메소드를 구현)? 추상클래스를 만들어야함.
    - 상속트리 에 관계없이 클래스 의 역할을 정의 하고싶다면  ? 인터페이스.

- 상위 클래스의 메소드를 호출 할떄는 어떻게 오버라이드 해야한다면 ?

```java
abstract class Report{
    void runReport(){}
    void printRepot(){}
}

class BuzzwordsReport extends Report{
    void runReport(){
        super.runReport();
        buzzWordCompliance();
        printreport();
    }
    void buzzWordCompliance();
}
```

### 핵심정리

- 클래스를 만들떄 인스턴스 선언못하게 하고싶다 ? abstract 사용
- 추상클래스 에는 추상메소드,구상메소드 모두 넣을수 있음
- 추상 메소드가 하나라도 있다면 추상클래스로 선언해야함.
- 상속트리 의 가장 처음나오는 구상클래스는 반드시 모든 추상메소드를 구현해야함.
- 자바에 들어있는 모든 클래스는 Object 의 하위 클래스
- 메소드 선언시 인자,리턴 유형을 Object 로 해도됨
- 어떤 객체의 메소드를 호출하면, 레퍼런스 변수 유형의 클래스에 반드시 그 메소드가 있어야함.
- 오브젝트 유형의 레퍼런스 변수는 캐스팅을 하지않고 다른 유형의 레퍼런스에 대입 불가능.
- 인터페이스는 순수 추상클래스임.
- 클래스를 만들떄 여러 인터페이스를 구현 할수 있음.
- 인터페이스는 모든 메소드 가 자동으로 public abstract 가 됨.
