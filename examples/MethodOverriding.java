// ---------------------
// MethodOverriding.java
// ---------------------

class A {
    public String f (int i) {
        return "A.f";}

    public String g (int i) {
        return "A.g";}}

class B extends A {
    public String f (String s) {
        return "B.f";}

    public String g (double d) {
        return "B.g";}}

final class MethodOverriding {
    public static void main (String[] args) {
        System.out.println("MethodOverriding.java");

        {
        A x = new A();
        assert x.f(2) == "A.f";
        assert x.g(3) == "A.g";
        }

        {
        A x = new B();
        assert x.f(2) == "A.f";
        assert x.g(3) == "A.g";
        }

        {
        B x = new B();
        assert x.f(2)     == "A.f";
        assert x.f("abc") == "B.f";
        assert x.g(2)     == "A.g";
        assert x.g(2.3)   == "B.g";
        }

        System.out.println("Done.");}}
