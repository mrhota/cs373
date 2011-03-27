// -----------
// Arrays.java
// -----------

import java.util.ArrayList;
import java.util.List;

final class Arrays {
    private static void f (int[] a) {
        ++a[1];}

    private static int g (int... a) {
        int s = 0;
        for (final int v : a)
            s += v;
        return s;}

    private static int h (int[] a) {
        int s = 0;
        for (final int v : a)
            s += v;
        return s;}

    public static void main (String[] args) {
        System.out.println("Arrays.java");

        {
        final int[] a = {2, 3, 4};
        assert a.length == 3;
        assert a[1]     == 3;
        try {
            assert a[3] == 0;
            assert false;}
        catch (ArrayIndexOutOfBoundsException e)
            {}
        }

        {
        final int[] a = new int[]{2, 3, 4};
        assert a.length == 3;
        assert a[1]     == 3;
        }

        {
        final int   s = 10;
        final int   v =  2;
        final int[] a = new int[s];
        java.util.Arrays.fill(a, v);
        assert a.length == s;
        assert a[1]     == v;
        }

        {
        final int[] a = {2, 3, 4};
        final long  i = 1;
//      assert a[i]       == 3;    // doesn't compile
        assert a[(int) i] == 3;
        }

        {
        final int[] a = {2, 3, 4};
        f(a);
        assert a[1] == 4;
        }

        {
        final int[] a = {2, 3, 4};
        final int[] b = a;
        assert a == b;
        ++b[1];
        assert a[1] == 4;
        assert b[1] == 4;
        }

        {
        final int[] a = {2, 3, 4};
        final int[] b = a.clone();
        assert a != b;
        assert !a.equals(b);
        assert java.util.Arrays.equals(a, b);
        ++b[1];
        assert a[1] == 3;
        assert b[1] == 4;
        }

        {
        final int[] a = {2, 3, 4};
        final int[] b = {2, 3, 4};
        assert a != b;
        assert !a.equals(b);
        assert java.util.Arrays.equals(a, b);
        }

        {
        final String[] a = {"abc", "def", "ghi"};
        final String[] b = {"abc", "def", "ghi"};
        assert a != b;
        assert !a.equals(b);
        assert java.util.Arrays.equals(a, b);
        }

        {
        final String[] a = {new String("abc"), new String("def"), new String("ghi")};
        final String[] b = {new String("abc"), new String("def"), new String("ghi")};
        assert a != b;
        assert !a.equals(b);
        assert java.util.Arrays.equals(a, b);
        }

        {
        final StringBuilder[] a = {new StringBuilder("abc"), new StringBuilder("def"), new StringBuilder("ghi")};
        final StringBuilder[] b = {new StringBuilder("abc"), new StringBuilder("def"), new StringBuilder("ghi")};
        assert a != b;
        assert !a.equals(b);
        assert !java.util.Arrays.equals(a, b);
        }

        {
        final int[] a = {2, 3, 4};
        System.arraycopy(a, 0, a, 1, 2);
        assert java.util.Arrays.equals(a, new int[]{2, 2, 3});
        }

        {
        final int[] a = {2, 3, 4};
        System.arraycopy(a, 1, a, 0, 2);
        assert java.util.Arrays.equals(a, new int[]{3, 4, 4});
        }

        {
        final int[] a = {2, 3, 4};
        final int   v = 5;
        final int[] b = {v, v, v};
        java.util.Arrays.fill(a, v);
        assert java.util.Arrays.equals(a, b);
        ++a[1];
        assert a[1] == 6;
        assert b[1] == 5;
        }

        {
        final StringBuilder[] a = {new StringBuilder("abc"), new StringBuilder("def"), new StringBuilder("ghi")};
        final StringBuilder   v = new StringBuilder("xyz");
        final StringBuilder[] b = new StringBuilder[]{v, v, v};
        java.util.Arrays.fill(a, v);
        assert java.util.Arrays.equals(a, b);
        a[1].append("t");
        assert a[1].toString().equals("xyzt");
        assert b[1].toString().equals("xyzt");
        }

        {
//      final int[]    a = (int   []) new double[3]; // doesn't compile
//      final double[] a = (double[]) new int[3];    // doesn't compile
//      final String[] a = (String[]) new Object[3]; // ClassCastException
        final Object[] a = new String[3];
        }

        {
        final Object[] a = new String[] {"abc", "def", "ghi"};
        assert a.length == 3;
        assert a[1] == "def";
        a[1] = "xyz";
        assert a[1] == "xyz";
        try {
            a[1] = new StringBuilder("uvw");
            assert false;}
        catch (ArrayStoreException e)
            {}
        }

        {
        final Object[]     a = new String[] {"abc", "def", "ghi"};
        final List<Object> x = java.util.Arrays.asList(a);
        assert x.size() == 3;
        assert x.get(1) == "def";
        x.set(1, "xyz");
        assert x.get(1) == "xyz";
        assert a[1]     == "xyz";
        try {
            x.set(1, new StringBuilder("uvw"));
            assert false;}
        catch (ArrayStoreException e)
            {}
        final Object[] b = x.toArray();
        assert b.length == 3;
        assert b[1] == "xyz";
        b[1] = "def";
        assert b[1]     == "def";
        assert x.get(1) == "xyz";
        assert a[1]     == "xyz";
        try {
            b[1] = new StringBuilder("uvw");
            assert false;}
        catch (ArrayStoreException e)
            {}
        }

        {
        final ArrayList<String> x = new ArrayList<String>(10);
//      final ArrayList<Object> x = new ArrayList<String>(10); // doesn't compile
        final ArrayList<?>      y = new ArrayList<String>(10);
        x.add("abc");
//      y.add("abc");                                          // doesn't compile
        }

        {
        assert g()                      ==  0;
        assert g(2)                     ==  2;
        assert g(2, 3)                  ==  5;
        assert g(2, 3, 4)               ==  9;
        assert g(2, 3, 4, 5)            == 14;
        assert g(new int[]{2, 3, 4, 5}) == 14;
        }

        {
//      assert h()                      ==  0; // doesn't compile
//      assert h(2)                     ==  2; // doesn't compile
//      assert h(2, 3)                  ==  5; // doesn't compile
//      assert h(2, 3, 4)               ==  9; // doesn't compile
//      assert h(2, 3, 4, 5)            == 14; // doesn't compile
        assert h(new int[]{2, 3, 4, 5}) == 14;
        }

        System.out.println("Done.");}}
