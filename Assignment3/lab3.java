/* Write a Java Program to implement method overloading and method overriding in Java.
1. Write a class Shapes. Find the area of basic shapes using polymorphism (constructor overloading and method overloading).
2. Write a Java program to create a parent class Hillstations and three subclasses by hillstation names. Subclasses extend the superclass and override methods famousfood() and
famousfor(). Call the methods famousfood() and famousfor() by the Parent class, i.e. Hillstations class. It should refer to the base class object and the base class method
overrides the superclass method, base class method is invoked at runtime. */

class Shapes {
    double area;
    Shapes(double radius) {
        area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
    Shapes(double length, double breadth) {
        area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }
    Shapes(double base, double height, boolean isTriangle) {
        area = 0.5 * base * height;
        System.out.println("Area of Triangle: " + area);
    }
    void calculateArea(int side) {
        System.out.println("Area of Square: " + (side * side));
    }
    void calculateArea(int length, int breadth) {
        System.out.println("Area of Rectangle(MethodOverloading): " + (length * breadth));
    }
}

class Hillstations {
    void famousfor() {
        System.out.println("Hill station is famous for natural beauty.");
    }
    void famousfood() {
        System.out.println("Hill station has local traditional food.");
    }
}

class Manali extends Hillstations {
    void famousfor() {
        System.out.println("Manali is famous for snow and mountains.");
    }
    void famousfood() {
        System.out.println("Manali famous food: Siddu.");
    }
}

class Mussoorie extends Hillstations {
    void famousfor() {
        System.out.println("Mussoorie is famous for scenic beauty.");
    }
    void famousfood() {
        System.out.println("Mussoorie famous food: Momos.");
    }
}

class Mahabaleshwar extends Hillstations {
    void famousfor() {
        System.out.println("Mahabaleshwar is famous for strawberries.");
    }
    void famousfood() {
        System.out.println("Mahabaleshwar famous food: Strawberry cream.");
    }
}

public class lab3 {
    public static void main(String[] args) {
        System.out.println("SHAPES : ");
        Shapes s1 = new Shapes(5.0);
        Shapes s2 = new Shapes(4.0, 6.0);
        Shapes s3 = new Shapes(3.0, 5.0, true);

        s1.calculateArea(4);
        s1.calculateArea(4, 5);

        System.out.println("\nHILL STATIONS : ");
        Hillstations h;
        h = new Hillstations();
        h.famousfor();
        h.famousfood();

        h = new Manali();
        h.famousfor();
        h.famousfood();

        h = new Mussoorie();
        h.famousfor();
        h.famousfood();

        h = new Mahabaleshwar();
        h.famousfor();
        h.famousfood();
    }
}