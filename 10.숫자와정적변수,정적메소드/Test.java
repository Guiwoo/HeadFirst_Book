public class Test {
    public static void main(String[] args) {
        System.out.println("Test.main() " + Player.cnt);
        Player p = new Player("messi");
        System.out.println(p.cnt);
        System.out.println(Player.cnt);
        Foo5 f5 = new Foo5();
        f5.go(5);
        System.out.println(f5.x);
    }
}

class Player {
    static int cnt = 0;
    private String name;

    public Player(String name) {
        this.name = name;

    }
}

class Foo3 {
    final int x;
    static {
        x = 2;
    }

    public void go() {
        System.out.println(x);
    }
}

class Foo5 {
    int x = 12;

    public void go(final int x) {
        System.out.println(x);
    }
}