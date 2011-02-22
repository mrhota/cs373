#!/usr/bin/env python

# --------------
# InputOutput.py
# --------------

import sys
import types

print "Enter: "

assert type(sys)       is types.ModuleType
assert type(sys.stdin) is file

s = sys.stdin.readline()
assert type(s) is str

print s, # trailing "," avoids a newline

"""
Enter:
abc
abc
"""
