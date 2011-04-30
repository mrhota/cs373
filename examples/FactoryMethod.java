// ------------------
// FactoryMethod.java
// ------------------

// http://en.wikipedia.org/wiki/Factory_method_pattern

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

class Game {
    public Maze createMaze () {
        Maze m = new Maze();
        m.addRoom(makeRoom());
        m.addRoom(makeRoom());
        m.addRoom(makeRoom());
        m.addDoor(makeDoor(m.room(0), m.room(1)));
        m.addDoor(makeDoor(m.room(1), m.room(2)));
        return m;}

    public Room makeRoom () {
        return new Room();}

    public Door makeDoor (Room r, Room s) {
        return new Door(r, s);}}

class EnchantedGame extends Game {
    public EnchantedRoom makeRoom () {
        return new EnchantedRoom();}

    public EnchantedDoor makeDoor (Room r, Room s) {
        return new EnchantedDoor(r, s);}}

final class FactoryMethod {
    public static void main (String[] args) {
        System.out.println("FactoryMethod.java");

        {
        Game g = new Game();
        Maze m = g.createMaze();
        assert g.getClass()         == Game.class;
        assert m.getClass()         == Maze.class;
        assert m.room(0).getClass() == Room.class;
        assert m.door(0).getClass() == Door.class;
        }

        {
        Game g = new EnchantedGame();
        Maze m = g.createMaze();
        assert g.getClass()         == EnchantedGame.class;
        assert m.getClass()         == Maze.class;
        assert m.room(0).getClass() == EnchantedRoom.class;
        assert m.door(0).getClass() == EnchantedDoor.class;
        }

        System.out.println("Done.");}}
