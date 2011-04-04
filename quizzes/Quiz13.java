/*
CS373: Quiz #13 (5 pts)
*/

/* -----------------------------------------------------------------------
1. What is the multiplicity of an association?
   [Associations]
   (1 pt)

how many instances of a class are connected to an instance of another
class
*/

/* -----------------------------------------------------------------------
2. What is the difference between a surrogate key and a substitute key?
   [Keys]
   (1 pt)

substitute keys have some descriptive value
*/

/* -----------------------------------------------------------------------
3. Does max1() or max2() fail to compile in the following?
   (2 pts)

max1() fails in the 2nd
max2() always compiles
*/

class A implements Comparable<A> {
    ...}

class B extends A {
    ...}

class Test {
    public static <T extends Comparable<T>> T max1 (T x, T y) {
        if (x.compareTo(y) < 0)
            return y;
        return x;}

    public static <T extends Comparable<? super T>> T max2 (T x, T y) {
        if (x.compareTo(y) < 0)
            return y;
        return x;}

    public static void main (String[] args) {
        A x = new A(...);
        A y = new A(...);
        assert max(x, y) == y;

        B x = new B(...);
        B y = new B(...);
        assert max(x, y) == y;

        A x = new B(...);
        A y = new B(...);
        assert max(x, y) == y;}}
