#!/usr/bin/env python

"""
CS373: Quiz #20 (5 pts)
"""

""" ----------------------------------------------------------------------
1. What is the output of the following program?
   (4 pts)

[4, 9, 16]
[4, 9, 16]
[4, 9, 16]
[]
"""

def square (x) :
    return x ** 2

a = [2, 3, 4]
i = iter(a)

print map(square, a)
print map(square, i)

print map(square, a)
print map(square, i)
