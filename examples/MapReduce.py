#!/usr/bin/env python

# ------------
# MapReduce.py
# ------------

import operator
import sys
import time

def square (n) :
    return n ** 2;

def cube (n) :
    return n ** 3;

def map_reduce_1 (bf, uf, a, v) :
    return reduce(bf, map(uf, a), v)

def map_reduce_2 (bf, uf, a, v) :
    for w in a :
        v = bf(v, uf(w))
    return v

def test1 (f) :
    a = [2, 3, 4]
    assert f(operator.add, square, a, 0) ==    29
    assert f(operator.add, cube,   a, 0) ==    99
    assert f(operator.mul, square, a, 1) ==   576
    assert f(operator.mul, cube,   a, 1) == 13824

def test2 (f) :
    print f.__name__
    a = 1000000 * [1]
    s = time.clock()
    print f(operator.add, square, a, 0)
    print f(operator.add, cube,   a, 0)
    print f(operator.mul, square, a, 1)
    print f(operator.mul, cube,   a, 1)
    t = time.clock()
    print (t - s) * 1000, "milliseconds"
    print

print "MapReduce.py"
print

print sys.version
print

test1(map_reduce_1)
test1(map_reduce_2)

test2(map_reduce_1)
test2(map_reduce_2)

print "Done."

"""
MapReduce.py

2.6.1 (r261:67515, Jun 24 2010, 21:47:49)
[GCC 4.2.1 (Apple Inc. build 5646)]

map_reduce_1
1000000
1000000
1
1
1053.557 milliseconds

map_reduce_2
1000000
1000000
1
1
1200.288 milliseconds

Done.
"""

"""
MapReduce.py

2.6.5 (r265:79063, Apr 16 2010, 13:09:56)
[GCC 4.4.3]

map_reduce_1
1000000
1000000
1
1
970.0 milliseconds

map_reduce_2
1000000
1000000
1
1
1040.0 milliseconds

Done.
"""
