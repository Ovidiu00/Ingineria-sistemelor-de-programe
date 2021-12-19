package isp.lab3.exercise2;

import isp.lab3.exercise1.Exercise1;

public class Exercise2 {


    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(10,5);

        System.out.println("Length : " + rectangle.getLength() + "\n");
        System.out.println("Width : " + rectangle.getWidth() + "\n");
        System.out.println("Color : " + rectangle.getColor() + "\n");

        System.out.println("Perimeter : " + rectangle.getPerimeter() + "\n");
        System.out.println("Area : " + rectangle.getArea() + "\n");


    }

}
