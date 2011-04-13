// -------------------
// DynamicBinding.java
// -------------------

class Shape {
    private int x;
    private int y;

    public Shape (int x, int y) {
        this.x = x;
        this.y = y;}

    public double area () {
        return area2();}

    private double area2 () {
        return 0;}

    public final void move (int x, int y) {
        this.x = x;
        this.y = y;}

    public String toString () {
        return x + ", " + y;}}

final class Circle extends Shape {
    private int r;

    public Circle (int x, int y, int r) {
        super(x, y);
        this.r = r;}

    public double area2 () {
        return 3.14 * r * r;}

    public int radius () {
        return r;}

    public String toString () {
        return "(" + super.toString() + ", " + r + ")";}}

final class DynamicBinding {
    public static void main (String[] args) {
        System.out.println("DynamicBinding.java");

        {
        final Shape x = new Shape(2, 3);
        assert x.area()   == 0;
        x.move(5, 6);
//      assert x.radius() == 0;
        }

        {
        final Circle x = new Circle(2, 3, 4);
        assert x.area()   == 0;
        x.move(5, 6);
        assert x.radius() == 4;
        }

        {
        final Shape x = new Circle(2, 3, 4);
        assert x.area()   == 0;
        x.move(5, 6);
//      assert x.radius() == 0;
        assert ((Circle) x).radius() == 4;
        }

        {
//      final Circle[] a = {new Shape(2, 3), new Circle(2, 3, 4)};
        final Shape[]  a = {new Shape(2, 3), new Circle(2, 3, 4)};
        assert a[0].area() == 0;
        assert a[1].area() == 0;
        }

        {
        final Shape[]          a = new Circle[3];
//      final ArrayList<Shape> x = new ArrayList<Circle>(10);
        final ArrayList<?>     x = new ArrayList<Circle>(10);
        }

        System.out.println("Done.");}}
