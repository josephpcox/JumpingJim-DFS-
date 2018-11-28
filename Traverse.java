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
            Node [] adjacencyList = new Node [(rows*columns)];
            // put everythihg int the grid into the adjacency list of size rows x columns
            System.out.println("Printing out the rows and columns of grids trampolines");
            int k=0;
            for(int i = 0; i<rows;i++){
                for(int j = 0; j<columns;j++){
                    if(j%columns == 0){
                        System.out.println(" ");
                    }
                    System.out.print(i+j+": ");
                    System.out.println(grid[i][j]);
                    adjacencyList[(k)]= new Node(i, j, grid[i][j]);
                    k++;
                }
            }
            System.out.println("");
            // printing the adjacency list
            for(int i = 0;i<adjacencyList.length;i++){
                System.out.println(i+": "+adjacencyList[i].value+" row: "+adjacencyList[i].row + " col "+adjacencyList[i].col);
            }
            adjacencyList[0].setList(adjacencyList);
            adjacencyList[0].setGrid(grid,rows,columns);
            System.out.println(" ");
            adjacencyList[0].printGrid();
            adjacencyList[0].printList();
            for(int i =0;i<adjacencyList.length;i++){
                if(i % 5 ==0){
                    System.out.println("");
                    System.out.println("");
                }
                System.out.println(i);
                adjacencyList[i].getNeighbors();
                adjacencyList[i].printNeighbors();
                System.out.println("");
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

         

    
    }
}