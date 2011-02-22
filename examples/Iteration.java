// --------------
// Iteration.java
// --------------

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class Iteration {
    public static void main (String[] args) {
        System.out.println("Iteration.java");

        {
        int i = 0;
        int s = 0;
        while (i != 10) {
            s += i;
            ++i;}
        assert i == 10;
        assert s == 45;
        }

        {
        int i = 0;
        int s = 0;
        do {
            s += i;
            ++i;}
        while (i != 10);
        assert i == 10;
        assert s == 45;
        }

        {
        int s = 0;
        for (int i = 0; i != 10; ++i)
            s += i;
//      assert i == 10;               // error: cannot find symbol
        assert s == 45;
        }

        {
        final int[] a = {2, 3, 4};
              int   s = 0;
        for (int i = 0; i != 3; ++i)
            s += a[i];
        assert s == 9;
        }

        {
        final int[] a = {2, 3, 4};
              int   s = 0;
        for (int v : a)
            s += v;
        assert s == 9;
        assert Arrays.equals(a, new int[]{2, 3, 4});
        }

        {
        final int[] a = {2, 3, 4};
              int   s = 0;
        for (int v : a)
            ++v;                                     // ?
        assert Arrays.equals(a, new int[]{2, 3, 4});
        }

        {
        final String[] a = {"abc", "def", "ghi"};
              int      s = 0;
        for (String v : a)
            v += "x";                                               // ?
        assert Arrays.equals(a, new String[]{"abc", "def", "ghi"});
        }

        {
        final StringBuilder[] a = {new StringBuilder("abc"), new StringBuilder("def"), new StringBuilder("ghi")};
              int             s = 0;
        for (StringBuilder v : a)
            v.append("x");                                                                                                              // ?
        assert !Arrays.equals(a, new StringBuilder[]{new StringBuilder("abcx"), new StringBuilder("defx"), new StringBuilder("ghix")});
        assert a[0].toString().equals("abcx");
        assert a[1].toString().equals("defx");
        assert a[2].toString().equals("ghix");
        }

        {
        final List<Integer> x = new LinkedList<Integer>(Arrays.asList(2, 3, 4));
              int           s = 0;
        for (int i = 0; i != 3; ++i)                                             // O(n^2)
            s += x.get(i);
        assert s == 9;
        }

        {
        final List<Integer> x = new LinkedList<Integer>(Arrays.asList(2, 3, 4));
              int           s = 0;
        for (Iterator<Integer> p = x.iterator(); p.hasNext();)                   // O(n)
            s += p.next();
        assert s == 9;
        }

        {
        final List<Integer> x = new LinkedList<Integer>(Arrays.asList(2, 3, 4));
        int                 s = 0;
        for (int v : x)                                                          // O(n)
            s += v;
        assert s == 9;
        assert x.equals(Arrays.asList(2, 3, 4));
        }

        System.out.println("Done.");}}
