import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

//class where method implementations are stored
public class FileFormatting  {
    public FileFormatting(String s) {
    }

    public static void main(String[] args) throws FileNotFoundException, ParseException {

    }// main

    /*
    * getCheckInput
     * gets,checks and returns an input file
     * return File
     *  */
    public static File getCheckInput() {
        System.out.println("supply filename for input:");            //print message to console
        Scanner in = new Scanner(System.in);                         //initialize scanner to read user's inputs
        try {
            String fileNameInput = in.nextLine();                    //read and store the input which should be a file already existing
            File inputFile = new File(fileNameInput);                //create a File object with the given file as a path
                Scanner inFile = new Scanner(inputFile);             //scan the file; if file doesn't exist --> IOException
                inFile.next();                                       //check if the file is not empty (if it is --> NoSuchElementException)
                return inputFile;
        }
            catch (IOException e) {
            System.err.println("IOException: " + e.getMessage()
                    + "The file doesn't exist");
                System.exit(0);
        }
        catch (NoSuchElementException e) {
            System.err.println("NoSuchElementException" + e.getMessage()+ "The file chosen is empty");
            System.exit(0);
        }
        return null;
    }

    /*
    *getCheckOutput
    * gets,checks and returns an output file
    * return String
     */
        public static PrintWriter getCheckOutput(){
        System.out.println("supply filename for output:");               //print message to console
            Scanner in = new Scanner(System.in);                         //initialize scanner to read user's inputs
        try {
            String fileNameOutput = in.nextLine();                       //read and store the input which should be a file already existing
            PrintWriter printWriter = new PrintWriter(fileNameOutput);   //create a new PrintWriter with the specified file name (if file is not found --> FileNotFoundException)
            return printWriter;                                          //return the object with the input
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage() + " not openable");
            System.exit(0);
        }
       return null;
    }
/*
*simpleFormatting (File file)
* formats a file with name, surname and date of birth
*  e.g. annie bowdel 12032000 to Annie Bowdel 12-03-2000
* return String
* */
    public static String simpleFormatting (File file) throws FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(file);            //scan the given file
        String filesOut = "";                           //initialise an empty string that later will contain the file content
        while (scanner.hasNextLine()) {                 //while the file has a new line to format
            String a = scanner.next();                  //get the first element (name)
            String b = scanner.next();                  //get the second element (surname)
            String c = scanner.next();                  //get the third element (date)
            a = a.substring(0, 1).toUpperCase() + a.substring(1);                            // format first element with initial capital letter
            b = b.substring(0, 1).toUpperCase() + b.substring(1);                            // format second element with initial capital letter
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("ddMMyyyy");      //construct a SimpleDateFormat with the given string pattern
            Date date = simpleDateFormat.parse(c);                                           //create a Date object with the given string with its pattern
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");  //construct a SimpleDateFormat with the right pattern
            c = simpleDateFormat1.format(date);                                              //format c with the right pattern
            String tempFilesOut = a + " " + b + " " + c;                                     //adding the new line to a temporary variable
            filesOut = filesOut + tempFilesOut + "\n";                                       //adding the new line to the actual formatted content
        }
        scanner.close();        //close the scanner
        return filesOut;        //return the file content
    }
    /*
    * advancedFormatting(File file)
    * formats a file with name, middle name and surname and date of birth from
    *  e.g. annie m bowdel 12032000 to Annie M. Bowdel 12-03-2000
    * return String
    * */
    public static String advancedFormatting (File file) throws FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(file);                              //scan the given file
        String filesOut = "";                                             //initialise an empty string that later will contain the file content
        while (scanner.hasNextLine()) {                                   //while the file has a new line to format
            String[] words = scanner.nextLine().split("\\s+");      //create an array with the scanned line split at each white space
            int numberOfWords = words.length;                             //get the length of the array
            if (numberOfWords > 3) {                                      //if there's more than 3 elements it means that there's a middle name
                String a = words[0];                                      // store the name (index 0) in variable a
                String b = words[1];                                      // store the middle name (index 1) in variable b
                String c = words[2];                                      // store the surname (index 2) in variable c
                String d = words[3];                                      // store the date (index 3) in variable d
                a = a.substring(0, 1).toUpperCase() + a.substring(1);     // format with initial capital letter
                b = b.toUpperCase() + ".";                                // format with initial capital letter and a full stop
                c = c.substring(0, 1).toUpperCase() + c.substring(1);     // format initial capital letter
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("ddMMyyyy");       //construct a SimpleDateFormat with the given string pattern
                Date date = simpleDateFormat.parse(d);                                            //create a Date object with the given string with its pattern
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");   //construct a SimpleDateFormat with the right pattern
                d = simpleDateFormat1.format(date);                                               //format c with the right pattern
                String tempfilesOut = a + " " + b + " " + c + " " + d;                            //adding the new line to a temporary variable
                filesOut = filesOut + tempfilesOut + "\n";                                        //adding the new line to the actual formatted content
            } else {                        //otherwise do the same, but skip the middle name storing and formatting
                String a = words[0];
                String b = words[1];
                String c = words[2];
                a = a.substring(0, 1).toUpperCase() + a.substring(1);
                b = b.substring(0, 1).toUpperCase() + b.substring(1);
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("ddMMyyyy");
                Date date = simpleDateFormat.parse(c);
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
                c = simpleDateFormat1.format(date);
                String tempfilesOut = a + " " + b + " " + c;
                filesOut = filesOut + tempfilesOut + "\n";
            }
        }
        scanner.close();                 //close the scanner
        return filesOut;                 //return the file content
    }

}// FilesInOut







