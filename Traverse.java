/* Node.java
*  @Author: Joseph Cox
*  @Date: 10/28/18
*/

import java.io.*;
import java.util.Scanner;
import java.io.IOException;

public class Traverse{
    public static void main(String [] args){
        try {
            Scanner read = new Scanner(new File("input.txt")); // remember to change this to input.txt before submission
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
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
            int k=0;
            for(int i = 0; i<rows;i++){
                for(int j = 0; j<columns;j++){
                    if(j%columns == 0){
                        System.out.println(" ");
                    }
                    adjacencyList[(k)]= new Node(i, j, grid[i][j]);
                    k++;
                }
            }
            System.out.println("Print the adjacency list");
            adjacencyList[0].setList(adjacencyList);
            adjacencyList[0].setGrid(grid,rows,columns);
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
        adjacencyList[0].depthFirstSearch(adjacencyList[0]);
        System.out.println("Exit Path: "+ adjacencyList[0].get_dfs_exitPath());
        writer.write(adjacencyList[0].get_dfs_exitPath());
        writer.close();
        read.close();
        
    } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}