import java.util.ArrayList;

public class ArrayListMagnet {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add(0, "zero");
        a.add(1, "one");
        a.add(2, "two");
        a.add(3, "three");
        printAL(a);

        a.remove(2);
        if (a.contains("three")) {
            a.add("four");
        }
        printAL(a);

        if (a.indexOf("four") != 4) {
            a.add(4, "4.2");
        }
        printAL(a);

        if (a.contains("two")) {
            a.add("2.2");
        }
        printAL(a);
    }

    public static void printAL(ArrayList<String> a) {
        for (String el : a) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
}
