#!/usr/bin/env python

# ----------
# Builder.py
# ----------

# http://en.wikipedia.org/wiki/Builder_pattern

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

class MazeBuilder (object) :
    def __init__ (self) :
        self.__maze = Maze()

    def build_room (self) :
        self.__maze.add_room(Room())

    def build_door (self, r, s) :
        self.__maze.add_door(Door(r, s))

    def maze (self) :
        return self.__maze

class EnchantedMazeBuilder (MazeBuilder) :                # object?
    def __init__ (self) :
        MazeBuilder.__init__(self)

    def build_room (self) :
        self._MazeBuilder__maze.add_room(EnchantedRoom())

    def build_door (self, r, s) :
        self._MazeBuilder__maze.add_door(EnchantedDoor(r, s))

def create_maze (mb) :
    mb.build_room()
    mb.build_room()
    mb.build_room()
    mb.build_door(mb.maze().room(0), mb.maze().room(1))
    mb.build_door(mb.maze().room(1), mb.maze().room(2))
    return mb.maze()

print "Builder.py"

mb = MazeBuilder()
m  = create_maze(mb)
assert type(mb)        is MazeBuilder
assert type(m)         is Maze
assert type(m.room(0)) is Room
assert type(m.door(0)) is Door

mb = EnchantedMazeBuilder()
m  = create_maze(mb)
assert type(mb)        is EnchantedMazeBuilder
assert type(m)         is Maze
assert type(m.room(0)) is EnchantedRoom
assert type(m.door(0)) is EnchantedDoor

print "Done."
