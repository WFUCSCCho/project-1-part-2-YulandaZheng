/****************************************************************************
 @file: Parser.java
 @description: This program implements the Parser class which reads in the file and sorts it into a BST tree
 @author: Yulanda Zheng
 @date: September 26 , 2024
 ****************************************************************************/

import java.io.*;
import java.util.Scanner;

public class Parser {
    Scanner scnr;
    // Create a BST tree of your class type (Note: Replace "Object" with your class type)
    private BST<Cat> mybst = new BST<>();
    private Cat kitty;

    public Parser(String filename) throws FileNotFoundException {
        process(new File(filename));
    }

    // Implement the process method
    // Remove redundant spaces for each input command
    public void process(File input) throws FileNotFoundException {
        scnr = new Scanner(input);
        scnr.nextLine(); //skips first line as it has just description

        while(scnr.hasNextLine()) {
            String[] line = scnr.nextLine().split(",");
            //call operate_BST method;
            operate_BST(line);
        }

        //print out entire tree at the end
        writeToFile("\nThe BST Tree printed out:", "./result.txt");
        writeToFile(mybst.print(), "./result.txt");

    }

    // Implement the operate_BST method
    // Determine the incoming command and operate on the BST
    public void operate_BST(String[] command) {

        //loop to create new cat object and fill parameters
        for(int i = 0; i < command.length; i++) {
            kitty = new Cat(command[0], Integer.parseInt(command[1]), Integer.parseInt(command[2]),command[3],command[4]);
        }
        //adds to the tree
        mybst.insert(kitty);

        //writes to file that a new kitty has been added
        writeToFile("A " + kitty.toString() + "has been added.", "./result.txt");
    }

    // Implement the writeToFile method
    // Generate the result file
    public void writeToFile(String content, String filePath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath,true  ))){

            pw.println(content);

        } catch (IOException e) {
            System.out.println("Error writing to file");

        }
    }
}
