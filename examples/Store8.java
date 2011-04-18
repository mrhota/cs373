// -----------
// Store8.java
// -----------

/*
javac -Xlint Store8.java
java  -ea    Store8
*/

/*
Change Price to an interface
Introduce eager Singleton
*/

import java.util.Enumeration;
import java.util.Vector;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

interface Price {
    double getCharge               (int daysRented);
    int    getFrequentRenterPoints (int daysRented);}

class RegularPrice implements Price {
    public static final RegularPrice only = new RegularPrice();

    private RegularPrice ()
        {}

    public double getCharge (int daysRented) { // const
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;}

    public int getFrequentRenterPoints (int daysRented) { // const
        return 1;}}

class NewReleasePrice implements Price {
    public static final NewReleasePrice only = new NewReleasePrice();

    private NewReleasePrice ()
        {}

    public double getCharge (int daysRented) { // const
        return daysRented * 3;}

    public int getFrequentRenterPoints (int daysRented) { // const
        return (daysRented > 1) ? 2 : 1;}}

class ChildrensPrice implements Price {
    public static final ChildrensPrice only = new ChildrensPrice();

    private ChildrensPrice ()
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

    public Movie (String title, Price price) {
        _title = title;
        _price = price;}

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

    public String getTitle () { // const
        return _title;}

    public void setPrice (Price price) {
        _price = price;}}

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

    public Movie getMovie () { // const
        return _movie;}}

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
     *     getCharge()
     */
    private double getTotalCharge () { // const, O(n)
        double result = 0;
        for (Rental rental : _rentals)
            result += rental.getCharge();
        return result;}

    /**
     * _rentals
     *     getFrequentRenterPoints()
     */
    private int getTotalFrequentRenterPoints () { // const, O(n)
        int result = 0;
        for (Rental rental : _rentals)
            result += rental.getFrequentRenterPoints();
        return result;}

    /**
     * _rentals
     *     getCharge()
     *     getMovie()
     *         getTitle()
     */
    public String statement () { // O(3n)
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : _rentals)
            result +=
                "\t" + rental.getMovie().getTitle()       +
                "\t" + String.valueOf(rental.getCharge()) + "\n";
        result +=
            "Amount owed is "                +
            String.valueOf(getTotalCharge()) + "\n";
        result +=
            "You earned "                                  +
            String.valueOf(getTotalFrequentRenterPoints()) +
            " frequent renter points";
        return result;}}

final class Store8 {
    public static void main (String[] args) {
        System.out.println("Store8.java");
        TestRunner.run(new TestSuite(TestStore3.class));
        System.out.println("Done.");}}
