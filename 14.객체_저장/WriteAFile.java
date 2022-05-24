import java.io.*;

public class WriteAFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("Foo.txt");
            writer.write("Hello Cute Lady");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
