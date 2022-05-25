import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusic3 {
    static JFrame f = new JFrame();
    static MyDrwaPa ml;

    public static void main(String[] args) {
        MiniMusic3 mini = new MiniMusic3();
        mini.go();
    }

    public void setUpGui() {
        ml = new MyDrwaPa();
        f.setContentPane(ml);
        f.setBounds(30, 30, 300, 300);
        f.setVisible(true);
    }

    public void go() {
        setUpGui();
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(ml, new int[] { 127 });
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;
            for (int i = 5; i < 60; i += 4) {
                r = (int) (Math.random() * 50 + 1);
                track.add(makeEvent(144, 1, r, 100, i));

                track.add(makeEvent(176, 1, 127, 0, i));

                track.add(makeEvent(128, 1, r, 100, i + 2));
            }

            sequencer.setSequence(seq);
            sequencer.start();
            sequencer.setTempoInBPM(220);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {
        }
        return event;
    }

    class MyDrwaPa extends JPanel implements ControllerEventListener {

        boolean msg = false;

        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }

        public void paintComponent(Graphics g) {
            if (msg) {
                Graphics2D g2d = (Graphics2D) g;

                int red = (int) (Math.random() * 255);
                int blue = (int) (Math.random() * 255);
                int green = (int) (Math.random() * 255);
                Color startColor = new Color(red, blue, green);

                int ht = (int) ((Math.random() * 150) + 10);
                int wt = (int) ((Math.random() * 150) + 10);

                int x = (int) ((Math.random() * 50) + 10);
                int y = (int) ((Math.random() * 50) + 10);
                g.setColor(startColor);
                g.fillRect(x, y, wt, ht);
                msg = false;
            }
        }

    }

}
