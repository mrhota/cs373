// ---------------
// Assertions.java
// ---------------

/*
Turn ON assertions at run time with -ea.
% javac -Xlint Assertions.java
% java  -ea    Assertions
*/

final class Assertions {
    public static int inc (int v) {
        return v + 1;}

    public static void main (String[] args) {
        System.out.println("Assertions.java");

        assert inc(2) == 3;
        assert inc(2) == 4;

        System.out.println("Done.");}}

/*
Assertions.java
Exception in thread "main" java.lang.AssertionError
	at Assertions.main(Assertions.java:19)
*/
