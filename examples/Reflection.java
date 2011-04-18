// ---------------
// Reflection.java
// ---------------

interface I {
    String f ();}

final class A implements I {
    public String f () {
        return "A.f()";}}

final class B implements I {
    public String f () {
        return "B.f()";}}

final class Reflection {
    private static String g (Class c) {
        try {
            I x = (I) c.newInstance();
            return x.f();}
        catch (IllegalAccessException e) {
            e.printStackTrace();}
        catch (InstantiationException e) {
            e.printStackTrace();}
        return null;}

    public static void main (String[] args) {
        System.out.println("Reflection.java");

        {
        assert g(A.class) == "A.f()";
        assert g(B.class) == "B.f()";
        }

        {
        assert g(new A().getClass()) == "A.f()";
        assert g(new B().getClass()) == "B.f()";
        }

        try {
            assert g(Class.forName("A")) == "A.f()";
            assert g(Class.forName("B")) == "B.f()";}
        catch (ClassNotFoundException e) {
            e.printStackTrace();}

        System.out.println("Done.");}}
