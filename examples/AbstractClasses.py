#!/usr/bin/env python

# ------------------
# AbstractClasses.py
# ------------------

print "AbstractClasses.py"

class AbstractShape (object) :
    def __init__ (self, x, y) :
        self.x = x
        self.y = y

    def area (self) :
        heffalump

    def move (self, x, y) :
        self.x = x
        self.y = y

    def __str__ (self) :
        return str(self.x) + ", " + str(self.y)

class Circle (AbstractShape) :
    def __init__ (self, x, y, r) :
        super(Circle, self).__init__(x, y) # doesn't mention AbstractShape
#       AbstractShape.__init__(self, x, y)
        self.r = r

    def area (self) :
        return 3.14 * self.r * self.r

    def radius (self) :
        return self.r

    def __str__ (self) :
        return "(" + AbstractShape.__str__(self) + ", " + str(self.r) + ")"

class PseudoCircle (AbstractShape) :
    def __init__ (self, r) :
        self.r = r

x = AbstractShape(2, 3)
#assert x.area()    == 0     # NameError: global name 'heffalump' is not defined
x.move(5, 6)
#assert x.radius() == 0      # AttributeError: 'AbstractShape' object has no attribute 'radius'
assert str(x)      == "5, 6"

x = Circle(2, 3, 4)
assert x.area()   == 3.14 * 4 * 4
x.move(5, 6)
assert x.radius() == 4
assert str(x)     == "(5, 6, 4)"

t = (Circle(2, 3, 4), Circle(5, 6, 7))
assert t[0].area() == 3.14 * 4 * 4
assert t[1].area() == 3.14 * 7 * 7

x = PseudoCircle(4)
#assert str(x) == "5, 6" # AttributeError: 'PseudoCircle' object has no attribute 'x'
x.move(5, 6)
assert str(x)  == "5, 6"

print "Done."
