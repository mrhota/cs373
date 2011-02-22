#!/usr/bin/env python

# ------------------------------
# projects/collatz/RunCollatz.py
# Copyright (C) 2011
# Glenn P. Downing
# -------------------------------

"""
To run the program
    % RunCollatz.py < RunCollatz.in > RunCollatz.out

To document the program
    % pydoc -w Collatz RunCollatz TestCollatz
"""

# -------
# imports
# -------

import sys

from Collatz import collatz_read, collatz_eval, collatz_print, collatz_solve

# ----
# main
# ----

collatz_solve(sys.stdin, sys.stdout)
