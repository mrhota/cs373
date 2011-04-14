#!/usr/bin/env python

# -----------------------
# MultipleInheritance2.py
# -----------------------

print "MultipleInheritance2.py"

class A (object) :
    def __init__ (self) :
        super(A, self).__init__()
        print "A.A()"

class B (object) :
    def __init__ (self) :
        super(B, self).__init__()
        print "B.B()"

class C (B, A) :
    def __init__ (self) :
        super(C, self).__init__()
        print "C.C()"

x = A()
print

y = B()
print

z = C()

print "Done."

"""
MultipleInheritance2.py
A.A()

B.B()

A.A()
B.B()
C.C()
Done.
"""
