import java.util.*;
import java.io.*;

public class Jukebox8 {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new Jukebox1().go();
    }

    class ArtistCompare implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {
            // TODO Auto-generated method stub
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        // ArtistCompare artistCompare = new ArtistCompare();
        // Collections.sort(songList, artistCompare);
        // Collections.sort(songList);
        // HashSet<Song> songSet = new HashSet<Song>();
        TreeSet<Song> songSet = new TreeSet<Song>();
        songSet.addAll(songList);

        System.out.println(songSet);
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
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}