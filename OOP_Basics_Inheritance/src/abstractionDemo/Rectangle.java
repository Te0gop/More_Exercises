package abstractionDemo;

public class Rectangle extends Shape{
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public void calcPerimeter() {
        setPerimeter(sideA*2 + sideB*2);
    }

    @Override
    public void calcArea() {
        setArea(sideA * sideB);
    }
}
