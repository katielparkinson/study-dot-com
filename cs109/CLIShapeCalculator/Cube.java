public class Cube {
    double length;

    // constructor
    public Cube(double length) {
        this.length = length;
    }

    // method to calculate volume of a cube
    public double cubeVolume() {
        double cubeVolume = Math.pow(length, 3);
        return cubeVolume;
    }
}
