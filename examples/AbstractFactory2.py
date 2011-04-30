#!/usr/bin/env python

# ------------------
# AbstractFactory.py
# ------------------

# http://en.wikipedia.org/wiki/Abstract_factory_pattern

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
        self.__rooms = []
        self.__doors = []

    def add_room (self, r) :
        self.__rooms += [r]

    def add_door (self, d) :
        self.__doors += [d]

    def room (self, i) :
        return self.__rooms[i]

    def door (self, i) :
        return self.__doors[i]

class MazeFactory (object) :
    @staticmethod
    def make_room () :
        return Room()

    @staticmethod
    def make_door (r, s) :
        return Door(r, s)

class EnchantedMazeFactory (object) : # MazeFactory?
    @staticmethod
    def make_room () :
        return EnchantedRoom()

    @staticmethod
    def make_door (r, s) :
        return EnchantedDoor(r, s)

def create_maze (mf) :
    m = Maze()
    m.add_room(mf.make_room())
    m.add_room(mf.make_room())
    m.add_room(mf.make_room())
    m.add_door(mf.make_door(m.room(0), m.room(1)))
    m.add_door(mf.make_door(m.room(1), m.room(2)))
    return m

print "AbstractFactory2.py"

mf = MazeFactory
m  = create_maze(mf)
assert type(mf)        is type
assert type(m)         is Maze
assert type(m.room(0)) is Room
assert type(m.door(0)) is Door

mf = EnchantedMazeFactory
m  = create_maze(mf)
assert type(mf)        is type
assert type(m)         is Maze
assert type(m.room(0)) is EnchantedRoom
assert type(m.door(0)) is EnchantedDoor

print "Done."
