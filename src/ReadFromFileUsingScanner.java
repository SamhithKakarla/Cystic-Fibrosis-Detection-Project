// Java Program to illustrate reading from Text File
// using Scanner Class

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFileUsingScanner {
    String output = "";


    public ReadFromFileUsingScanner(){

    }

    public static void main(String[] arges) throws FileNotFoundException {


    }

    public static String Read() throws FileNotFoundException {
        String grande = "";
        // pass the path to the file as a parameter
        File file = new File("/Users/samhith/IdeaProjects/DNAProject/src/CFTR database.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            grande = grande + sc.nextLine();

        }
        String output = grande;
        return grande;

    }

    public String getGrande(){
        return output;
    }


}


