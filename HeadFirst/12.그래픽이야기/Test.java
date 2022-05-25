import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        JButton btn = new JButton("CLick me");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fr.getContentPane().add(btn);

        fr.setSize(300, 300);
        fr.setVisible(true);
    }

}