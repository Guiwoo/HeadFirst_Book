# 객체 저장

    객체를 납작하게 압축시킬 수도 있고, 빵빵하게 부풀릴수 도 있다 ?

1. 데이터를 자바 프로그램에서만 사용한다면 ?
   - **직렬화를 사용**
2. 다른프로그램 에도 사용하단면 ?
   - **텍스트 파일로 저장**

## 상태저장

    판타지 어드벤쳐 게임이라고 가정

- 직렬화된 캐릭터 객체 3개를 파일에 저장
- 일반 텍스트 파일로 저장

### 직렬화된 객체를 파일에 저장하는 방법

    FileOutputStream 을 만든다.
    ObjectOutputStream 을 만든다.
    객체를 저장한다.
    OBjectOuputStream 을 닫는다.

- **데이터는 스트림 형태로 이동한다.**

  - Connection Stream
    - 출발지 또는 목적지로 의 연결을 나타냄
  - Chain Stream
    - 혼자서는 어디에 연결될수 없고 반드시 커넥션 스트림과 연결되어야함

- ex) 객체 => ObjectOutputStream => 010101010101 => file

- 직렬화가 되면 객체는 어떻게 되는가 ?

  - Foo my foo =new foo() ~~~
  - 01010111 00001001 01010010

- 객체의 상태란 무엇을 의마하고 무엇을 저장해야하는가 ?
  - 인스턴수 변수로 참조되는 모든 객체 또한 직렬화됨
  - 레퍼런스가 아닌 포인팅하고 있는 모든것을 저장함.

#### 클래스를 직렬화 하고싶다면 ? "Serializable"

    marker or tag interface 는 구현할 메소드가 단 하나도 없다.

- 상위클래스가 Serializable 이라면 하위클래스 또한 직렬화가 가능하다.
- 객체를 저장할떄 그 객체와 관련 것들이 모두 제대로 직렬화 되지 않는다면 ?
  - 직려화 할수가 없으면 에러 발생 "java.io.NotSerializable"
- 어떤 인스턴트 변수를 저장할수 없다면 ? 저장하면 안된다면 ?
  - transient 를 달아주자(transient String password;)
  - 이렇게 되어 만약 복구를 하게 된다면 어떻게 되는가 ?
    - 최초 직렬화 당시 null 값이되고 복구시 특정 값으로 지정해주면됨.

#### 역직렬화 객체복구

    FileInputStream 을 만든다
    ObjectInputStream 을 만든다.
    객체를 읽는다.
    객체를 캐스트 한다
    ObjectInputStream 을 닫는다.

- 역직렬화할 때는 어떤 일이 일어날까요 ?
  - 스트림으로부터 객체를 읽어온다.
  - jvm에서 객체의 클래스 유형을 결정한다.
  - jvm에서 객체의 클래스를 찾아서 불러오려는 시도를 한다.
  - 새로운 객체는 힙에 공간할당을 받으나 직렬화된 객체의 생성자는 실행x
  - 상속트리에서 그위 어딘가에 직렬화할수 없는 클래스가 있다면. 그 클래스 를 기점으로 줄줄이 생성자 를 실행함. 모든 상위 클래스의 생성자 에서 상태를 초기화 시킴
  - 객체의 인스턴스 변수에 직렬화된 상태값이 대입된다.
- [게임 케릭터 저장 및 불러오기](./GameServerTest.java)

##### Keypoint

- 객체를 직렬화 하면 객체의 상태를 저장할수 있음
- 객체를 직렬화 하려면 ObjectOuptStream
- 스트림에는 연결 스트림 과 연쇄스트림이 있음
- 객체를 직렬화 해서 파일로 저장하고 싶다면 FileOuptStream 을 만들어 이 스트림에 ObjectOutputStream 을 체인하면됨
- 객체를 직렬화 할때는 ObjectOutputStream 의 writeObejct 메소드를 호출하면됨
- Serializable 인터페이스를 구현하는 클래스 의 객체만 직렬화 가 가능
- 직렬중 연관된 객체 어느하나 직렬화가 불가능하다면 실행중 예외를 던진다.
- 어떤 변수를 스킵하고 싶다면 ? transient
- 역직렬화 할때는 해당 객체와 연관된 모든 객체의 클래스를 사용할수 있어야만한다.
- readObject() 의 리턴유형은 object이므로 역직렬화 과정에서 원래유형으로 캐스팅 되어야함
- 정적변수는 직렬화 되지 않는다.

### String 을 파일에 저장하는 방법

    fileWriter.write("My First String to save")

- [QuizCardBuilder](./QuizCardBuilder.java)
  - 파일 메뉴가 있고 메뉴에 현재 암기장 텍스트 파일로 저장하기 위한 save
- Java.io.File 클래스

  - File 객체는 디스크에 있는 파일이나 디렉토리의 이름과 경로를 나타냄

- **버퍼의 미학**
- 버퍼없이 프로그래밍 하는것은 쇼핑카트 없이 쇼핑하는 것과 마찬가지 이다.
  BufferedWriter writer = new BufferedWriter(new FileWriter(aFile))
- 메소드를 호출할때 항상 bufferedWriter 를 사용하고 닫는것도 파일을 닫는것이 아닌 BufferedWriter 를 닫아준다.
- writer.flush 는 버퍼가 가득차기전 에 당장 데이터를 보내 줄수 있다.

-[QuizCardPlayer](./QuizCardPlayer.java)

- FileReader, BufferedReader

- 스플릿을 이용한 파싱
  - String 의 split 을 이용하면 여러조각으로 나눌수 있다.

## 버전ID 직렬화 할때 주의할 부분

- 버전제어가 정말중요하다.

  - 역직렬화 할떄 클래스를 변경했을 경우 ? 문제를 야기한다.
  - 클래스를 변경했을 때 역직렬화 과정에서 문제가 일어나는 경우

    - 변수를 삭제, 변수유형을 변경, transient 로 갑자기 지정
    - 클래스 상속을 위나 아래로 변경, 인스턴스 변수를 정적변수로 사용
    - Serializable 이 아닌 클래스로 변경

  - 클래스를 변경해도 문제가 발생 안하는 경우
    - 클래스에 새로운 인스턴스를 추가
    - 상속트리에 클래스를 추가
    - 상속트리에서 클래스를 제거
    - 변수의 값 대입하는데 문제가 없는 범위내에서 수정
    - transient 였던 변수를 아닌경우로 변경

- 클래스를 직렬화 하면 클래스의 버전ID번호가 찍힌다. "serialVersionUID"
  - 클래스가 바뀔 가능성이 있다면 집어넣자
  - static final long serializableUID = -123812432948328l;
