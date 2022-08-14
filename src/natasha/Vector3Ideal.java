package natasha;

public class Vector3Ideal {
    private final double x, y, z;

    private Vector3Ideal(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3Ideal fromXYZ(double x, double y, double z) {
        return null;
    }

    // Return a new vector that is the sum of 'this' and 'other'
    // Do not mutate either
    public Vector3Ideal add(Vector3Ideal other) {
        return new Vector3Ideal(x + other.x, y + other.y, z + other.z);
    }

    // Subtract two vectors (in the same manner)
    public Vector3Ideal subtract(Vector3Ideal other) {
        return new Vector3Ideal(x - other.x, y - other.y, z - other.z);
    }

    // Scale a vector by a scalar
    public Vector3Ideal scale(double scalar) {
        return new Vector3Ideal(scalar * x, scalar * y, scalar * z);
    }

    // Hadamard product, scales the vector in an element-wise fashion
    public Vector3Ideal scale(Vector3Ideal other) {
        return new Vector3Ideal(x * other.x, y * other.y, z * other.z);
    }

    // Dot product of two vectors
    public double dot(Vector3Ideal other) {
        return x * other.x + y * other.y + z * other.z;
    }

    // Cross product of two vectors
    public Vector3Ideal cross(Vector3Ideal other) {
        return new Vector3Ideal(y * other.z - z * other.y, z * other.x - x * other.z, x * other.y - y * other.x);
    }

    // Element-wise power function
    public Vector3Ideal power(double e) {
        return new Vector3Ideal( Math.pow(x,e), Math.pow(y,e), Math.pow(z,e) );
    }

    // Element-wise inverse (1/v)
    public Vector3Ideal inv() {
        return new Vector3Ideal( 1/x, 1/y, 1/z );
    }


    // Magnitude of a vector
    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Normalise a vector
    public Vector3Ideal normalised() {
        double magnitude = this.magnitude();
        return new Vector3Ideal(x / magnitude, y / magnitude, z / magnitude);
    }

    // Calculate mirror-like reflection
    public Vector3Ideal reflectIn(Vector3Ideal N) {
        return N.scale(2 * this.dot(N)).subtract(this);
    }

    // Creates a random vector inside the unit sphere
    public static Vector3Ideal randomInsideUnitSphere() {

        double r = Math.random();
        double theta = Math.random() * Math.PI;
        double phi = Math.random() * Math.PI * 2;

        double x = r * Math.sin(theta) * Math.cos(phi);
        double y = r * Math.sin(theta) * Math.sin(phi);
        double z = r * Math.cos(theta);

        return new Vector3Ideal(x, y, z);
    }

    // Determine if two vectors are equal
    public boolean equals(Vector3Ideal other) {
        return x == other.x && y == other.y && z == other.z;
    }
}

