#!/usr/bin/env python

# -------
# RMSE.py
# -------

import sys
import time

def square_of_difference (x, y) :
    return float(x - y) ** 2

def mean (a) :
    return sum(a) / len(a)

def rmse1 (a, p) :
    i = 0
    s = len(a)
    v = 0
    while i != s :
        v += square_of_difference(a[i], p[i])
        i += 1
    return (v / s) ** .5

def rmse2 (a, p) :
    z = zip(a, p)
    i = 0
    s = len(a)
    v = 0
    for (x, y) in z :
        v += square_of_difference(x, y)
    return (v / s) ** .5

def rmse3 (a, p) :
    return mean(map(lambda (x, y) : square_of_difference(x, y), zip(a, p))) ** .5

def rmse4 (a, p) :
    return (reduce(lambda v, (x, y) : v + square_of_difference(x, y), zip(a, p), 0) / len(a)) ** .5

def rmse5 (a, p) :
    return mean(map(square_of_difference, a, p)) ** .5

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
test1(rmse4)
test1(rmse5)

test2(rmse1)
test2(rmse2)
test2(rmse3)
test2(rmse4)
test2(rmse5)

print "Done."

"""
RMSE.py

2.5.4 (r254:67916, Jun 24 2010, 21:47:25)
[GCC 4.2.1 (Apple Inc. build 5646)]

rmse1
4.0
1154.111 milliseconds

rmse2
4.0
2081.106 milliseconds

rmse3
4.0
2481.803 milliseconds

rmse4
4.0
2430.651 milliseconds

rmse5
4.0
925.28 milliseconds

Done.
"""

"""
RMSE.py

2.6.5 (r265:79063, Apr 16 2010, 13:09:56)
[GCC 4.4.3]

rmse1
4.0
620.0 milliseconds

rmse2
4.0
1220.0 milliseconds

rmse3
4.0
1380.0 milliseconds

rmse4
4.0
1370.0 milliseconds

rmse5
4.0
490.0 milliseconds

Done.
"""
