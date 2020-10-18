import java.io.*;

public class GameSaverTest {
    public static void main(String[] args) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[]{"spells", "invisibility"});

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
        System.out.println("objects have been saved");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter restore1 = (GameCharacter) objectInputStream.readObject();
            GameCharacter restore2 = (GameCharacter) objectInputStream.readObject();
            GameCharacter restore3 = (GameCharacter) objectInputStream.readObject();
            System.out.println("first object type: " + restore1.getType());
            System.out.println("second object type: " + restore2.getType());
            System.out.println("third object type: " + restore3.getType());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
