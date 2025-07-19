public class Sphere {
    double radius;

    // constructor
    public Sphere(double radius) {
        this.radius = radius;
    }

    // method to calculate volume of a sphere
    public double sphereVolume() {
        double sphereVolume = ((4.0 / 3.0) * Math.PI * radius * radius * radius);
        return sphereVolume;
    }
}
