// ----------------
// CommandLine.java
// ----------------

/*
% java -ea CommandLine Nothing to be done.
*/

import java.util.Arrays;

final class CommandLine {
    public static void main (String[] args) {
        System.out.println("CommandLine.java");

        final String[] a = {"Nothing", "to", "be", "done."};
//      assert args == a;
//      assert args.equals(a);
        assert Arrays.equals(args, a);

        System.out.println("Done.");}}
