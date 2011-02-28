// --------------
// MapReduce.java
// --------------

interface UnaryFunction<T> {
    T call (T x);}

final class Square implements UnaryFunction<Integer> {
    public Integer call (Integer x) {
        return x * x;}}

final class Cube implements UnaryFunction<Integer> {
    public Integer call (Integer x) {
        return x * x * x;}}

interface BinaryFunction<T> {
    T call (T x, T y);}

final class Plus implements BinaryFunction<Integer> {
    public Integer call (Integer x, Integer y) {
        return x + y;}}

final class Multiplies implements BinaryFunction<Integer> {
    public Integer call (Integer x, Integer y) {
        return x * y;}}

final class MapReduce {
    public static int[] map (UnaryFunction<Integer> uf, int[] a) {
        final int[] x = new int[a.length];
        for (int i = 0; i != a.length; ++i)
            x[i] = uf.call(a[i]);
        return x;}

    public static int reduce (BinaryFunction<Integer> bf, int[] a, int v) {
        for (int w : a)
            v = bf.call(v, w);
        return v;}

    public static int map_reduce_1 (BinaryFunction<Integer> bf, UnaryFunction<Integer> uf, int[] a, int v) {
        return reduce(bf, map(uf, a), v);}

    public static int map_reduce_2 (BinaryFunction<Integer> bf, UnaryFunction<Integer> uf, int[] a, int v) {
        for (int w : a)
            v = bf.call(v, uf.call(w));
        return v;}

    public static void main (String[] args) {
        System.out.println("MapReduce.java");
        System.out.println();

        {
        final int a[] = {2, 3, 4};

        assert map_reduce_1(new Plus(),       new Square(), a, 0) ==    29;
        assert map_reduce_1(new Plus(),       new Cube(),   a, 0) ==    99;
        assert map_reduce_1(new Multiplies(), new Square(), a, 1) ==   576;
        assert map_reduce_1(new Multiplies(), new Cube(),   a, 1) == 13824;

        assert map_reduce_2(new Plus(),       new Square(), a, 0) ==    29;
        assert map_reduce_2(new Plus(),       new Cube(),   a, 0) ==    99;
        assert map_reduce_2(new Multiplies(), new Square(), a, 1) ==   576;
        assert map_reduce_2(new Multiplies(), new Cube(),   a, 1) == 13824;
        }

        final int s   = 1000000;
        final int a[] = new int[s];
        for (int i = 0; i != s; ++i)
            a[i] = 1;

        {
        System.out.println("map_reduce_1");
        final long cs = System.currentTimeMillis();

        System.out.println(map_reduce_1(new Plus(),       new Square(), a, 0));
        System.out.println(map_reduce_1(new Plus(),       new Cube(),   a, 0));
        System.out.println(map_reduce_1(new Multiplies(), new Square(), a, 1));
        System.out.println(map_reduce_1(new Multiplies(), new Cube(),   a, 1));

        final long ct = System.currentTimeMillis();
        final long cd = ct - cs;
        System.out.println(cd + " milliseconds");
        System.out.println();
        }

        {
        System.out.println("map_reduce_2");
        final long cs = System.currentTimeMillis();

        System.out.println(map_reduce_2(new Plus(),       new Square(), a, 0));
        System.out.println(map_reduce_2(new Plus(),       new Cube(),   a, 0));
        System.out.println(map_reduce_2(new Multiplies(), new Square(), a, 1));
        System.out.println(map_reduce_2(new Multiplies(), new Cube(),   a, 1));

        final long ct = System.currentTimeMillis();
        final long cd = ct - cs;
        System.out.println(cd + " milliseconds");
        System.out.println();
        }

        System.out.println("Done.");}}

/*
java version "1.6.0_22"
Java(TM) SE Runtime Environment (build 1.6.0_22-b04-307-10M3261)
Java HotSpot(TM) 64-Bit Server VM (build 17.1-b03-307, mixed mode)

MapReduce.java

map_reduce_1
1000000
1000000
1
1
158 milliseconds

map_reduce_2
1000000
1000000
1
1
138 milliseconds

Done.
*/

/*
java version "1.6.0_20"
OpenJDK Runtime Environment (IcedTea6 1.9.5) (6b20-1.9.5-0ubuntu1~10.04.1)
OpenJDK Server VM (build 19.0-b09, mixed mode)

MapReduce.java

map_reduce_1
1000000
1000000
1
1
134 milliseconds

map_reduce_2
1000000
1000000
1
1
99 milliseconds

Done.
*/
