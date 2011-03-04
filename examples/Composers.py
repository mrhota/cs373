#!/usr/bin/env python

# ------------
# Composers.py
# ------------

import operator

def bind2nd (bf, y) :
    return lambda x : bf(x, y)

def compose (f, g) :
    return lambda x : f(g(x))

print "Composers.py"

f = compose(bind2nd(operator.add, 1), bind2nd(operator.mul, 3))
assert f(5) == 16

print "Done."
