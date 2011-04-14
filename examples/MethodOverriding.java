// ---------------------
// MethodOverriding.java
// ---------------------

class A {
    public String f (int i) {
        return "A.f";}

    public String g (int i) {
        return "A.g";}

    public String h (int i) {
        return "A.h";}}

class B extends A {
    public String f (int i) {
        return "B.f";}

    public String g (String s) {
        return "B.g";}

    public String h (double d) {
        return "B.h";}}

final class MethodOverriding {
    public static void main (String[] args) {
        System.out.println("MethodOverriding.java");

        {
        A x = new A();
        assert x.f(2)     == "A.f";
        assert x.g(3)     == "A.g";
//      assert x.g("abc") == "A.g"; // g(int) in A cannot be applied to (java.lang.String)
        assert x.h(4)     == "A.h";
//      assert x.h(5.67)  == "A.h"; // h(int) in A cannot be applied to (double)
        }

        {
        A x = new B();
        assert x.f(2)     == "B.f";
        assert x.g(3)     == "A.g";
//      assert x.g("abc") == "B.g"; // g(int) in A cannot be applied to (java.lang.String)
        assert x.h(4)     == "A.h";
//      assert x.h(5.67)  == "B.h"; // h(int) in A cannot be applied to (double)
        }

        {
        B x = new B();
        assert x.f(2)     == "B.f";
        assert x.g(3)     == "A.g";
        assert x.g("abc") == "B.g";
        assert x.h(3)     == "A.h";
        assert x.h(5.67)  == "B.h";
        }

        System.out.println("Done.");}}
