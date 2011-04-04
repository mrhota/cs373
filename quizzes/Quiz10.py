#!/usr/bin/env python

"""
CS373: Quiz #10 (5 pts)
"""

""" ----------------------------------------------------------------------
1. What is the output of the following program?
   (4 pts)

['a', 'b', (6, 7), [8, 9]]
[2, 3, (6, 7), 'cde']
[4, 5, 2, 3]
['y', 'z', 4, 5]
"""

def f ((w, x), y = (6, 7), z = [8, 9]) :
    return [w, x, y, z]

t = (2, 3)
d = {"y" : 4, "z" : 5}

print f("ab")
print f(t, z = "cde")
print f(d.values(), *t)
print f(d, **d)
