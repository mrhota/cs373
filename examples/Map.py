#!/usr/bin/env python

# ------
# Map.py
# ------

def square (x) :
    return x ** 2;

def cube (x) :
    return x ** 3;

def map1 (uf, a) :
    if not a :
        return []
    return [uf(a[0])] + map1(uf, a[1:])

def map2 (uf, a) :
    i = 0
    s = len(a)
    x = []
    while i != s :
        x.append(uf(a[i]))
        i += 1
    return x

def map3 (uf, a) :
    i = iter(a)
    x = []
    while True :
        try :
            x.append(uf(i.next()))
        except StopIteration :
            break
    return x

def map4 (uf, a) :
    x = []
    for v in a :
        x.append(uf(v))
    return x

def map5 (uf, a) :
    return [uf(v) for v in a]

def test (f) :
    a = [2,  3,  4]
    b = [4,  9, 16]
    c = [8, 27, 64]
    assert f(square, a) == b
    assert f(cube,   a) == c

print "Map.py"

test(map)
test(map1)
test(map2)
test(map3)
test(map4)
test(map5)

print "Done."
