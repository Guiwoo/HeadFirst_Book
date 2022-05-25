import java.io.*;

public class BoxExample implements Serializable {
    // Serializable means 직렬화 가능한 객체
    private int width;
    private int height;

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public static void main(String[] args) {
        BoxExample myBox = new BoxExample();
        myBox.setHeight(20);
        myBox.setWidth(50);

        try {
            FileOutputStream fs = new FileOutputStream("foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myBox);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
