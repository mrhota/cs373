#!/usr/bin/env python

# ------------
# Singleton.py
# ------------

print "Singleton.py"

class only (object) :
    def f (self) :
        return "Only.f()"

only = only()

assert only     is only
assert only.f() == "Only.f()"





def EagerDecorator (c) :
    x = c()
    return lambda : x

class Eager1 (object) :
    def f (self) :
        return "Eager1.f()"

Eager1 = EagerDecorator(Eager1)

assert Eager1()     is Eager1()
assert Eager1().f() == "Eager1.f()"

@EagerDecorator
class Eager2 (object) :
    def f (self) :
        return "Eager2.f()"

assert Eager2()     is Eager2()
assert Eager2().f() == "Eager2.f()"





def LazyDecorator (c) :
    x = []
    def g () :
        if x == [] :
            x.append(c())
        return x[0]
    return g

class Lazy1 (object) :
    def f (self) :
        return "Lazy1.f()"

Lazy1 = LazyDecorator(Lazy1)

assert Lazy1()     is Lazy1()
assert Lazy1().f() == "Lazy1.f()"

@LazyDecorator
class Lazy2 (object) :
    def f (self) :
        return "Lazy2.f()"

assert Lazy2()     is Lazy2()
assert Lazy2().f() == "Lazy2.f()"





class Borg (object) :
    __d = {}

    def __init__ (self):
        self.__dict__ = self.__d

    def f (self) :
        return "Borg.f()"

assert Borg()          is not Borg()
assert Borg().__dict__ is     Borg ().__dict__
assert Borg().f()      ==     "Borg.f()"

print "Done."
