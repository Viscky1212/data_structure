package patternBase.stack;

import java.util.Arrays;

public class JavaTesting {

    String name;
    String address;
    int age;


    public JavaTesting(String name, String address, int age) {
        this.address = address + " (from constructor)";
        this.name = name + " (from constructor)";
        this.age = age + 5; // Adding 5 to age for demonstration
    }

    public static void main(String[] args) {
        JavaTesting testing = new JavaTesting("John Doe", "123 Main St", 30);
//        testing.name = "John Doe";
//        testing.address = "123 Main St";
//        testing.age = 30;
        System.out.println("Name: " + testing.name);
        System.out.println("Address: " + testing.address);
        System.out.println("Age: " + testing.age);
    }
}
