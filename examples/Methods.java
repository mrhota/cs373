// ------------
// Methods.java
// ------------

final class A {
    private static int _cv;

    private int _iv;

    public A () {
        _iv = 0;
        cm();
        im();}

    public static void cm () {
        ++_cv;
//      ++_iv;      // error: non-static variable _iv cannot be referenced from a static context
//      im();       // error: non-static method im() cannot be referenced from a static context
//      A r = this; // error: non-static variable this cannot be referenced from a static context
        }

    public void im () {
        ++_cv;
        ++_iv;
        cm();
        A r = this;}}

final class Methods {
    public static void main (String[] args) {
        System.out.println("Methods.java");

        A.cm();
//      A.im(); // error: non-static method im() cannot be referenced from a static context

        A x = new A();
        x.cm();
        x.im();

        System.out.println("Done.");}}
