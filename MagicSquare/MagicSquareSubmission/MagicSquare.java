import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
        

        readMatrix(filename);//it feels odd but this makes more sense to me to have the code in this?
        //This is not what was intended, oh well.
    
    }

    private int[][] readMatrix(String filename) throws FileNotFoundException{ //reads matrix
        File file = new File(filename);//finds the file if it exists
        Scanner scnr = new Scanner(file);//scanner to parse file
            int dimension = scnr.nextInt();
            matrix = new int [dimension][dimension];
            for (int i = 0; i < dimension; i++){//nested for loops to populate the matrix
                for (int j = 0; j < dimension; j++){
                    matrix[i][j] = scnr.nextInt();
                    
                    
                        }
                    }

            isMagicSquare();
        scnr.close();//Always gotta close the scanner
        return matrix;
    }

    public MagicSquare(String filename, int dimension) throws IOException{ //second constructor, will create a file


            matrix =  new int [dimension][dimension];
            int row = dimension-1;
            int col = dimension/2;
            int old_row, old_col;
            for(int i = 1; i < (dimension*dimension)+1;i++){
                matrix[row][col] = i;
                old_row = row;
                old_col = col;
                row++;
                col++;
                if(row==dimension){
                    row=0;
                }
                if(col==dimension){
                    col=0;
                }
                if(matrix[row][col] != 0){
                    row=old_row;
                    col=old_col;
                    row--;
                }
            }


            writeMatrix(matrix, filename);
            
            isMagicSquare();
    }

    private void writeMatrix(int[][] matrix, String filename) throws IOException{ //writes the matrix
        File file = new File(filename);
        PrintWriter outFile = new PrintWriter(file);
        matrix = this.matrix;
        outFile.print(matrix.length);
        outFile.println();

        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix.length; j++){
                outFile.print(matrix[i][j] + " ");
            }
            outFile.println();
        }
        


        outFile.close();//Always gotta close the printwriter
    }

        

    

    @Override
    public boolean isMagicSquare() {//returns if the matrix is a magic square
            int dimension = matrix.length;
            boolean sumCorrect = true;
            boolean containsAll = true;
            int increment = 1;
            int[][] targets = new int [dimension][dimension];
            for (int i = 0; i < dimension; i++){//loops to add up the matrix
                for (int j = 0; j < dimension; j++){
                    targets[i][j] = increment;
                    increment++;
                }
            }
        int magicNumber = (dimension * ((dimension * dimension) + 1)) / 2;//( n(n^2 + 1) / 2 )
             for (int i = 0; i < dimension; i++){//loops to add up the matrix rows
                int rowSum = 0;
                for (int j = 0; j < dimension; j++){
                    rowSum += matrix[i][j];
                }
                if (rowSum != magicNumber){
                    sumCorrect = false;
                }
            }
            for (int i = 0; i < dimension; i++){//loops to add up the matrix columns
                int colSum = 0;
                for (int j = 0; j < dimension; j++){
                    colSum += matrix[j][i];
                }
                if (colSum != magicNumber){
                    sumCorrect = false;
                }
            }
            int diagnol1=0,diagnol2=0;
            for (int i = 0; i < matrix.length; i++){//loop for diagnol
                diagnol1 += matrix[i][i];
            }
            if (diagnol1 != magicNumber) {
                sumCorrect = false;
            }
            for (int i = 0; i < matrix.length; i++){//loop for other diagnol
                diagnol2 += matrix[i][matrix.length-1-i];
            }
            if (diagnol2 != magicNumber) {
                sumCorrect = false;
            }



                    //Below is my attempt to make sure it contains the numbers it is supposed to. What did I do wrong here?
                    //I realize now this may NOT be wrong, as I misunderstood how the sum worked. Oops!
                    //for(int l = 0; l<matrix.length; l++){
                        //for(int k = 0; k<matrix[l].length; k++){
                           // if(true){ 
                                //containsAll = true;
                           // }else{
                            //    containsAll = false;
                            //    break;
                            //}
                        //}
                    //}
                
                //new attempt at frequencies after looking up help, and I relize the sum is wrong.
                Map<Integer, Integer> countMap = new HashMap<>();
                for (int[] row : matrix){
                    for (int num : row){
                        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                    }
                }

                for(int[] row : targets){
                    for (int num : row){
                        if (!countMap.containsKey(num)) {
                    containsAll = false; 
                }
                int count = countMap.get(num);
                if (count == 1) {
                    countMap.remove(num);
                } else {
                    countMap.put(num, count - 1);
                }
                    }
                }




            if(sumCorrect && containsAll){
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

    public String toString(){ //toString method as described in the project
        String matrixString = "";
        isMagicSquare();

        matrixString = matrixString + "The matrix \n";
        for (int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix[i].length; j++){
                matrixString = matrixString + (matrix[i][j] + " ");
            }
            matrixString = matrixString + "\n";
        }
        if(isMagic == true){
            matrixString = matrixString + ("is a magic square.");
        }else{
            matrixString = matrixString + ("is not a magic square.");
        }

        return matrixString;
    }


}