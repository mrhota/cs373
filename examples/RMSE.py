#!/usr/bin/env python

# -------
# RMSE.py
# -------

import math
import sys
import time

def square_of_difference (x, y) :
    return float(x - y)**2

def rmse1 (a, p) :
    i = 0
    s = len(a)
    v = 0
    while i != s :
        v += square_of_difference(a[i], p[i])
        i += 1
    return math.sqrt(v / s)

def rmse2 (a, p) :
    return math.sqrt(reduce(lambda x, (y, z) : x + square_of_difference(y, z), zip(a, p), 0) / len(a))

def mean (a) :
    return sum(a) / len(a)

def rmse3 (a, p) :
    return math.sqrt(mean(map(square_of_difference, a, p)))

def test1 (f) :
    assert str(f((3, 3, 3),       (3, 3, 3)))       == "0.0"
    assert str(f((1, 1, 1, 1),    (5, 5, 5, 5)))    == "4.0"
    assert str(f((5, 3, 2, 4, 5), (2, 4, 3, 1, 2))) == "2.40831891576"

def test2 (f) :
    print f.__name__
    a = 1000000 * [1]
    p = 1000000 * [5]
    s = time.clock()
    print f(a, p)
    t = time.clock()
    print (t - s) * 1000, "milliseconds"
    print

print "RMSE.py"
print

print sys.version
print

assert zip()                       == []
assert zip([])                     == []
assert zip((), ())                 == []
assert zip([2, 3])                 == [(2,), (3,)]
assert zip((2, 3), (4, 5), (6, 7)) == [(2, 4, 6), (3, 5, 7)]
assert zip([2, 3, 4], [5, 6, 7])   == [(2, 5), (3, 6), (4, 7)]

test1(rmse1)
test1(rmse2)
test1(rmse3)

test2(rmse1)
test2(rmse2)
test2(rmse3)

print "Done."

"""
RMSE.py

2.6.1 (r261:67515, Jun 24 2010, 21:47:49)
[GCC 4.2.1 (Apple Inc. build 5646)]

rmse1
4.0
584.237 milliseconds

rmse2
4.0
1722.873 milliseconds

rmse3
4.0
469.992 milliseconds

Done.
"""

"""
RMSE.py

2.6.5 (r265:79063, Apr 16 2010, 13:09:56)
[GCC 4.4.3]

rmse1
4.0
600.0 milliseconds

rmse2
4.0
1290.0 milliseconds

rmse3
4.0
510.0 milliseconds

Done.
"""
