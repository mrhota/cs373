// --------------
// Factorial.java
// --------------

import java.util.Iterator;
import java.util.NoSuchElementException;

interface UnaryFunction<T> {
    T call (T x);}

interface BinaryFunction<T> {
    T call (T x, T y);}

final class Multiplies implements BinaryFunction<Integer> {
    public Integer call (Integer x, Integer y) {
        return x * y;}}

class Iota implements Iterator<Integer> {
    private int _b;
    private int _e;

    public Iota (Integer b, Integer e) {
        _b = b;
        _e = e;}

    public boolean hasNext () {
        return _b != _e;}

    public Integer next () {
        if (!hasNext())
            throw new NoSuchElementException();
        return _b++;}

    public void remove () {
        new UnsupportedOperationException();}}

final class Factorial1 implements UnaryFunction<Integer> {
    public Integer call (Integer n) {
        if (n < 2)
            return 1;
        return n * call(n - 1);}}

final class Factorial2 implements UnaryFunction<Integer> {
    public Integer call (Integer n) {
        Integer x = 1;
        while (n > 1) {
            x *= n;
            --n;}
        return x;}}

final class Factorial3 implements UnaryFunction<Integer> {
    public static Integer reduce (BinaryFunction<Integer> bf, Iterator<Integer> p, Integer v) {
        while (p.hasNext())
            v = bf.call(v, p.next());
        return v;}

    public Integer call (Integer n) {
        return reduce(new Multiplies(), new Iota(1, n + 1), 1);}}

final class Factorial {
    private static void test (UnaryFunction<Integer> f) {
        assert f.call(0) ==   1;
        assert f.call(1) ==   1;
        assert f.call(2) ==   2;
        assert f.call(3) ==   6;
        assert f.call(4) ==  24;
        assert f.call(5) == 120;}

    public static void main (String[] args) {
        System.out.println("Factorial.java");

        test(new Factorial1());
        test(new Factorial2());
//      test(new Factorial3());

        System.out.println("Done.");}}
