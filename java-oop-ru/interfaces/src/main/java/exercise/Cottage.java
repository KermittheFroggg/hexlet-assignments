package exercise;

// BEGIN
public class Cottage implements Home {
    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public int compareTo(Home anotherHome) {
        if (getArea() > anotherHome.getArea()) {
            return 1;
        } else if (getArea() < anotherHome.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    public double getArea() {
        double finalArea = area;
        return finalArea;
    }

    public String toString() {
        String result =  floorCount + " этажный коттедж площадью " + getArea() + " метров";
        return result;
    }
}
// END
