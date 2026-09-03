import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
* Methods required for a class that validates
 * or creates magic squares in files with format:
 *   dimensionN
 *   v1 v2 ... vn
 *   ...
 *   vn1 vn2 ... vnn
 * e.g.
 *   3
 *   4 9 2
 *   3 5 7
 *   8 1 6
 * 
 * Two constructors are required.
 * 
 * The first constructor takes a filename, only,
 * and attempts to read that file. If the file
 * cannot be opened or is not in the correct
 * format, a FileNotFoundException should be thrown.
 *   public MagicSquare(String filename) throws FileNotFoundException
 * This constructor is required to call a private
 * utility method
 *   private int[][] readMatrix(String filename) throws FileNotFoundException
 * to open and read the file into a 2D int array.
 * 
 * The second constructor takes a filename and
 * an int for the dimension N of a new NxN magic
 * square. A generated matrix should be written
 * in the required format to a file with the given
 * name.
 *   public MagicSquare(String filename, int dimension) throws IOException
 * This constructor is required to call a private
 * utility method
 *   private void writeMatrix(int[][] matrix, String filename) throws IOException
 * to write the matrix to the file.
 * @author Zach Jessup CS221
 * @date 9/2/26
*/

public class MagicSquare implements MagicSquareInterface {

    private int[][] matrix; //The standard required 2d int array for the assignment
    private boolean isMagic; //I was told an optional boolean could be used, and so I shall use it.

    public MagicSquare(String filename) throws FileNotFoundException{ //first constructor, does not create a file
        File file = new File(filename);//finds the file if it exists
        Scanner scnr = new Scanner(file);//scanner to parse file
            int n = scnr.nextInt();
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    matrix[i][j] = scnr.nextInt();
                }
            }

        scnr.close();

    }

    private int[][] readMatrix(String filename) throws FileNotFoundException{ //reads matrix
        
        return matrix;
    }

    public MagicSquare(String filename, int dimension) throws IOException{ //second constructor, will create a file
        
    }

    private void writeMatrix(int[][] matrix, String filename) throws IOException{ //writes the matrix
        File file = new File(filename);
        PrintWriter outFile = new PrintWriter(file);


        outFile.close();
    }

        

    

    @Override
    public boolean isMagicSquare() {//returns if the matrix is a magic square

        if (isMagic) {//very redundant, this is a placehodler
            isMagic = true;
        }else{
            isMagic = false;
        }

        return isMagic;
    }

    @Override
    public int[][] getMatrix() {//returns matrix

        return matrix;
    }

    public String toString(){
        String matrixString = "";

        matrixString = matrixString + "The matrix \n";
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix[i].length; j++){
                matrixString = matrixString + (matrix[i][j] + " ");
            }
            matrixString = matrixString + "\n";
        }
        if(isMagic){
            matrixString = matrixString + ("is a magic square.");
        }else{
            matrixString = matrixString + ("is not a magic square.");
        }

        return matrixString;
    }


}