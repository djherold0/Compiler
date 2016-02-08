/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.util.Scanner;

/**
 * This is my compiler! Written in Java.
 *
 * @author Dan Herold
 * @version 2014.5.14
 */
public class Compiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fName = scan.next();
        Parser p = new Parser(fName);
        boolean worked = p.parse();
        if (worked) {
            System.out.println("Input file parsed with no problems. Check output file.");
            return;
        }
        System.out.println("There was a problem parsing input file.");
    }
}
