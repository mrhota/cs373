#!/usr/bin/env python

# ----------
# Classes.py
# ----------

print "Classes.py"

class My_Complex (object) :
    def __init__ (self, r = 0, i = 0) :
        self.r = r
        self.i = i

    def __eq__ (self, rhs) :
        if not isinstance(rhs, My_Complex) :
            return False
        return (self.r == rhs.r) and (self.i == rhs.i)

    def __str__ (self) :
        return "(" + str(self.r) + ", " + str(self.i) + ")"

    def conjugate (self) :
        self.i = -self.i
        return self

def conjugate (v) :
    return My_Complex(v.r, v.i).conjugate()

x = My_Complex()
y = My_Complex(2)

z = My_Complex(2, 3)
assert z is not My_Complex(2, 3)
assert z ==     My_Complex(2, 3)
assert str(z) == "(2, 3)"

t = z.conjugate()
assert z == My_Complex(2, -3)
assert z is t

t = My_Complex.conjugate(z)
assert z == My_Complex(2, 3)
assert z is t

t = conjugate(z)
assert z == My_Complex(2,  3)
assert t == My_Complex(2, -3)

print "Done."
