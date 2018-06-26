package lecture10;

import java.text.DecimalFormat;

/**
 * Created by jessehartloff on 6/26/15.
 */
public class Point {

    private double x;
    private double y;

    private static final double MIN_X = -1000000.0;
    private static final double MAX_X =  1000000.0;
    private static final double MIN_Y = -1000000.0;
    private static final double MAX_Y =  1000000.0;

    public Point(){
        makeRandom();
    }

    private void makeRandom(){
        x = (Math.random()*(MAX_X - MIN_X)) + MIN_X;
        y = (Math.random()*(MAX_Y - MIN_Y)) + MIN_Y;
    }

    public double distance(Point otherPoint){
        return Math.sqrt( Math.pow(otherPoint.getX() - this.getX(), 2)
                        + Math.pow(otherPoint.getY() - this.getY(), 2) );
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#");
        return "(" + df.format(x) +
                ", " + df.format(y) +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        return Double.compare(point.y, y) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
