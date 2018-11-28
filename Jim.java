class Jim {
    // keeping the instance variables scope public for easy access
    public int [][] grid;
    public int rows;
    public int columns;
    // constructor for the jim class 

    public Jim(int[][] grid,int rows,int columns){
        this.grid = grid;
        this.rows = rows;
        this.columns = columns;

    }

    public void printJim(){
        for(int i = 0; i< this.rows;i++){
            for(int j = 0; j<this.columns;j++){
                System.out.println(grid[i][j]);
            }
        }
    }
    public void buildAdjacencyMatrix(){
        

    }
}