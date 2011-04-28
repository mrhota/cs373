#!/usr/bin/env python

# ----------
# Visitor.py
# ----------

# http://en.wikipedia.org/wiki/Visitor_pattern

class List :
    def length (self) :
        return self.accept(LengthVisitor())

class Nil (List) :
    def accept (self, v) :
        return v.nil_visit(self)

class Cons (List) :
    def __init__ (self, first, rest) :
        self.__first = first
        self.__rest  = rest

    def accept (self, v) :
        return v.cons_visit(self)

    def first (self) :
        return self.__first

    def rest (self) :
        return self.__rest

class LengthVisitor :
    def nil_visit (self, l) :
        return 0

    def cons_visit (self, l) :
        return 1 + l.rest().length()

print 'Visitor.py'

x    = Nil()
x4   = Cons(4, x)
x34  = Cons(3, x4)
x234 = Cons(2, x34)

assert(x.length()    == 0)
assert(x4.length()   == 1)
assert(x34.length()  == 2)
assert(x234.length() == 3)

print "Done."
