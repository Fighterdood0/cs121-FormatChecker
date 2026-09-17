import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**Check the format of given files.
 * IF there is an exception, invalid format.
 * Catch every exception.
 * 
 * @author Zach Jessup CS221
 * @date Fall 2026
 */
public class FormatChecker{
    public static void main(String[] args) {
        /**This if statement is very important.
         * Declares Usage of this file if there is no arguements.
         */
        if(args.length < 1){
            System.out.println("Usage: $java FormatChecker file1 [file2 ... fileN]");
            return;
        }
        File file;
        Scanner scnr;
        for(int i = 0; i < args.length; i++){//reads through the file using scnr
            try {//try with multiple catch statements for exceptions
                file = new File(args[i]);
                scnr = new Scanner(file);
                final String DELIMITER = " ";
                int rows = Integer.parseInt(scnr.next());
                int cols = Integer.parseInt(scnr.next());
                int rowCount = 0;
                double[][] array = new double[rows][cols];//known bug is invalid2.dat succeeds. I thought making this final would fix that but it did not
                for(int j = 0; j<array.length; j++){//creates 2D array of doubles with file contents.
                    Scanner lineScan = new Scanner(scnr.nextLine());
                    lineScan.useDelimiter(DELIMITER);
                    for(int k = 0; k<array[j].length; k++){
                        array[j][k] = Double.parseDouble(lineScan.next());
                    }
                    lineScan.close();
                }
                if(!scnr.hasNext()){//if there is extra nubmers in the file, this will throw an exception.
                System.out.println(file.getName() + "\nVALID");
                System.out.println();
                }else{
                    scnr.close();
                    throw new InputMismatchException();
                }           
                scnr.close();
            } catch (FileNotFoundException e) {//catches if the file doesn't exist
                System.out.println(args[i]);
                System.out.println(e.toString());
                System.out.println("INVALID");
                System.out.println();
            } catch (InputMismatchException e) {//catches if the file has the wrong inputs
                System.out.println(args[i]);
                System.out.println(e.toString() + ": Mismatching input");
                System.out.println("INVALID");
                System.out.println();
            } catch (NumberFormatException e) {//catches if there is an input in wrong format
                System.out.println(args[i]);
                System.out.println(e.toString() + ": Input is not a number");
                System.out.println("INVALID");
                System.out.println();
            } catch (Exception e) {//This catches EVERY exception just in case. Catches NoSuhElements
                System.out.println(args[i]);
                System.out.println("There was an exception: " + e.toString());
                System.out.println("INVALID");
                System.out.println();
            }                 
        }      
    }
}