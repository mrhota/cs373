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
    assert "".join(a + a) == "abCbAabCbA"
    b  = T("abCbA")
    b += a
    assert "".join(b) == "abCbAabCbA"

    a = T("abCbA")
    assert "".join(3 * a) == "abCbAabCbAabCbA"
    b  = T("abCbA")
    b *= 3
    assert "".join(b) == "abCbAabCbAabCbA"

    a = T("abCbA")
    assert "".join(a[1:4]) == "bCb"
    assert "".join(a[1: ]) == "bCbA"
    assert "".join(a[ :4]) == "abCb"
    assert "".join(a[0:5]) == "abCbA"
    assert "".join(a[ : ]) == "abCbA"

    a = T("abCbA")
    assert "".join(a[  1: 4: 2]) == "bb"
    assert "".join(a[ -4:-1: 2]) == "bb"
    assert "".join(a[  0: 5: 2]) == "aCA"
    assert "".join(a[ -5: 5: 2]) == "aCA"
    assert "".join(a[   :  : 2]) == "aCA"
    assert "".join(a[  1: 4:-2]) == ""
    assert "".join(a[  3: 0:-2]) == "bb"
    assert "".join(a[ -2:-5:-2]) == "bb"
    assert "".join(a[  4:-6:-2]) == "ACa"
    assert "".join(a[ -1:-6:-2]) == "ACa"
    assert "".join(a[   :  :-2]) == "ACa"

def test_2 (T) :
    a = T([2, 3, 4])
    assert len(a)    == 3
    assert sum(a, 0) == 9

    a = T([[2, 3, 4], [5, 6]])
    assert len(a[0]) == 3
    assert len(a[1]) == 2

    assert sum(a, []) == [2, 3, 4, 5, 6]

test_1(str)
test_1(list)
test_1(tuple)

test_2(list)
test_2(tuple)

print "Done."
