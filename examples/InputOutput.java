// ----------------
// InputOutput.java
// ----------------

import java.util.Scanner;

final class InputOutput {
    public static void main (String[] args) {
        System.out.println("Enter: ");
        final Scanner cin = new Scanner(System.in);
        final String  s   = cin.nextLine();
        System.out.println(s);}}

/*
Enter:
abc
abc
*/
