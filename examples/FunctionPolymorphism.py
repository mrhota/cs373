#!/usr/bin/env python

# -----------------------
# FunctionPolymorphism.py
# -----------------------

# parametric run-time polymorphism

print "FunctionPolymorphism.py"

class A (object) :
    def __init__ (self, n) :
        self.n = n

    def __lt__ (self, other) :
        return self.n < other.n

class B (A) :
    pass

def my_max (x, y) :
    if x < y :
        return y
    return x

assert hasattr(int,   "__lt__")
assert hasattr(float, "__lt__")
assert hasattr(str,   "__lt__")
assert hasattr(A,     "__lt__")
assert hasattr(B,     "__lt__")

assert my_max(2,   3)   == 3
assert my_max(2.3, 4)   == 4
assert my_max(2,   4.5) == 4.5
assert my_max(2.3, 4.5) == 4.5

assert my_max("abc", "def") == "def"

x = A(2)
y = A(3)
assert my_max(x, y) is y

x = B(2)
y = B(3)
assert my_max(x, y) is y

print "Done."
