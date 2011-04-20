//
// DynamicBinding.d
//

/*
gdc -o DynamicBinding DynamicBinding.d // GNU D compiler

or use ldc, link in tango libs:
ldc -L-ltango-base-ldc -L-ltango-user-ldc -of DynamicBinding -enable-asserts DynamicBinding.d
*/

// LLVM D Compiler uses Tango library on my Linux system
version(LDC) {
    import tango.io.Console;
    alias Cout writef;
    char[] s = "using ldc and tango.\n";
} else {
    import std.stdio;
    char[] s = "using gdc with phobos.\n";
}

//--------------

class A {
    public char[] f1 () {
        return f2();
    }

    public char[] f2 () {
        return "A.f2";
    }

    public char[] g1 () {
        return g2();
    }

    public static char[] g2 () {
        return "A.g2";
    }

    public char[] h1 () {
        return h2();
    }

    private char[] h2 () {
        return "A.h2";
    }
}

class B : A {
    public char[] f2 () {
        return "B.f2";
    }

    public static char[] g2 () {
        return "B.g2";
    }

    public char[] h2 () {
        return "B.h2";
    }
}

int main() {
    writef(s);
    writef("DynamicBinding.d\n");

    {
        A x = new A();
        assert(x.f1() == "A.f2");
        assert(x.g1() == "A.g2");
        assert(x.h1() == "A.h2");
    }

    {
        B x = new B();
        assert(x.f1() == "B.f2");
        assert(x.g1() == "A.g2");
        assert(x.h1() == "A.h2");
    }

    {
        A x = new B();
        assert(x.f1() == "B.f2");
        assert(x.g1() == "A.g2");
        assert(x.h1() == "A.h2");
    }

    writef("Done.\n");
    return 0;
}
