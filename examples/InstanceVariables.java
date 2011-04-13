// ----------------------
// InstanceVariables.java
// ----------------------

final class A<T> { // extends Object
    public T v0;

    public int v1 = 1;
    public int v2 = v1 + 1;
    public int v3;

//  public final int cv0;           // error: variable cv0 might not have been initialized
    public final int cv1 = 1;
    public final int cv2 = cv1 + 1;
    public final int cv3;

    {
        v3  = v2  + 1;
        cv3 = cv2 + 1;
    }}

final class InstanceVariables {
    public static void main (String[] args) {
        System.out.println("InstanceVariables.java");

        final A<Integer> x = new A<Integer>();

        assert x.v0 == null;
        assert x.v1 == 1;
        assert x.v2 == 2;
        assert x.v3 == 3;

        assert x.cv1 == 1;
        assert x.cv2 == 2;
        assert x.cv3 == 3;

//      assert A<Integer>.v0 == null; // illegal start of expression

        System.out.println("Done.");}}
