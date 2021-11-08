package HomeWork4;

public class TriangleSquare {
    public static double TriangleSquare(int a, int b, int c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0) throw new Exception("Сторона не может быть отрицательной");
            double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
}
