#!/usr/bin/env python

"""
CS373: Quiz #29 (5 pts)
"""

""" ----------------------------------------------------------------------
1. What is the output of the following program?
   You MUST get the newlines right to get full credit.
   Write the word "blank" to indicate a blank line.
   (4 pts)

A.__init__()
True
A.__init__() B.__init__()
True
C.__init__()
False
True
"""

class A (object) :
    def __init__ (self) :
        print "A.__init__()",
        self.f()

    def f (self) :
        self.i = 2

class B (A) :
    def __init__ (self) :
        A.__init__(self)
        print "B.__init__()",

class C (A) :
    def __init__ (self) :
        print "C.__init__()",

x = A()
print
print hasattr(x, "i")

y = B()
print
print hasattr(y, "i")

z = C()
print
print hasattr(z, "i")
z.f()
print hasattr(z, "i")

