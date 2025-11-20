package COM.CW;
class Shape {
        int length;
        int width;
        int radius;

        public double areaOfRectangle() {
            return length * width;
        }

        public double areaOfCircle() {
            double pi = 3.14;  // or Math.PI
            return pi * radius * radius;
        }
    }

    public class VariablesDemo {
        public static void main(String[] args) {
            Shape rectangle = new Shape();
            rectangle.length = 15;
            rectangle.width = 45;
            System.out.println("Area of Rectangle: " + rectangle.areaOfRectangle());

            Shape circle = new Shape();
            circle.radius = 5;
            System.out.println("Area of Circle: " + circle.areaOfCircle());
        }
    }

