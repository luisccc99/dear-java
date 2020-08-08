
public class StaticTests extends StaticSuper {
    static int rand;

    static {
        String no = "no";
        rand = (int) (Math.random() * 6);
        for(int i = 0; i < rand; i++) {
            no += "o";
        }
        System.out.println(no);
    }

    StaticTests() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        System.out.println("in main");
        StaticTests st = new StaticTests();
        
    }
}

class StaticSuper {

    static {
        System.out.println("I am your father");
    }

    StaticSuper() {
        System.out.println("super constructor");
    }

}

