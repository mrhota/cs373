#!/usr/bin/env python

# ---------------------
# DoubleInheritance2.py
# ---------------------

print "DoubleInheritance2.py"

class A (object) :
    def __init__ (self) :
        super(A, self).__init__()
        print "A.A()"

class B (A) :
    def __init__ (self) :
        super(B, self).__init__()
        print "B.B()"

class C (A) :
    def __init__ (self) :
        super(C, self).__init__()
        print "C.C()"

class D (C, B) :
    def __init__ (self) :
        super(D, self).__init__()
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
DoubleInheritance2.py
A.A()

A.A()
B.B()

A.A()
C.C()

A.A()
B.B()
C.C()
D.D()
Done.
"""
