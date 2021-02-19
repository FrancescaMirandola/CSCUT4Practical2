import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
/*
* Class where the actual action takes place
* Right now it's set to take user inputs as args
* The version where you manually pass args can be found below the code
* Flags:
* -s : simple format for names without middle names
* -c : format all names without middle names in capital letters
* -m : format a file with names with also middle names
* -mc : format a file with names with also middle names in capital letters
 */
public class FilesInOut extends FileFormatting {

    public FilesInOut(String s) {
        super(s);
    }  //subclass of FileFormatting

    public static void main(String[] args) throws FileNotFoundException, ParseException {

        if (args[0].equals("-s")) {                                       //if flag -s is passed
            File filesIn = getCheckInput();                               //store the file given by the user, scanned and checked by getCheckInput
            String filesOut = simpleFormatting(filesIn);                  //store the file after it's been formatted
            PrintWriter printWriter = getCheckOutput();  //create a printWriter object with the name of the file to use as the destination
            printWriter.write(filesOut);                                  //write the file with the formatted text
            System.out.println(filesOut);                                 //print on the console the formatted text
            printWriter.close();                                          //close the stream and release any system resources associated with it
        }
        if (args[0].equals("-c")){
            File filesIn = getCheckInput();
            String filesOutCapital = simpleFormatting(filesIn);
            PrintWriter printWriter = getCheckOutput();
            printWriter.format("%S", filesOutCapital);                     //write and format the file with the formatted text
            System.out.printf("%S", filesOutCapital);
            printWriter.close();
        }
        if (args[0].equals("-m")){
            File filesIn = getCheckInput();
            String filesOut = advancedFormatting(filesIn);
            PrintWriter printWriter = getCheckOutput();
            printWriter.write(filesOut);
            System.out.println(filesOut);
            printWriter.close();
        }
        if(args[0].equals("-mc")){
            File filesIn = getCheckInput();
            String filesOut = advancedFormatting(filesIn);
            PrintWriter printWriter = getCheckOutput();
            printWriter.format("%S",filesOut);                              //write and format the file with the formatted text
            System.out.printf("%S",filesOut);
            printWriter.close();
        }
    }// main

}// FilesInOut

/*
*  Version where you manually pass args
*/

//        if (args[0].equals("-s")) {                                   //if flag -s is passed
//            File fileIn = new File(args[1]);                          //create a File object with the given file as args[1]
//            Scanner inFile = new Scanner(fileIn);                     //scan the file; throw exception if the file is not found
//            String filesOut = simpleFormatting(fileIn);               //store the file after it's been formatted
//            PrintWriter printWriter = new PrintWriter(args[2]);       //create a printWriter object with the file given as args[2] as destination
//            printWriter.write(filesOut);                              //write the file with the formatted text
//            System.out.println(filesOut);                             //print on the console the formatted text
//            printWriter.close();                                      //close the stream and release any system resources associated with it
//        }
//        if (args[0].equals("-c")) {
//            File fileIn = new File(args[1]);
//            Scanner inFile = new Scanner(fileIn);
//            String filesOutCapital = simpleFormatting(fileIn);
//            PrintWriter printWriter = new PrintWriter(args[2]);
//            printWriter.format("%S", filesOutCapital);                //write and format the file with the formatted text
//            System.out.printf("%S", filesOutCapital);
//            printWriter.close();
//        }
//        if (args[0].equals("-m")) {
//            File fileIn = new File(args[1]);
//            Scanner inFile = new Scanner(fileIn);
//            String filesOut = advancedFormatting(fileIn);
//            PrintWriter printWriter = new PrintWriter(args[2]);
//            printWriter.write(filesOut);
//            System.out.println(filesOut);
//            printWriter.close();
//        }
//        if (args[0].equals("-mc")) {
//            File fileIn = new File(args[1]);
//            Scanner inFile = new Scanner(fileIn);
//            String filesOut = advancedFormatting(fileIn);
//            PrintWriter printWriter = new PrintWriter(args[2]);
//            printWriter.format("%S", filesOut);                        //write and format the file with the formatted text
//            System.out.printf("%S", filesOut);
//            printWriter.close();
//        }
//    }
//}





