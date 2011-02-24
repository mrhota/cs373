// -----------
// Reduce.java
// -----------

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

interface BinaryFunction<T> {
    T call (T x, T y);}

final class Plus implements BinaryFunction<Integer> {
    public Integer call (Integer x, Integer y) {
        return x + y;}}

final class Multiply implements BinaryFunction<Integer> {
    public Integer call (Integer x, Integer y) {
        return x * y;}}

final class Reduce {
    public static int reduce1 (BinaryFunction<Integer> bf, int[] a, int v) {
        for (int i = 0; i != a.length; ++i)
            v = bf.call(v, a[i]);
        return v;}

    public static <T> T reduce1 (BinaryFunction<T> bf, T[] a, T v) {
        for (int i = 0; i != a.length; ++i)
            v = bf.call(v, a[i]);
        return v;}

    public static <T> T reduce1 (BinaryFunction<T> bf, List<T> x, T v) {
        for (int i = 0; i != x.size(); ++i)
            v = bf.call(v, x.get(i));
        return v;}

    public static <T> T reduce2 (BinaryFunction<T> bf, List<T> x, T v) {
        final Iterator<T> p = x.iterator();
        while (p.hasNext())
            v = bf.call(v, p.next());
        return v;}

    public static int reduce3 (BinaryFunction<Integer> bf, int[] a, int v) {
        for (int w : a)
            v = bf.call(v, w);
        return v;}

    public static <T> T reduce3 (BinaryFunction<T> bf, T[] a, T v) {
        for (T w : a)
            v = bf.call(v, w);
        return v;}

    public static <T> T reduce3 (BinaryFunction<T> bf, List<T> x, T v) {
        for (T w : x)
            v = bf.call(v, w);
        return v;}

    public static void main (String[] args) {
        System.out.println("Reduce.java");

        {
        final int a[] = {2, 3, 4};
        assert reduce1(new Plus(),     a, 0) ==  9;
        assert reduce1(new Multiply(), a, 1) == 24;
        assert reduce3(new Plus(),     a, 0) ==  9;
        assert reduce3(new Multiply(), a, 1) == 24;
        }

        {
        final Integer a[] = {2, 3, 4};
        assert reduce1(new Plus(),     a, 0) ==  9;
        assert reduce1(new Multiply(), a, 1) == 24;
        assert reduce3(new Plus(),     a, 0) ==  9;
        assert reduce3(new Multiply(), a, 1) == 24;
        }

        {
        final List<Integer> a = new LinkedList<Integer>(Arrays.asList(2, 3, 4));
        assert reduce1(new Plus(),     a, 0) ==  9;
        assert reduce1(new Multiply(), a, 1) == 24;
        assert reduce2(new Plus(),     a, 0) ==  9;
        assert reduce2(new Multiply(), a, 1) == 24;
        assert reduce3(new Plus(),     a, 0) ==  9;
        assert reduce3(new Multiply(), a, 1) == 24;
        }

        System.out.println("Done.");}}
