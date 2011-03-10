// --------------
// Factorial.java
// --------------

import java.util.Iterator;
import java.util.NoSuchElementException;

interface UnaryFunction {
    int call (int x);}

interface BinaryFunction {
    int call (int x, int y);}

final class Multiplies implements BinaryFunction {
    public int call (int x, int y) {
        return x * y;}}

class Iota {
    private int _b;
    private int _e;

    public Iota (int b, int e) {
        _b = b;
        _e = e;}

    public boolean hasNext () {
        return _b != _e;}

    public int next () {
        if (!hasNext())
            throw new NoSuchElementException();
        int v = _b;
        ++_b;
        return v;}}

final class Factorial1 implements UnaryFunction {
    public int call (int n) {
        if (n < 2)
            return 1;
        return n * call(n - 1);}}

final class Factorial2 implements UnaryFunction {
    public int call (int n) {
        int x = 1;
        while (n > 1) {
            x *= n;
            --n;}
        return x;}}

final class Factorial3 implements UnaryFunction {
    public static int reduce (BinaryFunction bf, Iota p, int v) {
        while (p.hasNext())
            v = bf.call(v, p.next());
        return v;}

    public int call (int n) {
        return reduce(new Multiplies(), new Iota(1, n + 1), 1);}}

final class Factorial {
    private static void test (UnaryFunction f) {
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
        test(new Factorial3());

        System.out.println("Done.");}}
