import java.io.IOException;

import javax.sound.midi.*;

public class MusicTest1 {
  public void play() {
    try {
      Sequencer se = MidiSystem.getSequencer();
      System.out.println("We got a Sequencer");
    } catch (MidiUnavailableException e) {
      System.out.println("Bummer");
    }
  }

  public static void main(String[] args) {
    MusicTest1 m = new MusicTest1();
    m.play();
  }
}
