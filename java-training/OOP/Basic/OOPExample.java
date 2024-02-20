package OOP.Basic;

/*
Interfaces are abstract definition methods and attributes that a class must implement.
Interfaces are used in Java to achieve abstraction.

Abstraction means showing only the external features and hiding the details.
Interfaces only contain definition of methods. The detail of their implementation
is contained in classes that choose to implement the interface.
 */

/*
In the following example, Polygon interface defines the functions
that are common to all the polygons.
 */

import java.sql.SQLOutput;

interface Polygon {
    int area();
    int perimeter();
}

class Rectangle implements Polygon {
    int length, breadth;
    String color;
    Rectangle(int length, int breadth, String color) {
        this.length = length;
        this.breadth = breadth;
        this.color = color;
    }

    // Class Rectangle has its own implementation of area() and perimeter()
    public int area() {
        return length * breadth;
    }

    public int perimeter() {
        return 2 * (length + breadth);
    }

    public String getColor() {
        return color;
    }
}

/*
Square utilized the implementation of area() and perimeter() from Rectangle
and need not implement it again.
 */

class Square extends Rectangle {
    Square(int side, String color) {
        super(side, side, color);
    }
}

public class OOPExample {
    public static void main(String[] args) {
        // Creating an object of rectangle

        Rectangle rect = new Rectangle(20, 10, "blue");
        System.out.println("Area of rectangle: " + rect.area());

        /*
        Creating an object of an interface is not possible
        However, we can create reference variables of interfaces.
         */
        Polygon examplePolygon;

        /*
         These reference variables can refer to the objects of the
         classes that implement the interface
         */

        Polygon rectPolygon = new Rectangle(15, 12, "yellow");

        /*
        Note: a reference of an interface can only call methods
        whose method definition is present in the interface itself.
        Any method defined in the subclasses can not be called using
        reference of interface.

        This happens because the method calls are resolved during
        runtime and the compiler does not know that the reference of interface
        stores reference of a subclass.


        For example: rectPolygon stores the reference of Rectangle object.
        It can call area() and perimeter() on that object but not getColor()
        which is defined in the subclass Rectangle and not in the interface
        Polygon.
         */

        System.out.println("Area of rectPolygon: "+ rectPolygon.area());
        // Compile time error:
        // System.out.println("Color of rectPolygon: " + rectPolygon.getColor());

    }
}