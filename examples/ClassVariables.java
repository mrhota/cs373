// -------------------
// ClassVariables.java
// -------------------

final class A<T> {      // extends Object
//  public static T v0; // error: non-static class T cannot be referenced from a static context

    public static int v0;
    public static int v1 = v0 + 1;
    public static int v2;

//  public static final T cv; // error: non-static class T cannot be referenced from a static context

//  public static final int cv0;     // error: variable cv3 might not have been initialized
    public static final int cv0 = 0;
    public static final int cv1;

    static
        {
         v2 = v1  + 1;
        cv1 = cv0 + 1;
        }}

final class ClassVariablesTest {
    public static void main (String[] args) {
        System.out.println("ClassVariables.java");

        assert A.v0 == 0;
        assert A.v1 == 1;
        assert A.v2 == 2;

        assert A.cv0 == 0;
        assert A.cv1 == 1;

        System.out.println("Done.");}}
