#!/usr/bin/env python

# ------------
# Composite.py
# ------------

# http://en.wikipedia.org/wiki/Composite_pattern

class Nil (object) :
    def length (self) :
        return 0

class Cons (object) :
    def __init__ (self, first, rest) :
        self.__first = first
        self.__rest  = rest

    def length (self) :
        return 1 + self.__rest.length()

print 'Composite.py'

x    = Nil()
x4   = Cons(4, x)
x34  = Cons(3, x4)
x234 = Cons(2, x34)

assert    x.length() == 0
assert   x4.length() == 1
assert  x34.length() == 2
assert x234.length() == 3

print "Done."
