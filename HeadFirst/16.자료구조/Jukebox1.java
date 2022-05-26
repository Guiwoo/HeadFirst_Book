import java.util.*;
import java.io.*;

public class Jukebox1 {
    ArrayList<String> songList = new ArrayList<>();

    public static void main(String[] args) {
        new Jukebox1().go();
    }

    public void go() {
        getSongs();
        Collections.sort(songList);
        System.out.println(songList);
    }

    void getSongs() {
        try {
            File file = new File("./HeadFirst/SongList.txt");
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bf.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        songList.add(tokens[0]);
    }
}