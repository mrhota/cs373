#!/usr/bin/env python

# --------
# Lists.py
# --------

print "Lists.py"

a = [2, 3, "abc"]
assert type(a) ==     list
assert a       ==     [2, 3, 'abc']
assert a       is not [2, 3, 'abc']
assert a       !=     [3, 2, 'abc']
assert a       !=     (2, 3, 'abc')

a = (2, 3, "abc")
assert type(a) is     tuple
assert a       ==     (2, 3, 'abc')
assert a       is not (2, 3, 'abc')
assert a       !=     (3, 2, 'abc')
assert a       !=     [2, 3, 'abc']

a = list({2 : "ghi", 3.45 : 3, "abc" : 6.78})
assert type(a) ==     list
assert a == [2, "abc", 3.45]

a = tuple({2 : "ghi", 3.45 : 3, "abc" : 6.78})
assert type(a) is     tuple
assert a == (2, "abc", 3.45)

assert [] ==     []
assert [] is not []
assert () is     ()

a = [2, 3, 4];
b = list(a)
assert a ==     b
assert a is not b

a = (2, 3, 4)
b = tuple(a)
assert a is b

a = [2, 3, 4];
b = a[:]                  # a copy
assert b ==     [2, 3, 4]
assert a is not b

a = (2, 3, 4)
b = a[:]      # not a copy
assert a is b

a = [2, 3, 4]
b = a
assert a is b
a += [5]                 # mutable
assert a == [2, 3, 4, 5]
assert a is b

a = (2, 3, 4)
b = a
assert a is b
a += (5,)                # immutable
assert a == (2, 3, 4, 5)
assert b == (2, 3, 4)

a    = [1, 3, 5, 7, 9]      # lists only
a[2] = 0
assert a == [1, 3, 0, 7, 9]

a       = [1, 3, 5, 7, 9]
#a[1:4] = 0                 # TypeError: can only assign an iterable
a[1:4]  = [0, 0, 0]
assert a == [1, 0, 0, 0, 9]

a      = [1, 3, 5, 7, 9]
a[1:4] = [0, 0]          # shrink
assert a == [1, 0, 0, 9]

a      = [1, 3, 5, 7, 9]
a[1:4] = [0, 0, 0, 0]          # expand
assert a == [1, 0, 0, 0, 0, 9]

a         = [1, 3, 5, 7, 9]
#a[1:4:2] = [0]             # ValueError: attempt to assign sequence of size 1 to extended slice of size 2
#a[1:4:2] = [0, 0, 0]       # ValueError: attempt to assign sequence of size 3 to extended slice of size 2
a[1:4:2]  = [0, 0]
assert a == [1, 0, 5, 0, 9]

a = [2, 3, 4]
b = a
a.reverse()
assert a == [4, 3, 2]
assert b == [4, 3, 2]
assert a is b

print "Done."
