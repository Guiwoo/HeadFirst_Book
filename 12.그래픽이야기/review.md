## GUI 그래픽 이야기.

    - GUI 는 반드시 필요하다.

### 모것은 창에서 시작된다.

- 어떻게 ?
  1. 프레임을 만든다.
     - JFrame jf = new JFrame();
  2. 위젯을 만든다.
     - JButton btn = new JButton("New");
  3. 위젯을 추가한다.
     - jf.getContentPane().add(btn);
  4. 화면을 표시한다.
     - jf.setSize(300,300)
     - jf.setVisible(true);

#### 그런데 클릭을 해도 반응이 없다

    - 클릭시 호출할 메소드.
    - 클릭을 주시할 리스너(사용자가 버튼에 대해 어떤 동작을 했다는 이벤트)

- 사용자 이벤트를 받는 방법
- "버튼 이벤트에 관심이 있다는 것을 알려주는 인터페이스를 구현"

  - "ActionListener" "ItemListener" "KeyListenr",ect..

- 리스너와 이벤트 소스 사이의 의사소통 방법

  - **리스너**
    - ActionListener 인터페이스를 구현, 버튼에 actionListener() 메소드를 구현
    - 이벤트 발생시 버튼에서 클래스로 연락
    - ActionListern 의 필수메소드 actionPerforemd() 구현
  - **이벤트 소스**
    - 버튼은 ActionEvent 의 소스 어떤객체가 이벤트 리스너인지확인
    - addActionListener() 를 호출하면 매개변수
    - 리스너 객체에 대한 레퍼를 받아 목록에 저장
    - 사용자가 버튼을 클릭시 actionPerformed() 를 호출

- 버튼의 ActionEvent 를 받는 방법
  1. 인터페이스를 구현(ActionEventListener)
     - ...implements ActionListener{}
  2. 버튼에 등록합니다.
     - btn.addActionListener(this);
  3. 이벤트 처리 메스도를 등록(actionPerformed())
     - public void actionPerforemd();

#### Gui에 뭔가를 집어넣는 3가지 방법

    1. 프레임에 위젯넣기
    2. 위젯에 2D 그래픽 을 그리기
    3. 위젯에 JPEG 넣기

- 그림을 그리기 위한 위젯을 만들기

  - JPanel 을 확장합시다.
  - 그림기리기 [Check Code](./Painting.java)
  - Jpeg넣기 [Check Code](./DrawSomi.java)

- Graphics 레퍼런스는 Graphics2D 를 참조한다.
  - Graphics2D g2d = (Graphics2D) g;

#### 이벤트를 받고 그림을 그릴려면 ?

    1. 프레임을 만들고 위젯2개(버튼,그림)을 집어넣는다.
    2. 사용자가 버튼을 클릭시 리스너의 핸들러를 호출한다.
    3. 이벤트 핸들러에서 프레임메소드를 호출한다.
    4. paintComponent가 실행되면서 원을 무작위 색으로 칠한다.

- 버튼을 클릭시 원의 색 변경 [Check Code](./SimpleGui3c.java)
- 버튼을 추가해보자
  - 그러면 이벤트 2개가 있어야하는데 ? actionPerforemed 는 한갠데 ?
    - actionPerformed 메소드를 2개 구현 "컴파일 실패"
    - 리스너버튼을 2개 모두 등록 if,else 로 처리 "코드가 지저분해짐"
    - 서로다른 ActionListener클래스 두개를 만들기
      - frame 과 label 변수를 참조할수가 없음

#### 내부클래스를 활용

    - 내부클래스를 쓰면 내부클래스를 감싸고 있는 모든것을 활용할수 있음

- 코드예제 [Check Code](./InnerEx.java)

#### 내부클래스 를 써서 애니메이션을 제작해보자.

    - 원을 왼쪽위에서 오른쪽 아래로

- js 의 frammer 를 사용할떄처럼 x,y 의 값을 매 순간 바꿔주게 ?
- 코드예제 [Check Code](./Animation.java)s
