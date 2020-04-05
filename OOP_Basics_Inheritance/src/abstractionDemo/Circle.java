package abstractionDemo;

public class Circle extends Shape {
    private double radius;

    public Circle(double r) {
        this.radius = r;
    }

    @Override
    public void calcPerimeter() {
        setPerimeter(2 * Math.PI * radius);
    }

    @Override
    public void calcArea() {
        setArea(Math.PI * (radius * radius));
    }
}
