// ----------------------
// InstanceVariables.java
// ----------------------

final class A<T> { // extends Object
    public T _v0;

    public int _v1 = 1;
    public int _v2 = _v1 + 1;
    public int _v3;

//  public final int _cv0;            // error: variable _cv0 might not have been initialized
    public final int _cv1 = 1;
    public final int _cv2 = _cv1 + 1;
    public final int _cv3;

    {
        _v3  = _v2  + 1;
        _cv3 = _cv2 + 1;
    }}

final class InstanceVariables {
    public static void main (String[] args) {
        System.out.println("InstanceVariables.java");

        final A<Integer> x = new A<Integer>();
        assert x._v0 == null;
        assert x._v1 == 1;
        assert x._v2 == 2;
        assert x._v3 == 3;

        assert x._cv1 == 1;
        assert x._cv2 == 2;
        assert x._cv3 == 3;

//      assert A<Integer>._v0 == null; // illegal start of expression

        System.out.println("Done.");}}
