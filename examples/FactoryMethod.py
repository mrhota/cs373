#!/usr/bin/env python

# ----------------
# FactoryMethod.py
# ----------------

# http://en.wikipedia.org/wiki/Factory_method_pattern

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

class Game (object) :
    def create_maze (self) :
        m = Maze();
        m.add_room(self.make_room())
        m.add_room(self.make_room())
        m.add_room(self.make_room())
        m.add_door(self.make_door(m.room(0), m.room(1)))
        m.add_door(self.make_door(m.room(1), m.room(2)))
        return m

    def make_room (self) :
        return Room()

    def make_door (self, r, s) :
        return Door(r, s)

class EnchantedGame (Game) :
    def make_room (self) :
        return EnchantedRoom()

    def make_door (self, r, s) :
        return EnchantedDoor(r, s)

print "FactoryMethod.py"

g = Game()
m = g.create_maze()
assert type(g)         is Game
assert type(m)         is Maze
assert type(m.room(0)) is Room
assert type(m.door(0)) is Door

g = EnchantedGame()
m = g.create_maze()
assert type(g)         is EnchantedGame
assert type(m)         is Maze
assert type(m.room(0)) is EnchantedRoom
assert type(m.door(0)) is EnchantedDoor

print "Done."
