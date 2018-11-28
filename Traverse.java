import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Traverse{
    public static void main(String [] args){
        try {
            Scanner read = new Scanner(new File("small-input.txt")); // remember to change this to input.txt before submission
            System.out.println("File has been read");
            int rows = read.nextInt();
            int columns = read.nextInt();
            System.out.println("Rows: "+ rows + " Columns: "+columns); 
            // Create a 2D array of Trampolines of size row and coloumns 
            int [][] grid = new int[rows][columns]; 
            for(int i = 0; i<rows;i++){
                for(int j = 0; j<columns;j++){
                    grid [i][j] = read.nextInt();
                }
            }
            System.out.println("Printing out the rows and columns of grids trampolines");
            for(int i = 0; i<rows;i++){
                for(int j = 0; j<columns;j++){
                    if(j%columns == 0){
                        System.out.println(" ");
                    }
                    System.out.print(grid[i][j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

         

    
    }
}