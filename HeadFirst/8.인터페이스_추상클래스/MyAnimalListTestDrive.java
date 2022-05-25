import java.util.ArrayList;

public class MyAnimalListTestDrive {
  public static void main(String[] args) {
    ArrayList<Integer> randomList = new ArrayList();
    for (int i = 0; i < 6; i++) {
      randomList.add((int) Math.random() * 10);
    }
    String randomNum = "";
    for (int i = 0; i < 6; i++) {
      randomNum += Integer.toString(randomList.get(i));
    }

    MyAnimalList list = new MyAnimalList();
    Dog a = new Dog();
    Cat c = new Cat();
    list.add(a);
    list.add(c);
    // Animal ab = new Dog();
    // ab.bark();
  }
}

class MyAnimalList {
  private Animal[] animals = new Animal[5];
  private int nextIdx = 0;

  public void add(Animal a) {
    if (nextIdx < animals.length) {
      animals[nextIdx] = a;
      System.out.println("Animal added at " + nextIdx);
      nextIdx++;
    }
  }
}

class Animal {
  int age;
  String name;
}

class Cat extends Animal {
}

class Dog extends Animal {
  public void bark() {
  };
}
