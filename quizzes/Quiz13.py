#!/usr/bin/env python

"""
CS373: Quiz #13 (5 pts)
"""

""" ----------------------------------------------------------------------
1. What is the domain of an attribute?
   [Classes & Schemes]
   (1 pt)

legal values that may be assigned to it
"""

""" ----------------------------------------------------------------------
2. What is a primary key?
   [Rows & Tables]
   (1 pt)

a unique identifier for each row
"""

""" ----------------------------------------------------------------------
3. What is the output of the following program?
   (2 pts)

sqrt((4 + 0 + 4) / 3)
sqrt(8 / 3)
1.63299
"""

import math

def rmse (a, p) :
    assert type(a) == tuple
    assert type(p) == tuple
    assert len(a)  == len(p)
    i = 0
    s = len(a)
    w = 0
    while i != s :
        v = a[i] - float(p[i])
        w += (v ** 2)
        i += 1
    assert type(w) is float
    assert 0 <= w <= (16 * s)
    m = (w / s)
    assert type(m) is float
    assert 0 <= m <= 16
    r = (m ** .5) # math.sqrt(m)
    assert type(r) is float
    assert 0 <= r <= 4
    return r

print rmse((1, 2, 3), (3, 2, 1))
