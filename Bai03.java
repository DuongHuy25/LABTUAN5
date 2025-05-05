package packageBai03;
import java.util.Scanner;

abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
        this.color = "red";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract String toString();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shape shape = (Shape) obj;
        return filled == shape.filled && color.equals(shape.color);
    }
}

class Circle extends Shape {
    private double radius;

    public Circle() {
        super();
        this.radius = 0.0;
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Hinh tron [radius=" + radius + ", color=" + color + ", filled=" + filled + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Circle circle = (Circle) obj;
        return Double.compare(circle.radius, radius) == 0;
    }
}

class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle() {
        super();
        this.width = 0.0;
        this.length = 0.0;
    }

    public Rectangle(double width, double length) {
        super();
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Hinh chu nhat [width=" + width + ", length=" + length + ", color=" + color + ", filled=" + filled + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Rectangle rectangle = (Rectangle) obj;
        return Double.compare(rectangle.width, width) == 0 && Double.compare(rectangle.length, length) == 0;
    }
}

class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }

    @Override
    public void setLength(double length) {
        super.setWidth(length);
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "Hinh vuong [side=" + getWidth() + ", color=" + getColor() + ", filled=" + isFilled() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        Square square = (Square) obj;
        return Double.compare(square.getWidth(), getWidth()) == 0;
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static Circle nhapHinhTron() {
        System.out.println("Nhap thong tin hinh tron:");
        System.out.print("Ban kinh: ");
        double radius = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Mau sac: ");
        String color = scanner.nextLine();
        System.out.print("To mau (true/false): ");
        boolean filled = scanner.nextBoolean();
        scanner.nextLine(); 
        return new Circle(radius, color, filled);
    }

    public static Rectangle nhapHinhChuNhat() {
        System.out.println("Nhap thong tin hinh chu nhat:");
        System.out.print("Chieu rong: ");
        double width = scanner.nextDouble();
        System.out.print("Chieu dai: ");
        double length = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Mau sac: ");
        String color = scanner.nextLine();
        System.out.print("To mau (true/false): ");
        boolean filled = scanner.nextBoolean();
        scanner.nextLine(); 
        return new Rectangle(width, length, color, filled);
    }

    public static Square nhapHinhVuong() {
        System.out.println("Nhap thong tin hinh vuong:");
        System.out.print("Canh: ");
        double side = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Mau sac: ");
        String color = scanner.nextLine();
        System.out.print("To mau (true/false): ");
        boolean filled = scanner.nextBoolean();
        scanner.nextLine();
        return new Square(side, color, filled);
    }

    public static void main(String[] args) {
        Circle circle = nhapHinhTron();
        Rectangle rectangle = nhapHinhChuNhat();
        Square square = nhapHinhVuong();
        Rectangle anotherRectangle = nhapHinhChuNhat(); 
        System.out.println("\nThong tin hinh tron:");
        System.out.println(circle);
        System.out.println("Dien tich: " + circle.getArea());
        System.out.println("Chu vi: " + circle.getPerimeter());
        System.out.println("\nThong tin hinh chu nhat:");
        System.out.println(rectangle);
        System.out.println("Dien tich: " + rectangle.getArea());
        System.out.println("Chu vi: " + rectangle.getPerimeter());
        System.out.println("\nThong tin hinh vuong:");
        System.out.println(square);
        System.out.println("Dien tich: " + square.getArea());
        System.out.println("Chu vi: " + square.getPerimeter());
        System.out.println("\nKiem tra equals:");
        System.out.println("Circle va Rectangle co bang nhau khong? " + circle.equals(rectangle));
        System.out.println("Rectangle va Square co bang nhau khong? " + rectangle.equals(square));
        System.out.println("Square va anotherRectangle co bang nhau khong? " + square.equals(anotherRectangle));
    }
}