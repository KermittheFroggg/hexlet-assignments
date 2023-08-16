package exercise;

// BEGIN
public class Circle {
    private Point point;

    private int r;
    double square;


    Circle(Point point, int r) {
        this.point = point;
        this.r = r;
    }

    public int getRadius() {
        return r;
    }

    public double getSquare() throws NegativeRadiusException {
        if (r < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        this.square = Math.PI * r * r;
        return square;
    }
}
// END
