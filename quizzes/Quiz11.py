#!/usr/bin/env python

"""
CS373: Quiz #11 (5 pts)
"""

""" ----------------------------------------------------------------------
1. What is the origin of the word "scrum"?
   [SCRUM]
   (1 pt)

the sport of rugby
"""

""" ----------------------------------------------------------------------
2. What is the output of the following program?
   (3 pts)

[2, 3, (4,)]
[2, 3, {'u': 4}]
[2, 3, {'u': 4, 'v': 5}]
"""

def f (x, y, *z) :
    return [x, y, z]

def g (x, y, **z) :
    return [x, y, z]

t = (2, 3, 4)
print f(*t)

d = {"u" : 4, "y" : 3, "x" : 2}
print g(**d)

d = {"u" : 4, "y" : 3, "v" : 5}
print g(2, **d)
