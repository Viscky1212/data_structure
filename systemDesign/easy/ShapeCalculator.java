package systemDesign.easy;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// 1. Abstract Shape class
abstract class Shape {

    private final String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double area();

    public abstract double perimeter();

    // Common method implemented only once
    public String describe() {
        return String.format(
                Locale.US,
                "Shape: %s, Area: %.2f, Perimeter: %.2f",
                name,
                area(),
                perimeter()
        );
    }
}

// 2. Circle class
class Circle extends Shape {

    private final double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// 3. Rectangle class
class Rectangle extends Shape {

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }
}

// 4. Provided ShapeCalculator class
class ShapeCalculator {

    private final List<Shape> shapes = new ArrayList<>();

    public ShapeCalculator() {
    }

    public int addCircle(double radius) {
        shapes.add(new Circle(radius));
        return shapes.size() - 1;
    }

    public int addRectangle(double width, double height) {
        shapes.add(new Rectangle(width, height));
        return shapes.size() - 1;
    }

    public double area(int index) {
        return shapes.get(index).area();
    }

    public double perimeter(int index) {
        return shapes.get(index).perimeter();
    }

    public String describe(int index) {
        return shapes.get(index).describe();
    }

    public double totalArea() {
        double sum = 0;

        for (Shape shape : shapes) {
            sum += shape.area();
        }

        return sum;
    }



    public static void main(String[] args) {

        ShapeCalculator calculator = new ShapeCalculator();

        // Add shapes
        int circleIndex = calculator.addCircle(5);
        int rectangleIndex = calculator.addRectangle(4, 6);

        // Circle details
        System.out.println("Circle:");
        System.out.println("Area: " + calculator.area(circleIndex));
        System.out.println("Perimeter: " + calculator.perimeter(circleIndex));
        System.out.println(calculator.describe(circleIndex));

        System.out.println();

        // Rectangle details
        System.out.println("Rectangle:");
        System.out.println("Area: " + calculator.area(rectangleIndex));
        System.out.println("Perimeter: " + calculator.perimeter(rectangleIndex));
        System.out.println(calculator.describe(rectangleIndex));

        System.out.println();

        // Total area
        System.out.println("Total Area: " + calculator.totalArea());
    }
}