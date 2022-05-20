public class StaticTests extends StaticSuper {

    static int rand;
    static {
        rand = (int) (Math.random() * 5);
        System.out.println("Random number is " + rand);
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
        System.out.println("super static block");
    }

    StaticSuper() {
        System.out.println("super constructor");
    }
}