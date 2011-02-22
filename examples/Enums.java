// ----------
// Enums.java
// ----------

enum Color1 {
    red,
    green,
    blue,
    yellow,
    purple}

enum Color2 {
    red,
    green,
    blue,
    yellow,
    purple}

final class Enums {
    public static void f (Color1 c) {
        assert c == Color1.blue;}

    public static void main (String[] args) {
        System.out.println("Enums.java");

        assert Color1.red == Color1.red;
        assert Color1.red.equals(Color1.red);

        assert Color1.green != Color1.blue;
        assert !Color1.green.equals(Color1.blue);

        assert Color1.red.compareTo(Color1.blue) < 0;

//      assert Color1.red != Color2.red;             // error: incomparable types: Color1 and Color2
        assert !Color1.red.equals(Color2.red);
//      assert Color1.red.compareTo(Color2.red) < 0; // error: compareTo(Color1) in java.lang.Enum<Color1> cannot be applied to (Color2)

        assert Color1.red.ordinal()    == 0;
        assert Color1.blue.ordinal()   == 2;
        assert Color1.yellow.ordinal() == 3;

        {
        Color1 x = Color1.red;
        Color1 y = Color1.green;
        Color1 z = Color1.blue;

        switch (x) {
            case red:
            break;

            case green:
            break;

            default:}
        }

        {
        int i = Color1.blue.ordinal();
        assert i == 2;
//      Color t = 2;                  // error: incompatible types
        }

        f(Color1.blue);
//      f(2);           // error: f(Color) in Enums cannot be applied to (int)

        System.out.println("Done.");}}
