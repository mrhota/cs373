// --------------------
// AbstractClasses.java
// --------------------

import java.util.ArrayList;

abstract class AbstractShape {
    private int _x;
    private int _y;

    protected AbstractShape (int x, int y) {
        _x = x;
        _y = y;}

    public abstract double area ();

    public final void move (int x, int y) {
        _x = x;
        _y = y;}

    public abstract String toString ();

    protected String toString2 () {
        return _x + ", " + _y;}}

final class Circle extends AbstractShape {
    private int _r;

    public Circle (int x, int y, int r) {
        super(x, y);
        _r = r;}

    public double area () {
        return 3.14 * _r * _r;}

    public int radius () {
        return _r;}

    public String toString () {
        return "(" + super.toString2() + ", " + _r + ")";}}

final class AbstractClasses {
    public static void main (String[] args) {
        System.out.println("AbstractClasses.java");
/*
        {
        final AbstractShape x = new AbstractShape(2, 3);
        assert x.area()   == 0;
        x.move(5, 6);
//      assert x.radius() == 0;
        }
*/
        {
        final Circle x = new Circle(2, 3, 4);
        assert x.area()   == 3.14 * 4 * 4;
        x.move(5, 6);
        assert x.radius() == 4;
        }

        {
        final AbstractShape x = new Circle(2, 3, 4);
        assert x.area()   == 3.14 * 4 * 4;
        x.move(5, 6);
//      assert x.radius() == 0;
        assert ((Circle) x).radius() == 4;
        }

        {
        final AbstractShape[] a = {new Circle(2, 3, 4), new Circle(5, 6, 7)};
        assert a[0].area() == 3.14 * 4 * 4;
        assert a[1].area() == 3.14 * 7 * 7;
        }

        {
        final AbstractShape[]          a = new Circle[3];
//      final ArrayList<AbstractShape> x = new ArrayList<Circle>(10);
        }

        System.out.println("Done.");}}
