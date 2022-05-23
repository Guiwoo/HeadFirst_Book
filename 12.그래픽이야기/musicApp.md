# 뮤직 비디오 를 만ㄷ르어 보자.

    - 음악 자체에 의해 ㅅ생성 되는 Gui와 무관한 이벤트를 등록
    - 그에 대한 리스너를 제작

- 특정 종류의 미디 이벤트를 받아야 한다.
- 음악의 박자를 듣는 가장 간단한 방법 ?

  - 시퀀서에서 이벤트를 받을 떄마다 우리코드에서도 이벤트 를 받는 방법
  - 불가능!!, 우리가 만든 노트는 우리가 다시 받을수 없다.
  - controllEvent 를 활용 음악 시퀀스를 다음과 같이 돌린다.
    - 첫번째 박자 = note on 컨트롤러 이벤트
    - 두번쨰 박자 = note off
    - 세번쨰 박자 = note on 컨트롤러 이벤트
    - 네번째 박자 = note off

- 메세지/이벤트를 쉽게 만드는 방법

  - 정적유틸리티로 작성
  - 인자로 다받아서 만들면됨
  - [Check Code](./MiniMusicPlayer1.java)

- 컨트롤 이벤트를 등록하고 받는 방법

  - implements 로 ControllerEventListener 를 등록
  - controllChange 로 이벤트 핸드러 메소드를 구현
  - [Check Code](./MiniMusicPlayer2.java)

- 음악에 맞춰서 그래픽을 표시하는 프로그램
  - 그림 패널도 implents 로 ControllEvnetListener 를 등록
  - controllChange 는 뭐써야함 ?
    - rePaint(); 로 다시칠해주면 그만.
  - 그림패널을 내부클래스로 구현 왜 ?
    - frame 을 써야하니꼔
  - [Check Code](./MiniMusic3.java)
