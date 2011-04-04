#!/usr/bin/env python

# -------------
# SumSquares.py
# --------------

import operator
import sys
import time

def bind1st (bf, x) :
    return lambda y : bf(x, y)

def bind2nd (bf, y) :
    return lambda x : bf(x, y)

def compose (f, g) :
    return lambda x : f(g(x))

def sum_squares_1 (a) :
    return reduce(operator.add, map(bind2nd(operator.pow, 2), a))

def sum_squares_2 (a) :
    return sum(map(bind2nd(operator.pow, 2), a))

sum_squares_3 = \
    compose(
        sum,
        bind1st(map, bind2nd(operator.pow, 2)))

def test1 (f) :
    a = [2, 3, 4]
    assert f(a) == 29

def test2 (f) :
    print f.__name__
    a = 1000000 * [1]
    s = time.clock()
    print f(a)
    t = time.clock()
    print (t - s) * 1000, "milliseconds"
    print

print "SumSquares.py"
print

print sys.version
print

test1(sum_squares_1)
test1(sum_squares_2)
test1(sum_squares_3)

test2(sum_squares_1)
test2(sum_squares_2)
test2(sum_squares_3)

print "Done."

"""
SumSquares.py

2.6.1 (r261:67515, Jun 24 2010, 21:47:49)
[GCC 4.2.1 (Apple Inc. build 5646)]

sum_squares_1
1000000
352.021 milliseconds

sum_squares_2
1000000
289.403 milliseconds

<lambda>
1000000
290.893 milliseconds

Done.
"""

"""
SumSquares.py

2.6.5 (r265:79063, Apr 16 2010, 13:09:56)
[GCC 4.4.3]

sum_squares_1
1000000
350.0 milliseconds

sum_squares_2
1000000
290.0 milliseconds

<lambda>
1000000
310.0 milliseconds

Done.
"""
