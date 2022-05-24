import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GameServerTest {
    public static void main(String[] args) {
        GaemCharacter one = new GaemCharacter(50, "ELF", new String[] { "bow", "sword", "dustt" });
        GaemCharacter two = new GaemCharacter(50, "Troll", new String[] { "bare hands", "ax" });
        GaemCharacter three = new GaemCharacter(50, "Magician", new String[] { "spell", "invisibility" });

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
        } catch (IOException e) {
            e.printStackTrace();
        }
        one = null;
        two = null;
        three = null;

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GaemCharacter oneRestore = (GaemCharacter) is.readObject();
            GaemCharacter twoRestore = (GaemCharacter) is.readObject();
            GaemCharacter threeRestore = (GaemCharacter) is.readObject();
            System.out.println("One " + oneRestore.getType());
            System.out.println("Two " + twoRestore.getType());
            System.out.println("Three" + threeRestore.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class GaemCharacter implements Serializable {
    int power;
    String type;
    String[] weapons;

    public GaemCharacter(int p, String t, String[] w) {
        power = p;
        type = t;
        weapons = w;
    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }

    public String getWeapons() {
        String weaponList = "";
        for (int i = 0; i < weapons.length; i++) {
            weaponList += weapons + " ";
        }
        return weaponList;
    }
}
