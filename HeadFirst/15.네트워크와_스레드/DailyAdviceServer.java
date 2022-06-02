import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    String[] adviceList = { "오늘하루 끝", "내일도 기운차게", "오늘 뭐 먹지" };

    public void go() {
        try {
            ServerSocket severSock = new ServerSocket(4242);

            while (true) {
                Socket sock = severSock.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvcie();
                writer.write(advice);
                writer.close();
                System.out.println(advice + "Server");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getAdvcie() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
