package natasha;

import org.jetbrains.annotations.NotNull;

public class Vector3 {

    //TODO: Pass the tests.
    // More handhold-y instructions:
    // - get some `class` basics, like what are `members` and `objects`
    // - get the constructor working and then the `fromXYZ` method
    // - might be worth implementing `magnitude` and `subtract` first, since tests rely on those

    // Given x,y,z give me back YOUR representation of the vector
    // Note that you do not have to use Euclid-3D representation
    public static @NotNull Vector3 fromXYZ(double x, double y, double z) {
        return null;
    }

    // Return a new vector that is the sum of 'this' and 'other'
    // Do not mutate either
    public @NotNull Vector3 add(@NotNull Vector3 other) {
        return null;
    }

    // Subtract two vectors (in the same manner)
    public @NotNull Vector3 subtract(@NotNull Vector3 other) {
        return null;
    }

    // Return a vector that is this vector scaled by scalar
    // Do not mutate
    public @NotNull Vector3 scale(double scalar) {
        return null;
    }

    // Dot product of two vectors
    public double dot(@NotNull Vector3 other) {
        return 0f;
    }

    // Cross product of two vectors
    public @NotNull Vector3 cross(@NotNull Vector3 other) {
        return null;
    }

    // Element-wise power function (i.e (x,y,z)^e = (x^e,y^e,z^e) )
    public Vector3 power(double e) {
        return null;
    }

    // Element-wise inverse
    // I.e. x,y,z -> 1/x, 1/y, 1/z
    public Vector3 inv() {
        return null;
    }


    // Magnitude of a vector
    public double magnitude() {
        return 0;
    }

    // Return a normalised vector
    // I.e. same direction, but unit length
    // Not testing what you are doing on zero vector
    public Vector3 normalised() {
        return null;
    }

    // Calculate mirror-like reflection
    // I.e. given a normal to surface, calculate 'bounce'
    // Should retain magnitude
    public Vector3 reflectIn(Vector3 normal) {
        return null;
    }

    // Creates a random vector inside the unit sphere
    public static Vector3 randomInsideUnitSphere() {
        double r = Math.random();
        double theta = Math.random() * Math.PI;
        double phi = Math.random() * Math.PI * 2;

        double x = r * Math.sin(theta) * Math.cos(phi);
        double y = r * Math.sin(theta) * Math.sin(phi);
        double z = r * Math.cos(theta);

        return fromXYZ(x, y, z);
    }
}

