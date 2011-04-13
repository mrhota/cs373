#!/usr/bin/env python

# --------------
# Inheritance.py
# --------------

print "Inheritance.py"

class Shape (object) :
    def __init__ (self, x, y) :
        self.x = x
        self.y = y

    def area (self) :
        return 0

    def move (self, x, y) :
        self.x = x
        self.y = y

    def __str__ (self) :
        return str(self.x) + ", " + str(self.y)

class Circle (Shape) :
    def __init__ (self, x, y, r) :
        super(Circle, self).__init__(x, y) # doesn't mention Shape
#       Shape.__init__(self, x, y)
        self.r = r

    def area (self) :
        return 3.14 * self.r * self.r

    def radius (self) :
        return self.r

    def __str__ (self) :
        return "(" + Shape.__str__(self) + ", " + str(self.r) + ")"

class PseudoCircle (Shape) :
    def __init__ (self, r) :
        self.r = r

x = Shape(2, 3)
assert x.area()         == 0
x.move(5, 6)
#assert x.radius()       == 0     # AttributeError: 'Shape' object has no attribute 'radius'
#assert Circle.radius(x) == 0     # TypeError: unbound method radius() must be called with Circle instance as first argument (got Shape instance instead)
assert str(x)           == "5, 6"

x = Circle(2, 3, 4)
assert x.area()     == 3.14 * 4 * 4
x.move(5, 6)
assert x.radius()   == 4
assert str(x)       == "(5, 6, 4)"

t = (Shape(2, 3), Circle(2, 3, 4))
assert t[0].area() == 0
assert t[1].area() == 3.14 * 4 * 4

x = PseudoCircle(4)
#assert str(x) == "5, 6" # AttributeError: 'PseudoCircle' object has no attribute 'x'
x.move(5, 6)
assert str(x)  == "5, 6"

print "Done."
