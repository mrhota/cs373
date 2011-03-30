#!/usr/bin/env python

# ---------
# Tuples.py
# ---------

print "Tuples.py"

a = (2, 3, "abc")
assert type(a) is     tuple
assert a       ==     (2, 3, 'abc')
assert a       is not (2, 3, 'abc')
assert a       !=     [2, 3, 'abc']

assert () is ()

a = (2, 3, 4)
b = tuple(a)
assert a is b

a = (2, 3, 4)
b = a[:]      # not a copy
assert a is b

a = (2, 3, 4)
b = a
assert a is b
a += (5,)                # immutable
assert a == (2, 3, 4, 5)
assert b == (2, 3, 4)

print "Done."
