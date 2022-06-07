import java.io.*;
import java.net.Socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImproveSimpleChat {
    JTextArea inComing;
    JTextField outGoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket socket;

    public static void main(String[] args) {
        ImproveSimpleChat client = new ImproveSimpleChat();
        client.go();
    }

    public void go() {
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();

        inComing = new JTextArea(15, 50);
        inComing.setLineWrap(true);
        inComing.setWrapStyleWord(true);
        inComing.setEditable(false);

        JScrollPane qScroller = new JScrollPane(inComing);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outGoing = new JTextField(20);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());

        mainPanel.add(qScroller);
        mainPanel.add(outGoing);
        mainPanel.add(sendButton);

        setUpNetWorking();

        Thread readerThread = new Thread(new InComingReader());
        readerThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setUpNetWorking() {
        try {
            socket = new Socket("127.0.0.1", 5500);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("✅ Network Eastblished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            try {
                writer.println(outGoing.getText());
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            outGoing.setText("");
            outGoing.requestFocus();
        }
    }

    public class InComingReader implements Runnable {
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read from server" + message);
                    inComing.append(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}