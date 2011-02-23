// --------
// Map.java
// --------

import java.util.Arrays;

interface UnaryFunction<T> {
    T call (T x);}

final class Sqre implements UnaryFunction<Integer> {
    public Integer call (Integer x) {
        return x * x;}}

final class Cube implements UnaryFunction<Integer> {
    public Integer call (Integer x) {
        return x * x * x;}}

final class Map {
    public static <T> T[] map (UnaryFunction<T> uf, T[] a) {
        final T[] x = (T[]) new Object[a.length];            // warning: [unchecked] unchecked cast
        for (int i = 0; i != a.length; ++i)
            x[i] = uf.call(a[i]);
        return x;}

    public static void main (String[] args) {
        System.out.println("Map.java");

        final Integer a[] = {2,  3,  4};
        final Integer b[] = {4,  9, 16};
        final Integer c[] = {8, 27, 64};

        assert Arrays.equals(map(new Sqre(), a), b);
        assert Arrays.equals(map(new Cube(), a), c);

        System.out.println("Done.");}}
