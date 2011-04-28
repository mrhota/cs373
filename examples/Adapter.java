// ------------
// Adapter.java
// ------------

// http://en.wikipedia.org/wiki/Adapter_pattern

import java.util.ArrayList;

class Stack<T> {
    private ArrayList<T> _al;

    public Stack () {
        _al = new ArrayList<T>();}

    public void push (T v) {
        _al.add(v);}

    public void pop () {
        _al.remove(_al.size() - 1);}

    public T top () {
        return _al.get(_al.size() - 1);}}

final class Adapter {
    public static void main (String[] args) {
        System.out.println("Adapter.java");

        Stack<Integer> s = new Stack<Integer>();
        s.push(2);
        s.push(3);
        s.push(4);
        assert s.top() == 4;
        s.pop();
        assert s.top() == 3;

        System.out.println("Done.");}}
