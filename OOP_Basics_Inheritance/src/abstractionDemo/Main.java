package abstractionDemo;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(5, 10);

        circle.calcArea();
        rectangle.calcArea();
        System.out.println(circle.getArea());
        System.out.println(rectangle.getArea());


    }

}
