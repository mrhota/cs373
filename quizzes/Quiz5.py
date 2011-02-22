#!/usr/bin/env python

"""
CS373: Quiz #5 (5 pts)
"""

""" ----------------------------------------------------------------------
1. In pair programming which of the partners should do most of the
   driving?
   [XP: Ch. 12, Pg. 90]
   (1 pt)

the one who is least sure of what's being done
"""

""" ----------------------------------------------------------------------
2. What is the output of the following program?
   (3 pts)

g1
h1 h4
"""

def f (b) :
    if not b :
        raise NameError("abc")
    raise TypeError("def ghi")

def g () :
    try :
        print "g1",
        f(False)
        print "g2",
    except TypeError :
        print "g3",
    print "g4",

def h () :
    try :
        print "h1",
        f(True)
        print "h2",
    except NameError :
        print "h3",
    except TypeError :
        print "h4",
        raise
    print "h5",

try :
    g()
except NameError :
    pass
except TypeError :
    pass
print

try :
    h()
except NameError :
    pass
except TypeError :
    pass
