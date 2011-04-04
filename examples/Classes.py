#!/usr/bin/env python

# ----------
# Classes.py
# ----------

print "Classes.py"

class my_complex (object) :
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
    return my_complex(v.r, v.i).conjugate()

x = my_complex()
y = my_complex(2)

z = my_complex(2, 3)
assert z is not my_complex(2, 3)
assert z ==     my_complex(2, 3)
assert str(z) == "(2, 3)"

v = z.conjugate()
assert z == my_complex(2, -3)
assert v is z

w = conjugate(z)
assert z == my_complex(2, -3)
assert w == my_complex(2,  3)

print "Done."
