#!/usr/bin/env python

# --------
# Types.py
# --------

import sys
import types

print "Types.py"

b = True
b = False
assert type(b)    is bool
assert type(bool) is type

i = 2
assert type(i)   is int
assert type(int) is type

j = 2L
assert type(j)    is long
assert type(long) is type

f = 2.3
assert type(f)     is float
assert type(float) is type

c = 2 + 3j
assert type(complex) is type
assert type(c)       is complex

s = 'abc'
s = "abc"
assert type(str) is type
assert type(s)   is str

l = [2, 3, 4]
assert type(list) is type
assert type(l)    is list

t = (2, 3, 4)
assert type(tuple) is type
assert type(t)     is tuple

d = {2 : "def", 3.45 : 3, "abc" : 6.78}
assert type(dict) is type
assert type(d)    is dict

class A (object) :
    def __init__ (self, i, d, x) :
        self.i = i
        self.d = d
        self.x = x

class B (A) :
    def __init__ (self, i, d, x) :
        A.__init__(self, i, d, x)

x = A(2, 3.45, "abc");
assert type(A) is type
assert type(x) is A

y = B(2, 3.45, 6);
assert type(B) is type
assert type(y) is B

assert     issubclass(bool, int)
assert not issubclass(int,  long)

assert issubclass(A, object)
assert issubclass(A, A)

assert issubclass(B, object)
assert issubclass(B, A)
assert issubclass(B, B)

def inc (v) :
    return v + 1

assert type(inc) is types.FunctionType

print "Done."
