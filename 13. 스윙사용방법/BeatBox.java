import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.sound.midi.*;
import java.util.*;

public class BeatBox {
    JFrame theFrame;
    JPanel mainPanel;
    ArrayList<JCheckBox> checkboxList; // 체크상자를 arraylist 에 저장합니다.
    Sequence sequence;
    Sequencer sequencer;
    Track track;
    String[] instrumentsNames = { "Bass Drum", "Close Hi-Hat", "Open Hi-Hat", "Acoustic Snare",
            "Crash Symbol", "Hand Clap", "High Tom", "Hi Bongo", "Marcas", "Whistle", "Low Conga", "Cowbell",
            "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"
    };
    int[] instruments = { 35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63 };
    // 실제 드럼 건반을 나타낸다.

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    public void buildGUI() {
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout layout = new BorderLayout();
        JPanel backGround = new JPanel(layout);
        backGround.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // 비어있는 경계선을 사용하여 패널 둘레와 구성요가 들어가는 자리 사이에 빈 공간을 만들 수 있다.

        checkboxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentsNames[i]));
        }
        backGround.add(BorderLayout.EAST, buttonBox);
        backGround.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(backGround);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        backGround.add(BorderLayout.CENTER, mainPanel);

        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox(); // 체크상자를 ㄹ만들고 모든값을 flase 로 설정 후 gui 패널에 추가.
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        theFrame.setBounds(50, 50, 300, 300);
        theFrame.pack();
        theFrame.setVisible(true);
    }

    public void setUpMidi() {
        try { // 시퀀서 스퀀스 트랙을 만들기 위한 미디 관련 코드
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart() { // 체크상자의 상태를 midi 이벤트로 바꾼다음 그 이벤트를 트랙에 추가.
        int[] trackList = null; // 열어섯박자에 대한 값을 원소가 16개인 배열에 지정
        sequence.deleteTrack(track); // 기존 트랙을 제거하고 트랙을 새로 생성.
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) { // 열 16개 모우데 대해 같은 작업을 처리한다.
            trackList = new int[16];
            int key = instruments[i]; // 어떤 악기인지 를 나타내는 번호만 선정 한다.

            for (int j = 0; j < 16; j++) { // 이 열에 들은 모든 박자에대해 같은 작업을 반복한다.
                JCheckBox jc = checkboxList.get(j + (16 * i));
                if (jc.isSelected()) { // 해당박자가 체크상자가 선택 되었다면 확인 선택이 되었다면 배열의 그자리에 건반 값을 대입
                    trackList[j] = key; // 그렇지 않다면 연주 하지 않아야 함으로 0 을 대입
                } else {
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList); // 악기 16개의 모든 박자에대해 이벤트를 만들고 트랙에 추가한다.
            track.add(makeEvent(176, 1, 127, 0, 16));
        }

        track.add(makeEvent(192, 9, 1, 0, 15)); // 16번쨰 박자에는 반드시 이벤트가 존재해야함
        // 그렇지 않다면 16박자가 모두 끝나지 않을수 있다.
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY); // 루프반복회수 를 지정하기 위한 메소드 여기에서는 계속 반복"Loop_CONTINUOUSLY"
            sequencer.start();
            sequencer.setTempoInBPM(120); // 띠리링 연주
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeTracks(int[] list) { // 한악기 의 16 박자에 대한 이벤트를 만든다. 0이 아닌 값이 들어있다면 0이 들어간다.
        for (int i = 0; i < 16; i++) {
            int key = list[i];
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    public class MyStartListener implements ActionListener { // 첫번째 클래스의 리스너인 이너클래스
        public void actionPerformed(ActionEvent a) {
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener {// 두번째 클래스의 리스너인 이너클래스
        public void actionPerformed(ActionEvent a) {
            sequencer.stop();
        }
    }

    public class MyUpTempoListener implements ActionListener {// 세번째 클래스의 리스너인 이너클래스
        public void actionPerformed(ActionEvent a) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * 1.03));
        }
    }

    public class MyDownTempoListener implements ActionListener {// 네번째 클래스의 리스너인 이너클래스

        @Override
        public void actionPerformed(ActionEvent e) {
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float) (tempoFactor * .97));
        }

    }
}