public class Of76 extends Clowns {
    public static void main(String[] args) {
        Nose[] i = new Nose[3];
        i[0] = new Clowns();
        i[1] = new Acts();
        i[2] = new Of76();

        for (int j = 0; j < i.length; j++) {
            System.out.println(i[j].iMethod() + " " + i[j].getClass());
        }
    }
}

interface Nose {
    int iMethod();
}

abstract class Picasso implements Nose {
    public int iMethod() {
        return 7;
    }
}

class Clowns extends Picasso {
}

class Acts extends Clowns {
    public int iMethod() {
        return 5;
    }
}
