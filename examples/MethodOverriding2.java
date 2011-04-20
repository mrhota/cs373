// ----------------------
// MethodOverriding2.java
// ----------------------

class A {
    public String f (int i) {
        return "A.f";}

    public String g (int i) {
        return "A.g";}}

class B extends A {
    public String f (int i) {
        return "B.f";}

    public String g (double d) {
        return "B.g";}}

final class MethodOverriding2 {
    public static void main (String[] args) {
        System.out.println("MethodOverriding2.java");

        A x = new B();

        assert x.f(2) == "B.f";
        assert x.g(2) == "A.g";

        System.out.println("Done.");}}
