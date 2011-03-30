// -------------
// Arrays2D.java
// -------------

import java.util.Arrays;

final class Arrays2DTest {
    public static void main (String[] args) {
        System.out.println("Arrays2D.java");

        {
        final long[][] a = {{2, 3, 4}, {4, 5, 6}};
        final long[][] b = {{2, 3, 4}, {4, 5, 6}};
        assert a != b;
        assert !a.equals(b);
        assert !Arrays.equals(a, b);
        assert Arrays.deepEquals(a, b);
        final long[][] c = (long[][]) a.clone();
        assert a != c;
        assert !a.equals(c);
        assert Arrays.equals(a, c);                // there is no deepClone()
        assert Arrays.deepEquals(a, c);
        }

        {
        final long[][] a = new long[][]{{2, 3, 4}, {4, 5, 6}};
        final long[][] b = new long[][]{{2, 3, 4}, {4, 5, 6}};
        assert a != b;
        assert !a.equals(b);
        assert !Arrays.equals(a, b);
        assert Arrays.deepEquals(a, b);
        final long[][] c = (long[][]) a.clone();
        assert a != c;
        assert !a.equals(c);
        assert Arrays.equals(a, c);
        assert Arrays.deepEquals(a, c);
        }

        {
        final int      r =  5;
        final int      c = 10;
        final long     v =  2;
        final long[][] a = new long[r][c];
        for (int i = 0; i != r; ++i)
            Arrays.fill(a[i], v);
        assert a.length    == r;
        assert a[0].length == c;
        for (int i = 0; i != r; ++i)
            for (int j = 0; j < c; ++j)
                assert a[i][j] == v;
        }

        {
        final int      r =  5;
        final int      c = 10;
        final long     v =  2;
        final long[][] a = new long[r][];
        for (int i = 0; i != r; ++i) {
            a[i] = new long[i];
            Arrays.fill(a[i], v);}
        assert a.length        == r;
        assert a[0].length     == 0;
        assert a[r - 1].length == r - 1;
        for (int i = 0; i != r; ++i)
            for (int j = 0; j != i; ++j)
                assert a[i][j] == v;
        }

        System.out.println("Done.");}}
