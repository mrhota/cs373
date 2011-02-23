// --------
// Map.java
// --------

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

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

    public static <T> List<T> map (UnaryFunction<T> uf, List<T> a) {
        final List<T> x = new ArrayList<T>(a.size());
        for (int i = 0; i != a.size(); ++i)
            x.set(i, uf.call(a.get(i)));
        return x;}

    public static void main (String[] args) {
        System.out.println("Map.java");

        final Integer a[] = {2,  3,  4};
        final Integer b[] = {4,  9, 16};
        final Integer c[] = {8, 27, 64};

        assert Arrays.equals(map(new Sqre(), a), b);
        assert Arrays.equals(map(new Cube(), a), c);

        System.out.println("Done.");}}
