package natasha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector3Test {
    private static final double EPSILON = 0.000001;

    @Test
    void magnitudeOfZeroIsZero() {
        Vector3 zero = Vector3.fromXYZ(0,0,0);
        double magnitude = zero.magnitude();

        assertAreClose(magnitude, 0);
    }

    @Test
    void magnitudeOfUnitXIsOne() {
        Vector3 vec = Vector3.fromXYZ(1,0,0);
        double magnitude = vec.magnitude();

        assertAreClose(magnitude, 1);
    }

    @Test
    void magnitudeOfXYIsCorrect() {
        Vector3 vec = Vector3.fromXYZ(3,4,0);
        double magnitude = vec.magnitude();

        assertAreClose(magnitude, 5);
    }

    @Test
    void magnitudeOfNegativeOneIsCorrect() {
        Vector3 vec = Vector3.fromXYZ(-1,0,0);
        double magnitude = vec.magnitude();

        assertAreClose(magnitude, 1);
    }

    @Test
    void magnitudeOfArbitraryIsCorrect() {
        Vector3 vec = Vector3.fromXYZ(-1,3,2);
        double magnitude = vec.magnitude();
        double expected = Math.sqrt(1 + 3*3 + 2*2);

        assertAreClose(magnitude, expected);
    }


    @Test
    void addZerosToZero() {
        Vector3 vec1 = Vector3.fromXYZ(0,0,0);
        Vector3 vec2 = Vector3.fromXYZ(0,0,0);

        Vector3 result = vec1.add(vec2);
        Vector3 expected = Vector3.fromXYZ(0,0,0);

        assertAreClose(result, expected);
    }

    @Test
    void addZeroToArbitrary() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        Vector3 vec2 = Vector3.fromXYZ(0,0,0);

        Vector3 result = vec1.add(vec2);
        Vector3 expected = Vector3.fromXYZ(1,3,2);

        assertAreClose(result, expected);
    }

    @Test
    void addArbitraryToXUnit() {
        Vector3 vec1 = Vector3.fromXYZ(1,0,0);
        Vector3 vec2 = Vector3.fromXYZ(1,3,2);

        Vector3 result = vec1.add(vec2);
        Vector3 expected = Vector3.fromXYZ(2,3,2);

        assertAreClose(result, expected);
    }

    @Test
    void addXUnitToArbitrary() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        Vector3 vec2 = Vector3.fromXYZ(1,0,0);

        Vector3 result = vec1.add(vec2);
        Vector3 expected = Vector3.fromXYZ(2,3,2);

        assertAreClose(result, expected);
    }

    @Test
    void addNegativeXUnitToArbitrary() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        Vector3 vec2 = Vector3.fromXYZ(-1,0,0);

        Vector3 result = vec1.add(vec2);
        Vector3 expected = Vector3.fromXYZ(0,3,2);

        assertAreClose(result, expected);
    }

    @Test
    void addArbitraryToArbitrary() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        Vector3 vec2 = Vector3.fromXYZ(3,0.5,-1);

        Vector3 result = vec1.add(vec2);
        Vector3 expected = Vector3.fromXYZ(4,3.5,1);

        assertAreClose(result, expected);
    }

    @Test
    void addDoesNotMutate() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        Vector3 vec2 = Vector3.fromXYZ(0,0,0);

        Vector3 vec1Clone = Vector3.fromXYZ(1,3,2);
        Vector3 vec2Clone = Vector3.fromXYZ(0,0,0);

        vec1.add(vec2);

        assertAreClose(vec1, vec1Clone);
        assertAreClose(vec2, vec2Clone);
    }


    @Test
    void subZerosFromZero() {
        Vector3 vec1 = Vector3.fromXYZ(0,0,0);
        Vector3 vec2 = Vector3.fromXYZ(0,0,0);

        Vector3 result = vec1.subtract(vec2);
        Vector3 expected = Vector3.fromXYZ(0,0,0);

        assertAreClose(result, expected);
    }

    @Test
    void subXUnitFromArbitrary() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        Vector3 vec2 = Vector3.fromXYZ(1,0,0);

        Vector3 result = vec1.subtract(vec2);
        Vector3 expected = Vector3.fromXYZ(0,3,2);

        assertAreClose(result, expected);
    }

    @Test
    void subNegativeXUnitFromArbitrary() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        Vector3 vec2 = Vector3.fromXYZ(-1,0,0);

        Vector3 result = vec1.subtract(vec2);
        Vector3 expected = Vector3.fromXYZ(2,3,2);

        assertAreClose(result, expected);
    }

    @Test
    void subArbitraryFromArbitrary() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        Vector3 vec2 = Vector3.fromXYZ(5,1,-0.5);

        Vector3 result = vec1.subtract(vec2);
        Vector3 expected = Vector3.fromXYZ(-4,2,2.5);

        assertAreClose(result, expected);
    }

    @Test
    void subDoesNotMutate() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        Vector3 vec2 = Vector3.fromXYZ(0,0,0);

        Vector3 vec1Clone = Vector3.fromXYZ(1,3,2);
        Vector3 vec2Clone = Vector3.fromXYZ(0,0,0);

        vec1.subtract(vec2);

        assertAreClose(vec1, vec1Clone);
        assertAreClose(vec2, vec2Clone);
    }


    @Test
    void scaleArbitraryByZero() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        double coefficient = 0;

        Vector3 result = vec1.scale(coefficient);
        Vector3 expected = Vector3.fromXYZ(0,0,0);

        assertAreClose(result, expected);
    }

    @Test
    void scaleArbitraryByOne() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        double coefficient = 1;

        Vector3 result = vec1.scale(coefficient);
        Vector3 expected = Vector3.fromXYZ(1,3,2);

        assertAreClose(result, expected);
    }

    @Test
    void scaleArbitraryByTwo() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        double coefficient = 2;

        Vector3 result = vec1.scale(coefficient);
        Vector3 expected = Vector3.fromXYZ(2,6,4);

        assertAreClose(result, expected);
    }

    @Test
    void scaleArbitraryByNegativeOne() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        double coefficient = -1;

        Vector3 result = vec1.scale(coefficient);
        Vector3 expected = Vector3.fromXYZ(-1,-3,-2);

        assertAreClose(result, expected);
    }

    @Test
    void scaleZeroByTwo() {
        Vector3 vec1 = Vector3.fromXYZ(0,0,0);
        double coefficient = 2;

        Vector3 result = vec1.scale(coefficient);
        Vector3 expected = Vector3.fromXYZ(0,0,0);

        assertAreClose(result, expected);
    }

    @Test
    void scaleZeroByZero() {
        Vector3 vec1 = Vector3.fromXYZ(0,0,0);
        double coefficient = 0;

        Vector3 result = vec1.scale(coefficient);
        Vector3 expected = Vector3.fromXYZ(0,0,0);

        assertAreClose(result, expected);
    }

    @Test
    void scaleDoesNotMutate() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,2);
        Vector3 vec1Clone = Vector3.fromXYZ(1,3,2);
        double coefficient = 2;

        vec1.scale(coefficient);

        assertAreClose(vec1, vec1Clone);
    }


    @Test
    void dotZeroWithZeroIsZero() {
        Vector3 vec1 = Vector3.fromXYZ(0,0,0);
        Vector3 vec2 = Vector3.fromXYZ(0,0,0);

        double result = vec1.dot(vec2);
        double expected = 0;

        assertAreClose(result, expected);
    }

    @Test
    void dotArbitraryWithZeroIsZero() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,5);
        Vector3 vec2 = Vector3.fromXYZ(0,0,0);

        double result = vec1.dot(vec2);
        double expected = 0;

        assertAreClose(result, expected);
    }

    @Test
    void dotZeroWithUnitXIsProjection() {
        Vector3 vec1 = Vector3.fromXYZ(3,2,5);
        Vector3 vec2 = Vector3.fromXYZ(1,0,0);

        double result = vec1.dot(vec2);
        double expected = 3;

        assertAreClose(result, expected);
    }

    @Test
    void dotArbitraryWithArbitrary() {
        Vector3 vec1 = Vector3.fromXYZ(3,2,5);
        Vector3 vec2 = Vector3.fromXYZ(1,3,-2);

        double result = vec1.dot(vec2);
        double expected = 3*1 + 2*3 +5*(-2);

        assertAreClose(result, expected);
    }


    @Test
    void crossZeroWithZeroIsZero() {
        Vector3 vec1 = Vector3.fromXYZ(0,0,0);
        Vector3 vec2 = Vector3.fromXYZ(0,0,0);

        Vector3 result = vec1.cross(vec2);
        Vector3 expected = Vector3.fromXYZ(0,0,0);

        assertAreClose(result, expected);
    }

    @Test
    void crossArbitraryWithZero() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,5);
        Vector3 vec2 = Vector3.fromXYZ(0,0,0);

        Vector3 result = vec1.cross(vec2);
        Vector3 expected = Vector3.fromXYZ(0,0,0);

        assertAreClose(result, expected);
    }

    @Test
    void crossXUnitWithYUnit() {
        Vector3 vec1 = Vector3.fromXYZ(1,0,0);
        Vector3 vec2 = Vector3.fromXYZ(0,1,0);

        Vector3 result = vec1.cross(vec2);
        Vector3 expected = Vector3.fromXYZ(0,0,1);

        assertAreClose(result, expected);
    }

    @Test
    void crossYUnitWithXUnit() {
        Vector3 vec1 = Vector3.fromXYZ(0,1,0);
        Vector3 vec2 = Vector3.fromXYZ(1,0,0);

        Vector3 result = vec1.cross(vec2);
        Vector3 expected = Vector3.fromXYZ(0,0,-1);

        assertAreClose(result, expected);
    }

    @Test
    void crossArbitraryWithXUnit() {
        Vector3 vec1 = Vector3.fromXYZ(3,2,5);
        Vector3 vec2 = Vector3.fromXYZ(1,0,0);

        Vector3 result = vec1.cross(vec2);
        Vector3 expected = Vector3.fromXYZ(0,5,-2);

        assertAreClose(result, expected);
    }

    @Test
    void crossArbitraryWithArbitrary() {
        Vector3 vec1 = Vector3.fromXYZ(3,2,5);
        Vector3 vec2 = Vector3.fromXYZ(1,4,-2);

        Vector3 result = vec1.cross(vec2);
        Vector3 expected = Vector3.fromXYZ(24,11,10);

        assertAreClose(result, expected);
    }

    @Test
    void crossDoesNotMutate() {
        Vector3 vec1 = Vector3.fromXYZ(3,2,5);
        Vector3 vec2 = Vector3.fromXYZ(1,4,-2);

        vec1.cross(vec2);
        Vector3 vec1Clone = Vector3.fromXYZ(3,2,5);

        assertAreClose(vec1, vec1Clone);
    }

    @Test
    void powerZeroToTree() {
        Vector3 vec1 = Vector3.fromXYZ(0,0,0);
        double exponent = 3;

        Vector3 result = vec1.power(exponent);
        Vector3 expected = Vector3.fromXYZ(0,0,0);

        assertAreClose(result, expected);
    }

    @Test
    void powerArbitraryToZero() {
        Vector3 vec1 = Vector3.fromXYZ(1,-3,5);
        double exponent = 0;

        Vector3 result = vec1.power(exponent);
        Vector3 expected = Vector3.fromXYZ(1,1,1);

        assertAreClose(result, expected);
    }

    @Test
    void powerArbitraryToTwo() {
        Vector3 vec1 = Vector3.fromXYZ(1,-3,5);
        double exponent = 2;

        Vector3 result = vec1.power(exponent);
        Vector3 expected = Vector3.fromXYZ(1,9,25);

        assertAreClose(result, expected);
    }

    @Test
    void powerArbitraryToArbitrary() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,5);
        double exponent = 3.6;

        Vector3 result = vec1.power(exponent);
        Vector3 expected = Vector3.fromXYZ(
                Math.pow(1, exponent),
                Math.pow(3, exponent),
                Math.pow(5, exponent));

        assertAreClose(result, expected);
    }

    @Test
    void powerDoesNotMutate() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,5);
        double exponent = 3.6;

        vec1.power(exponent);
        Vector3 vec1Clone = Vector3.fromXYZ(1,3,5);

        assertAreClose(vec1, vec1Clone);
    }


    @Test
    void invXUnit() {
        Vector3 vec1 = Vector3.fromXYZ(1,0,0);

        Vector3 result = vec1.inv();
        Vector3 expected = Vector3.fromXYZ(1, 0, 0);

        assertAreClose(result, expected);
    }

    @Test
    void invArbitrary() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,-2);

        Vector3 result = vec1.inv();
        Vector3 expected = Vector3.fromXYZ(1, 1.0/3, 1.0/-2);

        assertAreClose(result, expected);
    }

    @Test
    void invDoesNotMutate() {
        Vector3 vec1 = Vector3.fromXYZ(1,3,-2);

        vec1.inv();
        Vector3 vec1Clone = Vector3.fromXYZ(1,3,-2);

        assertAreClose(vec1, vec1Clone);
    }


    @Test
    void normalisedXUnit() {
        Vector3 vec1 = Vector3.fromXYZ(1,0,0);

        Vector3 result = vec1.normalised();
        Vector3 expected = Vector3.fromXYZ(1,0,0);

        assertAreClose(result, expected);
    }

    @Test
    void normalisedXYUniform() {
        Vector3 vec1 = Vector3.fromXYZ(1,1,0);

        Vector3 result = vec1.normalised();
        Vector3 expected = Vector3.fromXYZ(Math.sqrt(2),Math.sqrt(2),0);

        assertAreClose(result, expected);
    }

    @Test
    void normalisedXNegYUniform() {
        Vector3 vec1 = Vector3.fromXYZ(1,-1,0);

        Vector3 result = vec1.normalised();
        Vector3 expected = Vector3.fromXYZ(Math.sqrt(2), -Math.sqrt(2),0);

        assertAreClose(result, expected);
    }

    @Test
    void normalisedUniform() {
        Vector3 vec1 = Vector3.fromXYZ(1,1,1);

        Vector3 result = vec1.normalised();
        Vector3 expected = Vector3.fromXYZ(Math.sqrt(3) , Math.sqrt(3),Math.sqrt(3));

        assertAreClose(result, expected);
    }

    @Test
    void normalisedDoesNotMutate() {
        Vector3 vec1 = Vector3.fromXYZ(1,1,1);

        vec1.normalised();
        Vector3 vec1Clone = Vector3.fromXYZ(1,1,1);

        assertAreClose(vec1, vec1Clone);
    }


    @Test
    void reflectNegXAgainstX() {
        Vector3 ray = Vector3.fromXYZ(-1,0,0);
        Vector3 normal = Vector3.fromXYZ(1, 0, 0);

        Vector3 result = ray.reflectIn(normal);
        Vector3 expected = Vector3.fromXYZ(1,0,0);

        assertAreClose(result, expected);
    }

    @Test
    void reflectNegYAgainstX() {
        Vector3 ray = Vector3.fromXYZ(0,1,0);
        Vector3 normal = Vector3.fromXYZ(1, 0, 0);

        Vector3 result = ray.reflectIn(normal);
        Vector3 expected = Vector3.fromXYZ(0,1,0);

        assertAreClose(result, expected);
    }

    @Test
    void reflectDiagonalAgainstX() {
        Vector3 ray = Vector3.fromXYZ(-Math.sqrt(2), Math.sqrt(2),0);
        Vector3 normal = Vector3.fromXYZ(1, 0, 0);

        Vector3 result = ray.reflectIn(normal);
        Vector3 expected = Vector3.fromXYZ(Math.sqrt(2), Math.sqrt(2),0);

        assertAreClose(result, expected);
    }

    @Test
    void reflectDoesNotMutate() {
        Vector3 ray = Vector3.fromXYZ(-Math.sqrt(2), Math.sqrt(2),0);
        Vector3 normal = Vector3.fromXYZ(1, 0, 0);

        ray.reflectIn(normal);
        Vector3 rayClone = Vector3.fromXYZ(-Math.sqrt(2), Math.sqrt(2),0);

        assertAreClose(ray, rayClone);
    }

    private void assertAreClose(double x, double y) {
        assertTrue( Math.abs(x - y) < EPSILON);
    }

    private void assertAreClose(Vector3 x, Vector3 y) {
        Vector3 difference = x.subtract(y);
        double error = difference.magnitude();

        assertTrue(error < EPSILON);
    }
}