/*
CS373: Quiz #26 (5 pts)
*/

/* -----------------------------------------------------------------------
1. What is the output of the following program?
   (4 pts)

B.f()
B.g()
B.f()
A.g()
*/

class A {
    void f (A v) {
        System.out.println("A.f()");}

    void g (A v) {
        System.out.println("A.g()");}}

class B extends A {
    void f (A v) {
        System.out.println("B.f()");}

    void g (B v) {
        System.out.println("B.g()");}}

class Quiz26 {
    public static void main (String[] args) {
        {
        B x = new B();
        x.f(null);
        x.g(null);
        }

        {
        A x = new B();
        x.f(null);
        x.g(null);
        }}}
