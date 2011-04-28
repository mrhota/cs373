#!/usr/bin/env python

# ----------
# Adapter.py
# ----------

# http://en.wikipedia.org/wiki/Adapter_pattern

print "Adapter.py"

class Stack :
    def __init__ (self) :
        self.l = []

    def push (self, v) :
        self.l.append(v)

    def pop (self) :
        self.l.pop()

    def top (self) :
        return self.l[-1]

s = Stack()
s.push(2)
s.push(3)
s.push(4)
assert s.top() == 4
s.pop()
assert s.top() == 3

print "Done."
