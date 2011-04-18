// ------------
// Store10.java
// ------------

/*
javac -Xlint Store10.java
java  -ea    Store10
*/

/*
Create BinaryFunction
Create Functional.reduce()
Use    Class.forName()
*/

import java.util.Enumeration;
import java.util.Vector;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

interface Price {
    double getCharge               (int daysRented);
    int    getFrequentRenterPoints (int daysRented);}

class RegularPrice implements Price {
    public RegularPrice ()
        {}

    public double getCharge (int daysRented) { // const
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;}

    public int getFrequentRenterPoints (int daysRented) { // const
        return 1;}}

class NewReleasePrice implements Price {
    public NewReleasePrice ()
        {}

    public double getCharge (int daysRented) { // const
        return daysRented * 3;}

    public int getFrequentRenterPoints (int daysRented) { // const
        return (daysRented > 1) ? 2 : 1;}}

class ChildrensPrice implements Price {
    public ChildrensPrice ()
        {}

    public double getCharge (int daysRented) { // const
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;}

    public int getFrequentRenterPoints (int daysRented) { // const
        return 1;}}

class Movie {
    private String _title;
    private Price  _price;

    public Movie (String title, String price) {
        _title = title;
        try {
            _price = (Price) Class.forName(price).newInstance();}
        catch (ClassNotFoundException e) {
            e.printStackTrace();}
        catch (IllegalAccessException e) {
            e.printStackTrace();}
        catch (InstantiationException e) {
            e.printStackTrace();}}

    /**
     * _price
     *     getCharge()
     */
    public double getCharge (int daysRented) { // const
        return _price.getCharge(daysRented);}

    /**
     * _price
     *     getFrequentRenterPoints()
     */
    public int getFrequentRenterPoints (int daysRented) { // const
        return _price.getFrequentRenterPoints(daysRented);}

    public void setPrice (Price price) {
        _price = price;}

    public String statement (int daysRented) { // const
        return
            "\t" + _title                                +
            "\t" + String.valueOf(getCharge(daysRented)) + "\n";}}

class Rental {
    private Movie _movie;
    private int   _daysRented;

    public Rental (Movie movie, int daysRented) {
        _movie      = movie;
        _daysRented = daysRented;}

    /**
     * _movie
     *     getCharge()
     */
    public double getCharge () { // const
        return _movie.getCharge(_daysRented);}

    /**
     * _movie
     *     getFrequentRenterPoints()
     */
    public int getFrequentRenterPoints () { // const
        return _movie.getFrequentRenterPoints(_daysRented);}

    public String statement () { // const
        return _movie.statement(_daysRented);}}

interface BinaryFunction<R, T> {
    public R call (R x, T y);}

class Functional {
    public static <R, T> R reduce (
            BinaryFunction<R, T> bf,
            Iterable<T>           x,
            R                     v) {
        for (T w : x)
            v = bf.call(v, w);
        return v;}}

class Customer {
    private String         _name;
    private Vector<Rental> _rentals = new Vector<Rental>();

    public Customer (String name) {
        _name = name;}

    public void addRental (Rental rental) {
        _rentals.addElement(rental);}

    public String getName () { // const
        return _name;}

    /**
     * _rentals
     *     statement()
     *     getCharge()
     *     getFrequentRenterPoints()
     */
    public String statement () { // O(3n)
        String result =
            Functional.reduce(
                new BinaryFunction<String, Rental> () {
                        public String call (String statement, Rental rental) {
                            return statement + rental.statement();}},
                _rentals,
                "Rental Record for " + getName() + "\n");
        result +=
            "Amount owed is " +
            String.valueOf(
                Functional.reduce(
                    new BinaryFunction<Double, Rental> () {
                            public Double call (Double charge, Rental rental) {
                                return charge + rental.getCharge();}},
                    _rentals,
                    new Double(0))) +
             "\n";
        result +=
            "You earned " +
            String.valueOf(
                Functional.reduce(
                    new BinaryFunction<Integer, Rental> () {
                            public Integer call (Integer points, Rental rental) {
                                return points + rental.getFrequentRenterPoints();}},
                    _rentals,
                    new Integer(0))) +
            " frequent renter points";
        return result;}}

final class Store10 {
    public static void main (String[] args) {
        System.out.println("Store10.java");
        TestRunner.run(new TestSuite(TestStore4.class));
        System.out.println("Done.");}}
