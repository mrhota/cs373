// ------------
// Builder.java
// ------------

// http://en.wikipedia.org/wiki/Builder_pattern

import java.util.ArrayList;
import java.util.List;

class Room {}
class EnchantedRoom extends Room {}

class Door {
    private Room _r;
    private Room _s;

    public Door (Room r, Room s) {
        _r = r;
        _s = s;}}

class EnchantedDoor extends Door {
    public EnchantedDoor (Room r, Room s) {
        super(r, s);}}

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

class MazeBuilder {
    protected Maze _maze;

    public MazeBuilder () {
        _maze = new Maze();}

    public void buildRoom () {
        _maze.addRoom(new Room());}

    public void buildDoor (Room r, Room s) {
        _maze.addDoor(new Door(r, s));}

    public Maze maze () {
        return _maze;}}

class EnchantedMazeBuilder extends MazeBuilder {
    public void buildRoom () {
        _maze.addRoom(new EnchantedRoom());}

    public void buildDoor (Room r, Room s) {
        _maze.addDoor(new EnchantedDoor(r, s));}}

abstract class Game {
    public static Maze createMaze (MazeBuilder mb) {
        mb.buildRoom();
        mb.buildRoom();
        mb.buildRoom();
        mb.buildDoor(mb.maze().room(0), mb.maze().room(1));
        mb.buildDoor(mb.maze().room(1), mb.maze().room(2));
        return mb.maze();}}

final class Builder {
    public static void main (String[] args) {
        System.out.println("Builder.java");

        {
        MazeBuilder mb = new MazeBuilder();
        Maze        m  = Game.createMaze(mb);
        assert mb.getClass()        == MazeBuilder.class;
        assert m.getClass()         == Maze.class;
        assert m.room(0).getClass() == Room.class;
        assert m.door(0).getClass() == Door.class;
        }

        {
        MazeBuilder mb = new EnchantedMazeBuilder();
        Maze        m  = Game.createMaze(mb);
        assert mb.getClass()        == EnchantedMazeBuilder.class;
        assert m.getClass()         == Maze.class;
        assert m.room(0).getClass() == EnchantedRoom.class;
        assert m.door(0).getClass() == EnchantedDoor.class;
        }

        System.out.println("Done.");}}
