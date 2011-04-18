#!/usr/bin/env python

# -------------
# Reflection.py
# -------------

print "Reflection.py"

class A :
    def f (self) :
        return "A.f()"

class B :
    def f (self) :
        return "B.f()"

def g (c) :
    x = c()
    return x.f()

assert g(A) == "A.f()"
assert g(B) == "B.f()"

d = globals()
assert type(d) is dict

a = d["A"]
assert a is A
assert g(a) == "A.f()"

b = d["B"]
assert b is B
assert g(b) == "B.f()"

print "Done."
