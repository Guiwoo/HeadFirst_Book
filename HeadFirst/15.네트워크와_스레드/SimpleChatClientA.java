import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleChatClientA {
    JTextField outgoing;
    PrintWriter writer;
    Socket socket;

    public void go() {
        JFrame frame = new JFrame("Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new sendButtonListener());

        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        setupNetworking();

        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setupNetworking() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(socket.getOutputStream());

            System.out.println("networking established");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    class sendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                writer.println(outgoing.getText());
                writer.flush();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText(" ");
            outgoing.requestFocus();
        }

    }

    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }
}
