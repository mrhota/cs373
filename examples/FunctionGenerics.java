// ---------------------
// FunctionGenerics.java
// ---------------------

// parametric run-time polymorphism

/*
package java.lang;

interface Comparable<T> {
    int compareTo (T that);}
*/

class A implements Comparable<A> {
    private int _n;

    public A (int n) {
        _n = n;}

    public int compareTo (A that) {
        return _n - that._n;}}

class B extends A {
    public B (int n) {
        super(n);}}

final class FunctionGenerics {
    private static <T extends Comparable<T>> T max1 (T x, T y) {
        if (x.compareTo(y) < 0)
            return y;
        return x;}

    private static <T extends Comparable<? super T>> T max2 (T x, T y) {
        if (x.compareTo(y) < 0)
            return y;
        return x;}

    public static void main (String[] args) {
        System.out.println("FunctionGenerics.java");

        assert Integer.class.getInterfaces()[0] == Comparable.class;
        assert  String.class.getInterfaces()[1] == Comparable.class;
        assert       A.class.getInterfaces()[0] == Comparable.class;
        assert       B.class.getSuperclass()    ==          A.class;

        assert max1(2, 3) == 3;
        assert max2(2, 3) == 3;

        assert max1("abc", "def") == "def";
        assert max2("abc", "def") == "def";

        {
        A x = new A(2);
        A y = new A(3);
        assert max1(x, y) == y;
        assert max2(x, y) == y;
        }

        {
        B x = new B(2);
        B y = new B(3);
//      assert max1(x, y) == y; // <T>max1(T,T) in FunctionGenericsTest cannot be applied to (B,B)
        assert max2(x, y) == y;
        }

        {
        A x = new B(2);
        A y = new B(3);
        assert max1(x, y) == y;
        assert max2(x, y) == y;
        }

        System.out.println("Done.");}}
