#!/usr/bin/env python

# ---------------------
# DoubleInheritance1.py
# ---------------------

print "DoubleInheritance1.py"

class A (object) :
    def __init__ (self) :
        print "A.A()"

class B (A) :
    def __init__ (self) :
        A.__init__(self)
        print "B.B()"

class C (A) :
    def __init__ (self) :
        A.__init__(self)
        print "C.C()"

class D (B, C) :
    def __init__ (self) :
        B.__init__(self)
        C.__init__(self)
        print "D.D()"

x = A()
print

y = B()
print

z = C()
print

t = D()

print "Done."

"""
DoubleInheritance1.py
A.A()

A.A()
B.B()

A.A()
C.C()

A.A()
B.B()
A.A()
C.C()
D.D()
Done.
"""
