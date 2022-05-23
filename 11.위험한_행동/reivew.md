# 위험한 행동.

    - 음악 프로그램을 만들어 봅시다.

- 무엇을 알아야 할까 ?
  1.  Swing GUI
  2.  네트워크 를 통해 연결하는 방법
  3.  다른시스템에 보내는 간단한 입출력

## 기초

    - JavaSound API

- MIDI 를 쓸것 음악 표준 프로토콜
- "미디 장치는 미디 파일을 일고 재생하는 방법을 알고 있는 것"

1. Sequencer 가 필요하다.

- 시퀀서 객체는 모든 미디 데이터를 모아 올바른 악기로 보내주는 객체.
- "재생장치 의 역할 을 한다."

- Sequencer seq = MidiSystem.getSequencer()
  - "컴파일 이 되지 않는다."
  - 위험 요소가 있는 메소드를 호출하기 때문에 컴파일 실패.

### 자바 메소드 에서 문제가 생기면 예외를 사용하여, 호출한 메소드에게 알려준다.

    - 메소드 선언에서 throws 구문을 찾으면 된다.

- 위험한 코드를 try/catch 구문으로 포장해주면 컴파일러의 불평은 멈춤.
- 예외도 객체입니다. Exception 의 유형이다.

- 에외를 잡는것은 코드로 처리가 가능한데 에외를 던지는것은 어떻게?

```java
public void thorwRisk() throws BadException {
    if(retarded){
        throw new BadException();
    }
}
```

    - 이렇게 던저진 에러는 호출된 메소드 에서 처리를 꼭해주어야한다.

- 컴파일러에서는 RuntimeException 을 제외한 모든것을 확인
  - RuntimeException, ClassCaseException, NullPointer

### try/catch 에서 흐름 제어.

    - try "위험한 일을 수행"
    - catch "에러를 핸들링"
    - finally "위에가 뭐가되던 무조건 실행"

### 메소드에서 예외를 2개이상 던질수도 있다.

- public void doLaundry() throws PantsException,LingeriException{}

### 예외의 다형성

    - 예외도 객체, 다형성이 적용된다.

- Excpetion ex = new PantsException(); ok!
- 다형적이라고 해서 꼭 상위 예외로 모든걸 받지는 않는다.
  - 따로 처리해야하는 에러는 빼주고 상단에 배치한다.
  - 작은것 부터 큰거로 나열해야한다.
- 바구니에 담는다고 생각하고 작은 에러 부터 처리해야한다.

## 음악 앱 만들기

1. 실제 소리를 만들어 보자.
   - 음악을 재생하는것.
   - 재생할 음악
   - sequence 실제 정보가 들어있는것
   - 실제 음악 정보

- 코드로 바꿔 본다면 ?

  1. Seqeuencer 를 구해 연다.
     - Sequencer player = MidiSystem.getSequencer();
     - player.open();
  2. 새로운 Sequencer 를 만든다.
     - Sequence seq = new Squence(timing,4);
  3. 새로운 track 을 가져온다.
     - Track t = seq.createTrack();
  4. Track 에 MidiEvent 를 채우고 Sequencer 를 넘겨준다.
     - t.add(myMidiEvent1);
     - plyaer.setSequence(seq);

- MidiEvent 를 만드는 법
  - 일련의 자동 재생 피아노용 악보
  - 무서을 할지, 언제할지를 정해준다.

```java
ShortMessage a = new ShortMessage();
a.setMessage(144,1,44,100);//44번 음표 연주 를 시작
MidiEvent noteOn = new MidiEvent(a,1);// 가동할 시기 지정
track.add(noteOn);
```

- a.setMessaeg(메세지유형, 채널, 연주할음,속도);
  - 메세지 유형
    - 144 => note On;
    - 128 => note off;
  - 채널 은 연주자 "1번 키보드 2번 드럼 ,등등"
  - 연주할음 0~127 숫자가 클수록 높은음
  - 속도 얼마나 빠르고 세게 연주할지 보통 100 을 사용
