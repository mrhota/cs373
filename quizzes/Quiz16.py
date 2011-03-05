#!/usr/bin/env python

"""
CS373: Quiz #16 (5 pts)
"""

""" ----------------------------------------------------------------------
1. My poor-man's type signature for Haskell's map was:
       (a -> a) -> [a] -> [a]
   What would be the more general type signature:
   (1 pt)

(a -> b) -> [a] -> [b]
"""

""" ----------------------------------------------------------------------
2. My poor-man's type signature for Haskell's foldl was:
       (a -> a -> a) -> a -> [a] -> a
   What would be the more general type signature:
   (1 pt)

(a -> b -> a) -> a -> [b] -> a
"""

""" ----------------------------------------------------------------------
3. What is the time and space complexity of the following definition of
   map_reduce()?
   Be very precise (e.g. O(1n), O(2n), O(3n), O(n^2), O(n^3)).
   (2 pts)

time:  O(2n)
space: O( n)
"""

def map_reduce (bf, uf, a, v) :
    return reduce(bf, map(uf, a), v)
