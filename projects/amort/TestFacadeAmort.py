# -----------------------------------
# TestFacadeAmort.py
# Thin facade to support automated testing of Amort
# Last changed: 03/09/11 by Alex Loh
# -----------------------------------

# Imports
#import your_major_functions from your_modules

# NOTE: You should return a negative number if the payment reduces the future value, ie paying off your loans.
# Positive payments will result in an increase in future value, eg investing in something.

def grade_calculate_ammortization(
    interest_rate, num_payments,
    present_val = None,
    future_val = None,
    payment_amt = None):
"""
I will call this function with two of the three arguments.
It should return the missing optional argument.
"""

def grade_calculate_table(
    row_number, interest_rate, num_payments,
    present_val = None,
    future_val = None, 
    payment_amt = None):
"""
I will call this function with two or three of the arguments.
Return a dictionary that corresponds to the row in the table.
Row n is essentially the n-th payment you are making.
The dictionary
should have the following keys:
    payment_number,
    balance_before,
    total_interest,
    payment,
    total_payment,
    principal,
    total_principal,
    balance_after
"""
