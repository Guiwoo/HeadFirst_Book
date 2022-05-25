class DogTestDrive {
public static void main(String[] args){
	Dog d = new Dog();
	d.size = 40;
	d.bark();
}
}

class Dog {
String name;
int size;
public void bark(){
	System.out.println("ouupouup!!");
}
}
