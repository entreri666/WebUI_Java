package HomeWork4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static HomeWork4.TriangleSquare.TriangleSquare;

public class TriangleTest {

    @Test
    void positiveSquareCalcTest() throws Exception {
        double result = TriangleSquare(3,3,3);
        Assertions.assertEquals(2, result);
    }

    @Test
    void negativeSquareCalcTest() {
       Assertions.assertThrows(Exception.class, () -> TriangleSquare(-3,3,3));
    }
}
