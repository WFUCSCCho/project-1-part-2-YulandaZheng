/****************************************************************************
 @file: Proj1.java
 @description: This program implements the Proj1 class which runs the program
 @author: Yulanda Zheng
 @date: September 26 , 2024
 ****************************************************************************/

import java.io.FileNotFoundException;

public class Proj1 {
    public static void main(String[] args) throws FileNotFoundException{
        if(args.length != 1){
            System.err.println("Argument count is invalid: " + args.length);
            System.exit(0);
        }
        new Parser(args[0]);
    }
}