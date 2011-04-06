#!/usr/bin/env python

# ----------
# Classes.py
# ----------

print "Classes.py"

class My_Complex (object) :
    def __init__ (self, r = 0, i = 0) :
        self.r = r
        self.i = i

    def conjugate (self) :
        self.i = -self.i
        return self

    def __eq__ (self, rhs) :
        return (self.r == rhs.r) and (self.i == rhs.i)

    def __str__ (self) :
        return "(" + str(self.r) + ", " + str(self.i) + ")"

def conjugate (v) :
    return My_Complex(v.r, v.i).conjugate()

x = My_Complex()
y = My_Complex(2)

z = My_Complex(2, 3)
assert z is not My_Complex(2, 3)
assert z ==     My_Complex(2, 3)
assert str(z) == "(2, 3)"

v = z.conjugate()
assert z == My_Complex(2, -3)
assert z is v

w = conjugate(z)
assert z == My_Complex(2, -3)
assert w == My_Complex(2,  3)

print "Done."
