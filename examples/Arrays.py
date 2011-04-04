#!/usr/bin/env python

# ---------
# Arrays.py
# ---------

print "Arrays.py"

def test_1 (T) :
    assert not T()

    a = T("abCbA")
    assert len(a) == 5

    a = T("abCbA")
    assert a[2] == "C"
    try :
        assert a[5] == 0                               # index error
        assert False
    except IndexError, e :
        assert type(e.args)    is tuple
        assert len(e.args)     == 1
        assert e.args[0][-18:] == "index out of range"

    a = T("abCbA")
    assert a[-3] == "C"
    try :
        assert a[-6] == 0                              # index error
        assert False
    except IndexError, e :
        assert type(e.args)    is tuple
        assert len(e.args)     == 1
        assert e.args[0][-18:] == "index out of range"

    a = T("abCbA")
    assert "C"     in a
    assert "d" not in a

    a = T("abCbA")
    assert not (a != a)
    assert     (a == a)
    assert not (a <  a)
    assert     (a <= a)
    assert not (a >  a)
    assert     (a >= a)

    a = T("abCbA")
    assert (a + a) == T("abCbAabCbA")
    b  = T("abCbA")
    b += a
    assert (b) == T("abCbAabCbA")

    a = T("abCbA")
    assert (3 * a) == T("abCbAabCbAabCbA")
    b  = T("abCbA")
    b *= 3
    assert b == T("abCbAabCbAabCbA")

    a = T("abCbA")
    assert (a[1:4]) == T("bCb")
    assert (a[1: ]) == T("bCbA")
    assert (a[ :4]) == T("abCb")
    assert (a[0:5]) == T("abCbA")
    assert (a[ : ]) == T("abCbA")

    a = T("abCbA")
    assert (a[  1: 4: 2]) == T("bb")
    assert (a[ -4:-1: 2]) == T("bb")
    assert (a[  0: 5: 2]) == T("aCA")
    assert (a[ -5: 5: 2]) == T("aCA")
    assert (a[   :  : 2]) == T("aCA")
    assert (a[  1: 4:-2]) == T("")
    assert (a[  3: 0:-2]) == T("bb")
    assert (a[ -2:-5:-2]) == T("bb")
    assert (a[  4:-6:-2]) == T("ACa")
    assert (a[ -1:-6:-2]) == T("ACa")
    assert (a[   :  :-2]) == T("ACa")

def test_2 (T) :
    a = T([2, 3, 4])
    assert len(a)    == 3
    assert sum(a, 0) == 9

    a = T(["abc", "def", "ghi"])
    assert len(a)     == 3
#   assert sum(a, "") == "abcdefghi"; # TypeError: sum() can't sum strings [use "".join(seq) instead]

    a = T([[2, 3, 4], [5, 6]])
    assert len(a[0]) == 3
    assert len(a[1]) == 2

    assert sum(a, []) == [2, 3, 4, 5, 6]

test_1(str)
test_1(list)
test_1(tuple)

test_2(list)
test_2(tuple)

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

a = []
a.append(2)
a.append(3)
a.append(4)
assert len(a) == 3
v = a.pop(1)
assert v == 3
assert len(a) == 2
v = a.pop(1)
assert v == 4
assert len(a) == 1

a = []
a.extend([2])
a.extend((3,))
a.extend([4])
assert len(a) == 3
a.remove(2)
assert len(a) == 2
try :
    a.remove(2)
    assert False
except ValueError, e:
    assert type(e.args) is tuple
    assert len(e.args)  == 1
    assert e.args       == ('list.remove(x): x not in list',)

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
