#!/usr/bin/env python

# ------
# Map.py
# ------

import math

print "Map.py"

def map_1 (uf, a) :
    if not a :
        return []
    return [uf(a[0])] + map_1(uf, a[1:])

def map_2 (uf, a) :
    i = 0
    s = len(a)
    x = []
    while i < s :
        x.append(uf(a[i]))
        i += 1
    return x

def map_3 (uf, a) :
    i = iter(a)
    x = []
    while True :
        try :
            x.append(uf(i.next()))
        except StopIteration :
            break
    return x

def map_4 (uf, a) :
    x = []
    for v in a :
        x.append(uf(v))
    return x

def map_5 (uf, a) :
    return [uf(v) for v in a]

def test (f) :
    x = []
    y = (4, 9, 16)
    z = [2, 3,  4]

    assert f(math.sqrt, x) == x
    assert f(math.sqrt, y) == z

test(map)
test(map_1)
test(map_2)
test(map_3)
test(map_4)
test(map_5)

print "Done."
