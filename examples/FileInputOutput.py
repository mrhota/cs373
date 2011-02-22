#!/usr/bin/env python

# ------------------
# FileInputOutput.py
# ------------------

"""
% FileInputOutput.py FileInputOutput.py
"""

import sys

f = open(sys.argv[1])
assert type(f) is file

for s in f :
    assert type(s) is str
    print s,              # trailing "," avoids a newline
