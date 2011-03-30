#!/usr/bin/env python

"""
CS373: Quiz #19 (5 pts)
"""

""" ----------------------------------------------------------------------
1. Redefine product_of_squares() using the following combinators.
   (4 pts)

product            = bind1st(reduce, operator.mul)
square             = bind2nd(operator.pow, 2)
squares            = bind1st(map, square)
product_of_squares = compose(product, squares)
"""

import operator

def bind1st (bf, x) :
    return lambda y : bf(x, y)

def bind2nd (bf, y) :
    return lambda x : bf(x, y)

def compose (f, g) :
    return lambda x : f(g(x))

def product_of_squares (a) :
    return reduce(operator.mul, map(lambda x : x ** 2, a))

a = [2, 3, 4]
assert product_of_squares(a) == 576 # 4 * 9 * 16
