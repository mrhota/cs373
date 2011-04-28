// ------------
// Visitor.java
// ------------

// http://en.wikipedia.org/wiki/Visitor_pattern

abstract class List<T> {
    abstract int accept (Visitor<T> v);

    int length () {
        return accept(new LengthVisitor<T>());}}

class Nil<T> extends List<T> {
    public int accept (Visitor<T> v) {
        return v.visit(this);}}

class Cons<T> extends List<T> {
    public final T       _first;
    public final List<T> _rest;

    public Cons (T first, List<T> rest) {
        _first = first;
        _rest  = rest;}

    public int accept (Visitor<T> v) {
        return v.visit(this);}}

interface Visitor<T> {
    int visit (Nil<T>  n);
    int visit (Cons<T> c);}

class LengthVisitor<T> implements Visitor<T> {
    public int visit (Nil<T> n) {
        return 0;}

    public int visit (Cons<T> c) {
        return 1 + c._rest.length();}}

final class Visitor {
    public static void main (String[] args) {
        System.out.println("Visitor.java");

        final List<Integer> x    = new Nil<Integer>();
        final List<Integer> x4   = new Cons<Integer>(4, x);
        final List<Integer> x34  = new Cons<Integer>(3, x4);
        final List<Integer> x234 = new Cons<Integer>(2, x34);

        assert x.length()    == 0;
        assert x4.length()   == 1;
        assert x34.length()  == 2;
        assert x234.length() == 3;

        System.out.println("Done.");}}
