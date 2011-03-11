// --------------
// Iterators.java
// --------------

import java.util.ArrayList;
import java.util.Iterator;

final class MyArrayList<T> {
    private ArrayList<T> _x;

    private final class MyIterator implements Iterator<T> {
        Iterator<T> _i;

        public MyIterator () {
            _i = _x.iterator();}

        public boolean hasNext () {
            return _i.hasNext();}

        public T next () {
            return _i.next();}

        public void remove () {
            _i.remove();}}

    public MyArrayList () {
        _x = new ArrayList<T>();}

    public void add (T v) {
        _x.add(v);}

    public Iterator<T> iterator () {
        return new MyIterator();}}

final class Iterators {
    public static void main (String[] args) {
        System.out.println("Iterators.java");

        {
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(2);
        x.add(3);
        Iterator<Integer> p = x.iterator();
        assert  p.hasNext();
        assert  p.next() == 2;
        assert  p.hasNext();
        assert  p.next() == 3;
        assert !p.hasNext();
        }

        {
        MyArrayList<Integer> x = new MyArrayList<Integer>();
        x.add(2);
        x.add(3);
        Iterator<Integer> p = x.iterator();
        assert  p.hasNext();
        assert  p.next() == 2;
        assert  p.hasNext();
        assert  p.next() == 3;
        assert !p.hasNext();
        }

        System.out.println("Done.");}}
