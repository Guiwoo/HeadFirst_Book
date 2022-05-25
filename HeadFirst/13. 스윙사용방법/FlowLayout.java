import javax.swing.*;
import java.awt.*;

class FlowLayout {
    public static void main(String[] args) {
        FlowLayout fw = new FlowLayout();
        fw.gui();
    }

    public void gui() {
        JFrame frame = new JFrame();
        JPanel pannel = new JPanel();
        pannel.setBackground(Color.CYAN);

        pannel.setLayout(new BoxLayout(pannel, BoxLayout.Y_AXIS));
        JButton button = new JButton("I am a btn");
        JButton button2 = new JButton("I am a btn");

        pannel.add(button);
        pannel.add(button2);
        frame.getContentPane().add(BorderLayout.EAST, pannel);
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}