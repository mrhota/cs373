#!/usr/bin/env python

# --------------------
# StandardDeviation.py
# --------------------

import operator
import sys
import time

def bind1st (bf, x) :
    return lambda y : bf(x, y)

def bind2nd (bf, y) :
    return lambda x : bf(x, y)

def compose (f, g) :
    return lambda x : f(g(x))

def compose2 (f, g) :
    return lambda x, y : f(g(x, y))

def mean (a) :
    return float(sum(a)) / len(a)

def square_of_difference (x, y) :
    return (x - y) ** 2

def standard_deviation (a) :
	m = mean(a)
	v = 0
	for w in a :
		v += square_of_difference(w, m)
	return (v / len(a)) ** 0.5

def standard_deviation_1 (a) :
    return mean(map(square_of_difference, a, len(a) * [mean(a)])) ** 0.5

def standard_deviation_2 (a) :
    m = mean(a)
    return mean(map(lambda x : square_of_difference(x, m), a)) ** 0.5

def standard_deviation_3 (a) :
    return mean(map(bind2nd(square_of_difference, mean(a)), a)) ** 0.5

def test1 (f) :
    assert str(f([2, 3, 4])) == "0.816496580928"

def test2 (f) :
    print f.__name__
    a = 1000000 * [1]
    s = time.clock()
    print f(a)
    t = time.clock()
    print (t - s) * 1000, "milliseconds"
    print

print "StandardDeviation.py"
print

print sys.version
print

test1(standard_deviation)
test1(standard_deviation_1)
test1(standard_deviation_2)
test1(standard_deviation_3)

test2(standard_deviation)
test2(standard_deviation_1)
test2(standard_deviation_2)
test2(standard_deviation_3)

print "Done."

"""
StandardDeviation.py

2.6.1 (r261:67515, Jun 24 2010, 21:47:49)
[GCC 4.2.1 (Apple Inc. build 5646)]

standard_deviation_1
0.0
340.466 milliseconds

standard_deviation_2
0.0
402.411 milliseconds

standard_deviation_3
0.0
412.174 milliseconds

Done.
"""

"""
StandardDeviation.py

2.6.5 (r265:79063, Apr 16 2010, 13:09:56)
[GCC 4.4.3]

standard_deviation_1
0.0
340.0 milliseconds

standard_deviation_2
0.0
480.0 milliseconds

standard_deviation_3
0.0
450.0 milliseconds

Done.
"""
