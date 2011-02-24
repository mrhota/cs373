// --------
// Map.java
// --------

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

interface UnaryFunction<T> {
    T call (T x);}

final class Square implements UnaryFunction<Integer> {
    public Integer call (Integer x) {
        return x * x;}}

final class Cube implements UnaryFunction<Integer> {
    public Integer call (Integer x) {
        return x * x * x;}}

final class Map {
    public static int[] map (UnaryFunction<Integer> uf, int[] a) {
        final int[] x = new int[a.length];
        for (int i = 0; i != a.length; ++i)
            x[i] = uf.call(a[i]);
        return x;}

    public static <T> T[] map (UnaryFunction<T> uf, T[] a) {
        final T[] x = (T[]) new Object[a.length];            // warning: [unchecked] unchecked cast
        for (int i = 0; i != a.length; ++i)
            x[i] = uf.call(a[i]);
        return x;}

    public static <T> List<T> map (UnaryFunction<T> uf, List<T> a) {
        final List<T>         x = new ArrayList<T>(a.size());
        final ListIterator<T> p = a.listIterator();
        final ListIterator<T> q = x.listIterator();
        while (p.hasNext())
            q.add(uf.call(p.next()));
        return x;}

    public static void main (String[] args) {
        System.out.println("Map.java");

        {
        final int a[] = {2,  3,  4};
        final int b[] = {4,  9, 16};
        final int c[] = {8, 27, 64};
        assert Arrays.equals(map(new Square(), a), b);
        assert Arrays.equals(map(new Cube(),   a), c);
        }

        {
        final Integer a[] = {2,  3,  4};
        final Integer b[] = {4,  9, 16};
        final Integer c[] = {8, 27, 64};
        assert Arrays.equals(map(new Square(), a), b);
        assert Arrays.equals(map(new Cube(),   a), c);
        }

        {
        final List<Integer> a = Arrays.asList(2,  3,  4);
        final List<Integer> b = Arrays.asList(4,  9, 16);
        final List<Integer> c = Arrays.asList(8, 27, 64);
        assert map(new Square(), a).equals(b);
        assert map(new Cube(),   a).equals(c);
        }

        System.out.println("Done.");}}
