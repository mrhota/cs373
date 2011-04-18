#!/usr/bin/env python

# ----------
# Store10.py
# ----------

import operator

print "Store10.py"

class RegularPrice (object) :
    def get_charge (self, days_rented) :
        result = 2
        if days_rented > 2 :
            result += (days_rented - 2) * 1.5
        return result

    def get_points (self, days_rented) :
        return 1

class NewReleasePrice (object) :
    def get_charge (self, days_rented) :
        return days_rented * 3

    def get_points (self, days_rented) :
        return 2 if (daysRented > 1) else 1

class ChildrensPrice (object) :
    def get_charge (self, days_rented) :
        result = 1.5
        if days_rented > 3 :
            result += (days_rented - 3) * 1.5
        return result

    def get_points (self, days_rented) :
        return 1

class Movie (object) :
    def __init__ (self, title, price) :
        self.title = title
        self.price = globals()[price]()

    def get_charge (self, days_rented) :
        return self.price.get_charge(days_rented)

    def get_points (self, days_rented) :
        return self.price.get_points(days_rented)

    def get_statement (self, days_rented) :
        return self.title + " " + str(self.get_charge(days_rented)) + "; "

class Rental (object) :
    def __init__ (self, movie, days_rented) :
        self.movie       = movie
        self.days_rented = days_rented

    def get_charge (self) :
        return self.movie.get_charge(self.days_rented)

    def get_points (self) :
        return self.movie.get_points(self.days_rented)

    def get_statement (self) :
        return self.movie.get_statement(self.days_rented)

class Customer (object) :
    def __init__ (self, name) :
        self.name    = name
        self.rentals = []

    def add_rental (self, rental) :
        self.rentals += [rental]

    def statement (self) :
        return \
            sum(map(Rental.get_charge, self.rentals)), \
            sum(map(Rental.get_points, self.rentals)), \
            "".join(map(Rental.get_statement, self.rentals))

x = Customer("Penelope")

x.add_rental(Rental(Movie("Shane",     "RegularPrice"), 2))
x.add_rental(Rental(Movie("Red River", "RegularPrice"), 5))

assert x.statement() == (8.5, 2, 'Shane 2; Red River 6.5; ')

print "Done."
