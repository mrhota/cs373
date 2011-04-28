// --------------
// Composite.java
// --------------

// http://en.wikipedia.org/wiki/Composite_pattern

interface List<T> {
    int length ();}

class Nil<T> implements List<T> {
    public int length () {
        return 0;}}

class Cons<T> implements List<T> {
    public final T    _first;
    public final List _rest;

    public Cons (T first, List rest) {
        _first = first;
        _rest  = rest;}

    public int length () {
        return 1 + _rest.length();}}

final class Composite {
    public static void main (String[] args) {
        System.out.println("Composite.java");

        final List<Integer> x    = new Nil<Integer>();
        final List<Integer> x4   = new Cons<Integer>(4, x);
        final List<Integer> x34  = new Cons<Integer>(3, x4);
        final List<Integer> x234 = new Cons<Integer>(2, x34);

        assert    x.length() == 0;
        assert   x4.length() == 1;
        assert  x34.length() == 2;
        assert x234.length() == 3;

        System.out.println("Done.");}}
