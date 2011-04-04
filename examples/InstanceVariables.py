#!/usr/bin/env python

# --------------------
# InstanceVariables.py
# --------------------

print "InstanceVariables.py"

class A (object) :
    def f (self) :
#       self.v0                     # AttributeError: 'A' object has no attribute 'v0'
        self.v1   = 1
        self.v2   = self.v1     + 1
        self.__v3 = self.v2     + 1
        self.__v4 = self.__v3   + 1
        self.__v4 = self._A__v3 + 1

x = A()
assert     hasattr(x, "f")
assert not hasattr(x, "v1")

x.f()
assert     hasattr(x, "v1")
assert     hasattr(x, "v2")
assert not hasattr(x, "__v3")
assert     hasattr(x, "_A__v3")
assert     hasattr(x, "_A__v4")
assert not hasattr(x, "v5")
assert     hasattr(x, "__dict__")

assert x.v1                 == 1
assert x.v2                 == 2
assert x._A__v3             == 3
assert x._A__v4             == 4
assert x.__dict__["v1"]     == 1
assert x.__dict__["v2"]     == 2
#assert x.__dict__["__v3"]  == 3 # KeyError: '__v3'
assert x.__dict__["_A__v3"] == 3
assert x.__dict__["_A__v4"] == 4
#assert x.__dict__["v5"]    == 5 # KeyError: '__v5'

y = A()
y.f()

x.v5 = 5
assert     hasattr(x, "v5")
assert not hasattr(y, "v5")
assert x.v5             == 5
assert x.__dict__["v5"] == 5

x.__dict__.pop("v5")
assert not hasattr(x, "v5")

#assert A.v1 == 1 # AttributeError: type object 'A' has no attribute 'v1'

print "Done."
