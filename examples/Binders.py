#!/usr/bin/env python

# ----------
# Binders.py
# ----------

import operator

def bind1st (bf, x) :
    return lambda y : bf(x, y)

def bind2nd (bf, y) :
    return lambda x : bf(x, y)

print "Binders.py"

f = bind1st(operator.sub, 3)
assert f(2) == 1

g = bind2nd(operator.sub, 3)
assert g(2) == -1

print "Done."
