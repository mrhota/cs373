#!/usr/bin/env python

# -------------
# Creational.py
# -------------

# http://en.wikipedia.org/wiki/Creational_pattern

class Room (object) :
    pass

class EnchantedRoom (Room) :
    pass

class Door (object) :
    def __init__ (self, r, s) :
        self.__r = r
        self.__s = s

class EnchantedDoor (Door) :
    def __init__ (self, r, s) :
    	Door.__init__(self, r, s)

class Maze (object) :
    def __init__ (self) :
        self.__rooms  = []
        self.__doors  = []

    def add_room (self, r) :
        self.__rooms += [r]

    def add_door (self, d) :
        self.__doors += [d]

    def room (self, i) :
        return self.__rooms[i]

    def door (self, i) :
        return self.__doors[i]

def create_maze () :
    m = Maze()
    m.add_room(Room())
    m.add_room(Room())
    m.add_room(Room())
    m.add_door(Door(m.room(0), m.room(1)))
    m.add_door(Door(m.room(1), m.room(2)))
    return m

def create_enchanted_maze () :
    m = Maze()
    m.add_room(EnchantedRoom())
    m.add_room(EnchantedRoom())
    m.add_room(EnchantedRoom())
    m.add_door(EnchantedDoor(m.room(0), m.room(1)))
    m.add_door(EnchantedDoor(m.room(1), m.room(2)))
    return m

print "Creational.py"

m = create_maze()
assert type(m)         is Maze
assert type(m.room(0)) is Room
assert type(m.door(0)) is Door

m = create_enchanted_maze()
assert type(m)         is Maze
assert type(m.room(0)) is EnchantedRoom
assert type(m.door(0)) is EnchantedDoor

print "Done."
