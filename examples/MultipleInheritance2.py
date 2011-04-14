#!/usr/bin/env python

# -----------------------
# MultipleInheritance2.py
# -----------------------

print "MultipleInheritance2.py"

class A (object) :
    def __init__ (self) :
        print "A.A()"

class B (object) :
    def __init__ (self) :
        print "B.B()"

class C (A, B) :
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
MultipleInheritance.py
A.A()

B.B()

A.A()
B.B()
C.C()
Done.
"""
