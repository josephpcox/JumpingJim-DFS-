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
    public static int [][] grid; // pass the int as static so that it is shared accross all instances
    public static Node [] adjacentcyList;
    public static int row_size;
    public static int col_size;
    public boolean visited;
    public static Stack dfs_stack;

    public Node(int row,int col,int value){
        this.row = row;
        this.col = col;
        this.value = value;
        this.north = null;
        this.south = null;
        this.east =null;
        this.west = null;
        this.visited = false;
        this.dfs_stack = new Stack();

    }
    public void setGrid(int grid[][],int row_size,int col_size){
        this.grid=grid;
        this.row_size = row_size;
        this.col_size = col_size;
    }
    public void printGrid(){
        System.out.println("printing the grid");
        for(int i=0;i<this.row_size;i++){
            for(int j = 0;j<this.col_size;j++){
                System.out.println(this.grid[i][j]);
            }
        }
    }
    public void setList(Node adjacentcyList[]){
        this.adjacentcyList = adjacentcyList;
    }
    public void printList(){
        System.out.println("Printing the list");
        for(int i = 0; i<this.adjacentcyList.length;i++){
            System.out.println(this.adjacentcyList[i].value);
        }
    }
    public void getNeighbors(){
        // North 
        if(this.row - this.value>=0){
            this.north = adjacentcyList[((this.row - this.value)*this.col_size)+col];
        }
        // South
        if(this.row + value<this.row_size){
            this.south = adjacentcyList[((this.row+this.value)*this.row_size)+col];
        }
        // East
        if(this.col + this.value<this.col_size){
            this.east = adjacentcyList[((this.col+this.value)+(this.row)*(this.col_size))];
        }
        // West
        if(this.col - this.value>=0){
            this.west = adjacentcyList[((this.row*this.col_size)+(this.col - this.value))];
        }
    }
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
    public void DepthFirstSearch(){
        while(this.row != row_size && this.col!=this.col_size){

        }

    }
}