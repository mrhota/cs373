#!/usr/bin/env python

# -------
# AtoI.py
# -------

print "AtoI.py"

def seq () :
    v = 1
    while True :
        yield v
        v *= 10

def map (bf, a, b) :
    i = iter(a)
    j = iter(b)
    while True :
        yield bf(i.next(), j.next())

def atoi_aux (x, y) :
    return (ord(x) - ord('0')) * y

def atoi (a) :
    return sum(map(atoi_aux, a[::-1], seq()))

assert atoi("")     ==   0
assert atoi("0")    ==   0
assert atoi("1")    ==   1
assert atoi("12")   ==  12
assert atoi("123")  == 123
assert atoi("2034") == 2034
assert atoi("2304") == 2304
assert atoi("2340") == 2340

print "Done."
