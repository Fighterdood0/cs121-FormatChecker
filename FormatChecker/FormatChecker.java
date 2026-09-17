import java.io.File;
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
        if(args.length < 1){
            System.out.println("Please input what files you are using");
            return;
        }
        File file;
        Scanner scnr;
        for(int i = 0; i < args.length; i++){
            try {
                file = new File(args[i]);
                scnr = new Scanner(file);
                int rows = scnr.nextInt();
                int cols = scnr.nextInt();
                double[][] array = new double[rows][cols];
                for(int j = 0; j<array.length; j++){
                    for(int k = 0; k<array[j].length; k++){
                        array[j][k] = scnr.nextDouble();
                    }
                }
                System.out.println(file.getName() + "\nVALID");
                System.out.println();
            
                scnr.close();
            } catch (Exception e) {
                System.out.println(args[i]);
                System.out.println("There was an exception: " + e.toString());
                System.out.println("INVALID");
                System.out.println();
            } 
                
        }
        
    }

}