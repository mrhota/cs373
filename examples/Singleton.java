// --------------
// Singleton.java
// --------------

class Eager {
    public static final Eager only = new Eager();

    private Eager ()
        {}

    String f () {
        return "Eager.f()";}}

class Lazy {
    private static Lazy _only;

    private Lazy ()
        {}

    public static Lazy only () {
        if (Lazy._only == null)
            Lazy._only = new Lazy();
        return Lazy._only;}

    String f () {
        return "Lazy.f()";}}

final class Singleton {
    public static void main (String[] args) {
        System.out.println("Singleton.java");

        assert Eager.only == Eager.only;
        assert Eager.only.f().equals("Eager.f()");

        assert Lazy.only() == Lazy.only();
        assert Lazy.only().f().equals("Lazy.f()");

        System.out.println("Done.");}}
