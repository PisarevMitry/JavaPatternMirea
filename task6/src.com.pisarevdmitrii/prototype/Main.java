package prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        Circle circle = new Circle();
        circle.setX(10);
        circle.setY(20);
        circle.setRadius(15);
        circle.setColor("red");
        shapes.add(circle);

        Circle anotherCircle = (Circle) circle.clone();
        anotherCircle.setColor("pink");
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(20);
        rectangle.setColor("blue");
        shapes.add(rectangle);

        Rectangle anotherRectangle = (Rectangle) rectangle.clone();
        anotherRectangle.setColor("purple");
        shapes.add(anotherRectangle);

        System.out.println(shapes);

    }


}
