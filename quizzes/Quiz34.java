/*
CS373: Quiz #34 (5 pts)
*/

/* -----------------------------------------------------------------------
1. What is a "hallway usability test"?
   [The Joel Test]
   (2 pts)

A hallway usability test is where you grab the next person that passes by
in the hallway and force them to try to use the code you just wrote. If
you do this to five people, you will learn 95% of what there is to learn
about usability problems in your code.
*/

/* -----------------------------------------------------------------------
2. Explain the FOUR exceptions in the following code.
   (2 pts)

the class can not be cast to an A
the string is not the name of a class
the constructor of A is not public or package
A is an interface or abstract class
*/

class A {}

class Quiz34 {
    public static void main (String[] args) {
        try {
            A x = (A) Class.forName("A").newInstance();}
        catch (ClassCastException e) {
            e.printStackTrace();}
        catch (ClassNotFoundException e) {
            e.printStackTrace();}
        catch (IllegalAccessException e) {
            e.printStackTrace();}
        catch (InstantiationException e) {
            e.printStackTrace();}}}
