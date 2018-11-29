/*
 * Node.java
 * @Author: Joseph Cox
 * @Date: 10/28/18
 * ---------------------------------------------
 */
import java.util.*;

class Node{
    /* make everything public so that everything is accessable*/
    public int row; // the row the vertex is located 
    public int col; // the column the vertex is located in 
    public int value; // the value that the vertex can bounce
    public Node north; // for the adjacency list, default it will be set to NULL
    public Node south;
    public Node east;
    public Node west;

    // pass some variables as static so that it is shared accross all instances of the class
    public static int [][] grid; 
    public static Node [] adjacentcyList; // Stats as a 1D array of n*n values use pointers N,S,E,W to point to location for neighbors 
    public static int row_size; // col_row size of the data should not change accrross the class
    public static int col_size;
    public boolean visited; // mark a particular node as visited or not visited for the search
    public static Stack <String> dfs_stack;// String stack to hold the direction of travel 
    public static String exitPath;

    // constructor that will instiate all the inital variables
    public Node(int row,int col,int value){
        this.row = row;
        this.col = col;
        this.value = value;
        this.north = null;
        this.south = null;
        this.east =null;
        this.west = null;
        this.visited = false;
        dfs_stack = new Stack<String>();
        exitPath = " ";

    }
    // This function is to input the grid ans utilize it for debugging
    public void setGrid(int ingrid[][],int in_row_size,int in_col_size){
        grid=ingrid;
        row_size = in_row_size;
        col_size = in_col_size;
    }
    // just show the grid is complete and useful for initial debugging
    public void printGrid(){
        System.out.println("printing the grid");
        for(int i=0;i<row_size;i++){
            for(int j = 0;j<col_size;j++){
                System.out.println(grid[i][j]);
            }
        }
    }
    // pass in the initial adjacency list and continue to build it in the class
    public void setList(Node in_adjacentcyList[]){
        adjacentcyList = in_adjacentcyList;
    }
    // ability to print the adjacency list for debugging 
    public void printList(){
        System.out.println("Printing the list");
        for(int i = 0; i<adjacentcyList.length;i++){
            System.out.println(adjacentcyList[i].value);
        }
    }
    // calculate all the neighbors of each individual node in the adjacency list
    public void getNeighbors(){
        // North 
        if(this.row - this.value>=0){
            this.north = adjacentcyList[((this.row - this.value)*col_size)+col];
        }
        // South
        if(this.row + value<row_size){
            this.south = adjacentcyList[((this.row+this.value)*row_size)+col];
        }
        // East
        if(this.col + this.value<col_size){
            this.east = adjacentcyList[((this.col+this.value)+(this.row)*(col_size))];
        }
        // West
        if(this.col - this.value>=0){
            this.west = adjacentcyList[((this.row*col_size)+(this.col - this.value))];
        }
    }
    // print the complete adjacency list
    public void printNeighbors(){
        if(this.north == null){
            System.out.print("North->Null | ");
        }
        else{
            System.out.print("North->"+this.north.value+" | ");
        }
        if(this.south == null){
            System.out.print("South->Null | ");
        }
        else{
            System.out.print("South->"+this.south.value+" | ");
        }
        if(this.east == null){
            System.out.print("East->Null | ");
        }
        else{
            System.out.print("East->"+this.east.value+" | ");
        }
        if(this.west == null){
            System.out.print("West->Null | ");
        }
        else{
            System.out.print("West->"+this.west.value+" | ");
        }
        
    }
    // traverse the maze using depth first search and print the exit path 
    public void depthFirstSearch(Node vertex){
        vertex.visited = true;
        if(vertex.row == row_size-1 && vertex.col == col_size-1){
            System.out.println("Printing the stack:");
              while(!dfs_stack.isEmpty()){
                    System.out.println(dfs_stack.peek());
                    exitPath +=dfs_stack.peek(); 
                    dfs_stack.pop();
            } 
        }
        if(vertex.north!=null && vertex.north.visited==false){
            dfs_stack.push("N");
            vertex.depthFirstSearch(vertex.north);
        }
        if(vertex.south!=null && vertex.south.visited==false){
            dfs_stack.push("S");
            vertex.depthFirstSearch(vertex.south);
        }
        if(vertex.west !=null && vertex.west.visited ==false){
            dfs_stack.push("W");
            vertex.depthFirstSearch(vertex.west);
        }
        if(vertex.east !=null && vertex.east.visited==false){
            dfs_stack.push("E");
            vertex.depthFirstSearch(vertex.east);
        }
        if (!dfs_stack.isEmpty()){
            dfs_stack.pop();
        }
        return;
    }
    public String get_dfs_exitPath(){
        String exit = ""; // initialize the string to be returned not in reverse
        for(int i=exitPath.length()-1;i>0;i--){
            exit+=exitPath.charAt(i)+" ";
        }
        return exit;
    }
}
