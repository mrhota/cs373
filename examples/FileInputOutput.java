// --------------------
// FileInputOutput.java
// --------------------

/*
% java -ea FileInputOutput FileInputOutput.java
*/

import java.io.File;
import java.io.IOException;

import java.util.Scanner;

final class FileInputOutput {
    public static void main (String[] args) {
        try {
            final File    f = new File(args[0]);
            final Scanner s = new Scanner(f);
            while (s.hasNextLine())
                System.out.println(s.nextLine());
            }
        catch (IOException e) {
            e.printStackTrace();}}}
