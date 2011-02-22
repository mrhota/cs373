#!/usr/bin/env python

# --------------
# CommandLine.py
# --------------

"""
% CommandLine.py Nothing to be done.
"""

import sys
import types

print "CommandLine.py"

a = ["./CommandLine.py", "Nothing", "to", "be", "done."]
assert type(a) is list

assert type(sys)   is types.ModuleType
assert type(types) is types.ModuleType

assert type(sys.argv) is list
assert sys.argv       == a

print "Done."
