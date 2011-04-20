//
// AbstractClasses.d
//

/*
gdc -o AbstractClasses AbstractClasses.d // GNU D compiler

or use ldc, link in tango libs:
ldc -L-ltango-base-ldc -L-ltango-user-ldc -of AbstractClasses -enable-asserts AbstractClasses.d
*/

// LLVM D Compiler uses Tango library on my Linux system
version(LDC) {
    import tango.io.Console;
    alias Cout writef;
    char[] s = "using ldc and tango.\n";
} else {
    import std.stdio;
    //import std.container : Array; // no std.container with gdc!
    import std.string;
    char[] s = "using gdc with phobos.\n";
}

//--------------

abstract class AbstractShape {
    private int _x;
    private int _y;

    protected this (int x, int y) {
        _x = x;
        _y = y;
    }

    /* D allows for implementing abstract methods, providing
       "base-class behavior" even though descendants must override
       them. */
    public abstract double area () {
        return 0.0;
    }

    public final void move (int x, int y) {
        _x = x;
        _y = y;
    }

    public abstract string toString() {
        return std.string.toString(_x) ~ ", " ~ std.string.toString(_y);
    }
}

final class Circle : AbstractShape {
    private int _r;

    public this (int x, int y, int r) {
        super(x, y);
        _r = r;
    }

    public double area () {
        return 3.14 * _r * _r;
    }

    public int radius () {
        return _r;
    }

    public string toString () {
        return "(" ~ super.toString() ~ ", " ~ std.string.toString(_r) ~ ")";
    }
}

int main () {
    writef(s);
    writef("AbstractClasses.d\n");

    {
        final Circle x = new Circle(2, 3, 4);
        assert(x.area() == 3.14 * 4 * 4);
        x.move(5, 6);
        assert(x.radius() == 4);
        assert(x.toString() == "(5, 6, 4)");
    }

    {
        final AbstractShape x = new Circle(2, 3, 4);
        assert(x.area() == 3.14 * 4 * 4);
        assert(x.toString() == "(2, 3, 4)");
        x.move(5, 6);
        //assert(x.radius() == 0);
        assert((cast(Circle)x).radius() == 4);
        assert(x.toString() == "(5, 6, 4)");
    }

    {
        final AbstractShape[] a = [new Circle(2, 3, 4), new Circle(5, 6, 7)];
        assert(a[0].area() == 3.14 * 4 * 4);
        assert(a[1].area() == 3.14 * 7 * 7);
    }

    {
        final AbstractShape[] a = new Circle[3];
        //final Array!(AbstractShape) a = new Array!(Circle); // gdc does not fully implement std library, oops
    }

    writef("Done.\n");
    return 0;
}
