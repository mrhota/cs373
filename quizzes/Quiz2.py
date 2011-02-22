#!/usr/bin/env python

"""
CS373: Quiz #2 (5 pts)
"""

""" ----------------------------------------------------------------------
1. What are the four elements of the Circle of Life?
   [XP: Ch.2, Pg. 16]
   (1 pt)

define, estimate, choose, build
"""

""" ----------------------------------------------------------------------
2. What is the output of the following program?
   [Collatz]
   (2 pts)

5
11
"""

def f (n) :
    return n + (n >> 1) + 1 # the bit shift operator does not modify n

print f(3)
print f(7)

""" ----------------------------------------------------------------------
3. In the context of Project #1: Collatz, what is f() computing?
   [Collatz]
   (1 pt)

For odd n it's computing (3n + 1) / 2.
(3n + 1) / 2
3n/2 + 1/2
n + n/2 + 1/2
n + n/2 + 1, because n is odd
n + (n >> 1) + 1
"""
