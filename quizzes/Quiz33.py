#!/usr/bin/env python

"""
CS373: Quiz #33 (5 pts)
"""

""" ----------------------------------------------------------------------
1. What is the output of the following program?
   (4 pts)

A
B
decorator.__init__()
C
decorator.__call__()
x.f().y
"""

print "A"

class Decorator (object) :
    def __init__ (self, f) :
        print "Decorator.__init__()"
        self.f = f

    def __call__ (self) :
        print "Decorator.__call__()"
        return "x." + self.f() + ".y"

print "B"

@Decorator
def f () :
    return "f()"

print "C"

print f()
