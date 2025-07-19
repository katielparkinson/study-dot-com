public class Cylinder {
    double radius;
    double height;

    // constructor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // method to calculate volume of a cylinder
    public double cylinderVolume() {
        double cylinderVolume = (Math.PI * radius * radius * height);
        return cylinderVolume;
    }
}
