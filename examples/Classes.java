// ------------
// Classes.java
// ------------

class MyComplex {
    private int _r;
    private int _i;

    public MyComplex () {
        _r = 0;
        _i = 0;}

    public MyComplex (int real) {
        _r = real;
        _i = 0;}

    public MyComplex (int real, int imag) {
        _r = real;
        _i = imag;}

    public MyComplex conjugate () {
        _i = -_i;
        return this;}

    public boolean equals (Object rhs) {
        if (!(rhs instanceof MyComplex))
            return false;
        MyComplex that = (MyComplex) rhs;
        return (_r == that._r) && (_i == that._i);}

    public String toString () {
        return "(" + _r + ", " + _i + ")";}}

final class Classes {
    public static void main (String[] args) {
        System.out.println("Classes.java");

        final MyComplex x = new MyComplex();
        final MyComplex y = new MyComplex(2);

        final MyComplex z = new MyComplex(2, 3);
        assert z.equals(new MyComplex(2, 3));
        assert z.toString().equals("(2, 3)");

        final MyComplex t = z.conjugate();
        assert z.equals(new MyComplex(2, -3));
        assert t == z;

        System.out.println("Done.");}}
