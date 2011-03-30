#!/usr/bin/env python

# -------------
# Assertions.py
# -------------

"""
Turn OFF assertions at run time with -O.
% python -O Assertions.py
"""

def inc (v) :
    return v + 1

print "Assertions.py"

assert inc(2) == 3
assert inc(2) == 4

print "Done."

"""
Assertions.py
Traceback (most recent call last):
  File "./Assertions.py", line 18, in <module>
    assert inc(2) == 4
AssertionError
"""
