#!/usr/bin/env python

# -------------------
# FunctionDefaults.py
# -------------------

print "FunctionDefaults.py"

def f (x, y, z = 4) : # trailing arguments
    return [x, y, z]

def g (x = 2, y = 3, z = 4) :
    return [x, y, z]

def h1 (y = []) :          # mutable default
    assert type(y) is list
    y += [2]
    return y

def h2 (y = None) :
    if y is None :
        y = []
    assert type(y) is list
    y += [2]
    return y

assert f(2, 3)    == [2, 3, 4]
assert f(2, 3, 5) == [2, 3, 5]

assert g()         == [2, 3, 4]
assert g(3)        == [3, 3, 4]
assert g(3, 4)     == [3, 4, 4]
assert g(3, 4, 5)  == [3, 4, 5]
assert g(3, z = 5) == [3, 3, 5]

assert h1()    == [2]
assert h1()    == [2, 2]
assert h1([1]) == [1, 2]
assert h1()    == [2, 2, 2]
assert h1([1]) == [1, 2]

assert h2()    == [2]
assert h2()    == [2]
assert h2([1]) == [1, 2]
assert h2()    == [2]
assert h2([1]) == [1, 2]

print "Done."
