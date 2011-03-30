#!/usr/bin/env python

# ---------
# Reduce.py
# ---------

import operator

def reduce1 (bf, a, v) :
    if not a :
        return v
    return reduce1(bf, a[1:], bf(v, a[0]))

def reduce2 (bf, a, v) :
    i = 0
    s = len(a)
    while i != s :
        v = bf(v, a[i])
        i += 1
    return v

def reduce3 (bf, a, v) :
    i = iter(a)
    while True :
        try :
            v = bf(v, i.next())
        except StopIteration :
            break
    return v

def reduce4 (bf, a, v) :
    for w in a :
        v = bf(v, w)
    return v

def test (f) :
    a = [2, 3, 4]
    assert f(operator.add, a, 0) ==  9
    assert f(operator.mul, a, 1) == 24

print "Reduce.py"

test(reduce)
test(reduce1)
test(reduce2)
test(reduce3)
test(reduce4)

print "Done."
