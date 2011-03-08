#!/usr/bin/env python

"""
CS373: Quiz #17 (5 pts)
"""

""" ----------------------------------------------------------------------
1. What is the output of the following program?
   (1 pt)

[(2, 5), (3, 6), (4, 7)]
"""

print zip((2, 3, 4), (5, 6, 7))

""" ----------------------------------------------------------------------
2. Define the function flip().
   No need to check the preconditions.
   (3 pts)
"""

import operator

def flip (bf) :
    return lambda x, y : bf(y, x)

assert(flip(operator.sub)(3, 2) == -1)
