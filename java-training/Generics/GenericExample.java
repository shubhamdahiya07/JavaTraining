package Generics;

import java.io.Serializable;
import java.util.List;

public class GenericExample {
  public static void main(String[] args) {
    // Generic class
    Printer<Integer> printer = new Printer<Integer>(5);
    printer.print();

    // Bounded generics
    Dog dog = new Dog();
    BoundedGeneric<Dog> boundedGeneric = new BoundedGeneric<>();
    boundedGeneric.print(dog);

    // Generic method
    print("Hello");

    // wildcard
    List<Integer> list = List.of(1, 2, 3);
    printList(list);
  }

  // Generic method
  private static <T> void print(T thingToPrint) {
    System.out.println(thingToPrint);
  }

  // Wildcard method
  // ? is used to represent an unknown type
  // ? can be used with bounded generics
  // eg. List<? extends Animal>
  private static void printList(List<?> list) {
    System.out.println(list.toString());
  }
}

class Printer<T> {
  private T thingToPrint;

  public Printer(T thingToPrint) {
    this.thingToPrint = thingToPrint;
  }

  public void print() {
    System.out.println(thingToPrint);
  }
}

// can only be used with classes that extend Animal
class BoundedGeneric<T extends Animal> {
  public void print(T thingToPrint) {
    System.out.println(thingToPrint);
  }
}

// Multiple bounds
class MultipleBounds<T extends Animal & Serializable> {
  public void print(T thingToPrint) {
    System.out.println(thingToPrint);
  }
}