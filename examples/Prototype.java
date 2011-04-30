// --------------
// Prototype.java
// --------------

// http://en.wikipedia.org/wiki/Prototype_pattern

import java.util.ArrayList;
import java.util.List;

/*
interface Cloneable {}

class Object {
    protected Object clone () throws CloneNotSupportedException {
        if (!(this instanceof Cloneable))
            throw new CloneNotSupportedException();
        // ...magic...
        }
*/

class Room implements Cloneable {
    public Room clone () {
        try {
            return (Room) super.clone();}
        catch (CloneNotSupportedException e) {
            return null;}}}

class EnchantedRoom extends Room {}

class Door implements Cloneable {
    private Room _r;
    private Room _s;

    public Door clone () {
        try {
            return (Door) super.clone();}
        catch (CloneNotSupportedException e) {
            return null;}}

    public void set (Room r, Room s) {
        _r = r;
        _s = s;}}

class EnchantedDoor extends Door
    {}

final class Maze {
    private List<Room> _rooms = new ArrayList<Room>();
    private List<Door> _doors = new ArrayList<Door>();

    public void addRoom (Room r) {
        _rooms.add(r);}

    public void addDoor (Door d) {
        _doors.add(d);}

    public Room room (int i) {
        return _rooms.get(i);}

    public Door door (int i) {
        return _doors.get(i);}}

final class MazePrototype {
    private Room _room;
    private Door _door;

    public MazePrototype (Room room, Door door) {
        _room = room;
        _door = door;}

    public Room makeRoom () {
        return _room.clone();}

    public Door makeDoor (Room r, Room s) {
        Door d = _door.clone();
        d.set(r, s);
        return d;}}

abstract class Game {
    public static Maze createMaze (MazePrototype mp) {
        Maze m = new Maze();
        m.addRoom(mp.makeRoom());
        m.addRoom(mp.makeRoom());
        m.addRoom(mp.makeRoom());
        m.addDoor(mp.makeDoor(m.room(0), m.room(1)));
        m.addDoor(mp.makeDoor(m.room(1), m.room(2)));
        return m;}}

final class Prototype {
    public static void main (String[] args) {
        System.out.println("Prototype.java");

        {
        MazePrototype mp = new MazePrototype(new Room(), new Door());
        Maze          m  = Game.createMaze(mp);
        assert mp.getClass()        == MazePrototype.class;
        assert m.getClass()         == Maze.class;
        assert m.room(0).getClass() == Room.class;
        assert m.door(0).getClass() == Door.class;
        }

        {
        MazePrototype mp = new MazePrototype(new EnchantedRoom(), new EnchantedDoor());
        Maze          m  = Game.createMaze(mp);
        assert mp.getClass()        == MazePrototype.class;
        assert m.getClass()         == Maze.class;
        assert m.room(0).getClass() == EnchantedRoom.class;
        assert m.door(0).getClass() == EnchantedDoor.class;
        }

        System.out.println("Done.");}}
