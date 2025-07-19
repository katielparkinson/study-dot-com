public class Rectangle {
    double width;
    double length;

    // constuctor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // method to calculate area of a rectangle
    public double rectangleArea() {
        double rectangleArea = (length * width);
        return rectangleArea;
    }
}
