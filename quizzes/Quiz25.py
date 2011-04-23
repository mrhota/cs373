#!/usr/bin/env python

"""
CS373: Quiz #25 (5 pts)
"""

""" ----------------------------------------------------------------------
1. Which design pattern of the Gang of Four does the author use for the
   last refactoring?
   [http://www.refactoring.com/catalog/replaceTypeCodeWithStateStrategy.html]
   [RF: Ch. 1, pg. 38]
   (1 pt)

State / Strategy
"""

""" ----------------------------------------------------------------------
2. What is the output of the following program?
   (2 pts)

set([1, 2]),       any order
set([3, 4, 5, 6]), any order
"""

x = set((1, 2, 3, 5))
y = set([1, 2, 4, 6])

z = (x & y) - (x ^ y)
t = (y ^ x) - (y & x)

print z
print t

""" ----------------------------------------------------------------------
3. In Java why can't a class variable be of type T?
   (1 pt)

there's only instance of a class variable across all instances and
intantiations of the class
"""
