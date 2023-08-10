package exercise;

// BEGIN
public class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
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
        double finalArea = area + balconyArea;
        return finalArea;
    }

    public String toString() {
        String result = "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
        return result;
    }
}

// END
