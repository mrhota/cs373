#!/usr/bin/env python

# ------------
# Factorial.py
# ------------

import math
import operator
import sys
import time

class Iota1 (object) :
    def __init__ (self, b, e) :
        self.b = b
        self.e = e

    def __iter__ (self) :
        return self

    def next (self) :
        if self.b == self.e :
            raise StopIteration()
        p = self.b
        self.b += 1
        return p

def Iota2 (b, e) :
    while b != e :
        yield b
        b += 1

def factorial1 (n) :
    if n < 2 :
        return 1
    return n * factorial1(n - 1)

def factorial2 (n) :
    x = 1
    while n > 1 :
        x *= n
        n  = n - 1
    return x

def factorial3 (n) :
    return reduce(operator.mul, range(1, n + 1), 1)

def factorial4 (n) :
    return reduce(operator.mul, xrange(1, n + 1), 1)

def factorial5 (n) :
    return reduce(operator.mul, Iota1(1, n + 1), 1)

def factorial6 (n) :
    return reduce(operator.mul, Iota2(1, n + 1), 1)

def test1 (f) :
    assert f(0) ==   1
    assert f(1) ==   1
    assert f(2) ==   2
    assert f(3) ==   6
    assert f(4) ==  24
    assert f(5) == 120

def test2 (f) :
    print f.__name__
    s = time.clock()
    print f(100)
    t = time.clock()
    print (t - s) * 1000, "milliseconds"
    print

print "Factorial.py"
print

print sys.version
print

test1(math.factorial)
test1(factorial1)
test1(factorial2)
test1(factorial3)
test1(factorial4)
test1(factorial5)
test1(factorial6)

test2(math.factorial)
test2(factorial1)
test2(factorial2)
test2(factorial3)
test2(factorial4)
test2(factorial5)
test2(factorial6)

print "Done."

"""
Factorial.py

2.6.1 (r261:67515, Jun 24 2010, 21:47:49)
[GCC 4.2.1 (Apple Inc. build 5646)]

factorial (built-in)
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
0.047 milliseconds

factorial1 (recursive)
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
0.111 milliseconds

factorial2 (factorial)
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
0.045 milliseconds

factorial3 (reduce / range)
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
0.042 milliseconds

factorial4 (reduce / xrange)
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
0.039 milliseconds

factorial5 (iterator)
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
0.101 milliseconds

factorial6 (generator)
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
0.057 milliseconds

Done.
"""
