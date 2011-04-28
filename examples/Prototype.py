#!/usr/bin/env python

# ------------
# Prototype.py
# ------------

# http://en.wikipedia.org/wiki/Prototype_pattern

import copy

class Room (object) :
    pass

class EnchantedRoom (Room) :
    pass

class Door (object) :
    def set (self, r, s) :
        self.__r = r
        self.__s = s

class EnchantedDoor (Door) :
    pass

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

class MazePrototype (object) :
    def __init__ (self, room, door) :
        self.__room = room
        self.__door = door

    def make_room (self) :
        return copy.copy(self.__room)

    def make_door (self, r, s) :
        d = copy.copy(self.__door)
        d.set(r, s)
        return d

def create_maze (mp) :
    m = Maze()
    m.add_room(mp.make_room())
    m.add_room(mp.make_room())
    m.add_room(mp.make_room())
    m.add_door(mp.make_door(m.room(0), m.room(1)))
    m.add_door(mp.make_door(m.room(1), m.room(2)))
    return m

print "Prototype.py"

mp = MazePrototype(Room(), Door())
m  = create_maze(mp)
assert type(mp)        is MazePrototype
assert type(m)         is Maze
assert type(m.room(0)) is Room
assert type(m.door(0)) is Door

mp = MazePrototype(EnchantedRoom(), EnchantedDoor())
m  = create_maze(mp)
assert type(mp)        is MazePrototype
assert type(m)         is Maze
assert type(m.room(0)) is EnchantedRoom
assert type(m.door(0)) is EnchantedDoor

print "Done."
