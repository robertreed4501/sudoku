public class Board {
    private int[][][] grid = new int[9][9][11];
    private int[][] game1 = {{3,9,0,0,5,0,0,0,0},{0,0,0,2,0,0,0,0,5},{0,0,0,7,1,0,0,8,0},{0,5,0,0,6,8,0,0,0},{2,0,6,0,0,3,0,0,0},{0,0,0,0,0,0,0,0,4},{5,0,0,0,0,0,0,0,0},{6,7,0,1,0,5,0,4,0},{1,0,9,0,0,0,2,0,0}};
    private int[][] game2 = {{8,5,0,6,4,9,0,0,0},{0,0,3,1,0,0,2,9,0},{7,0,0,0,0,0,0,0,0},{0,7,0,0,0,3,5,6,9},{0,3,0,9,2,5,0,8,0},{4,9,5,7,0,0,0,3,0},{0,0,0,0,0,0,0,0,4},{0,2,4,0,0,7,6,0,0},{0,0,0,3,5,4,7,2,8}};
    private int[][] game3 = {{0,0,0,9,0,2,0,6,3},{0,0,7,5,3,0,0,0,1},{0,4,2,0,0,0,0,9,0},{0,0,0,3,0,7,4,8,6},{8,0,0,0,0,0,0,0,5},{6,9,4,1,0,5,0,0,0},{0,1,0,0,0,0,8,2,0},{4,0,0,0,5,1,6,0,0},{7,3,0,2,0,9,0,0,0}};
    private int[][] game4 = {{2,0,0,0,0,0,0,0,7},{0,0,0,0,8,4,6,2,0},{0,5,8,2,1,0,0,0,0},{0,0,0,9,0,5,0,6,0},{4,0,5,0,0,0,7,0,1},{0,9,0,1,0,8,0,0,0},{0,0,0,0,9,2,5,1,0},{0,1,6,8,3,0,0,0,0},{9,0,0,0,0,0,0,0,3}};
    private int[][] game5 = {{0,0,3,0,0,9,0,4,7},{0,0,2,0,0,7,0,8,3},{7,9,0,4,3,0,0,0,0},{0,7,9,0,4,0,0,0,0},{5,0,0,9,0,6,0,0,4},{0,0,0,0,7,0,8,9,0},{0,0,0,0,8,5,0,2,1},{3,2,0,7,0,0,4,0,0},{8,5,0,6,0,0,7,0,0}};
    private int[][] game6 = {{0,0,9,0,0,8,0,0,2},{0,0,5,4,0,0,0,9,8},{7,8,0,0,2,0,0,1,0},{0,3,0,0,0,5,1,0,6},{0,0,0,0,4,0,0,0,0},{4,0,6,1,0,0,0,7,0},{0,6,0,0,3,0,0,2,4},{2,4,0,0,0,9,8,0,0},{9,0,0,2,0,0,3,0,0}};
    private int[][] game7 = {{0,0,5,0,0,0,8,3,0},{9,0,0,0,0,7,0,4,1},{7,8,0,4,0,0,0,0,0},{1,6,4,0,3,0,0,0,0},{0,0,0,0,4,0,0,0,0},{0,0,0,0,2,0,6,1,4},{0,0,0,0,0,2,0,6,5},{8,2,0,3,0,0,0,0,9},{0,1,7,0,0,0,2,0,0}};
    private int[][] game8 = {{9,0,6,3,0,0,0,7,0},{4,0,0,0,5,0,0,9,6},{0,2,0,6,0,1,0,0,0},{0,9,5,0,0,0,6,0,2},{0,0,0,9,6,5,0,0,0},{6,0,8,0,0,0,7,5,0},{0,0,0,5,0,9,0,2,0},{5,3,0,0,1,0,0,0,7},{0,8,0,0,0,3,9,0,5}};
    private int[][] game9 = {{3,0,0,0,4,1,8,0,0},{0,0,8,0,0,3,0,2,6},{9,4,0,0,0,8,5,0,0},{0,0,5,0,0,0,0,0,4},{0,0,0,1,5,7,0,0,0},{7,0,0,0,0,0,2,0,0},{0,0,4,8,0,0,0,5,7},{2,5,0,6,0,0,1,0,0},{0,0,9,3,1,0,0,0,2}};
    boolean stuck = false;
    Board(){
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j][0] = game5[i][j];
                grid[i][j][10] = 9;
                for (int z = 1; z < 10; z++) {
                    grid[i][j][z] = z;
                }
            }
        }
    }

    boolean isInRow(int x, int y, int num){
        for(int i = 0; i < 9; i++) {
            if (grid[x][i][0] == num) {
                return true;
            }
        }
        return false;
    }

    boolean isInCol(int x, int y, int num){
        for(int i = 0; i < 9; i++) {
            if (grid[i][y][0] == num) {
                return true;
            }
        }
        return false;
    }

    boolean isInSquare(int x, int y, int num){
        int sqx = x - x % 3;
        int sqy = y - y % 3;
        for(int i = sqx; i < sqx + 3; i++) {
            for(int j = sqy; j < sqy + 3; j++){
                if (grid[i][j][0] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    void printBoard(){
        String spacer;
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 2 || j == 5){
                    spacer = "|";
                }
                else spacer = " ";
                System.out.print(grid[i][j][0] + spacer);
            }
            if (i == 2 || i == 5){
                System.out.println();
                System.out.println("-----+-----+-----");
            }
            else{
                System.out.println();
            }
        }
        System.out.println();
    }

    void change(int x, int y, int num){
        grid[x][y][0] = num;
    }

    void update3d(){
        stuck = true;
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j][0] == 0) {
                    for (int z = 1; z < 10; z++) {
                        if ((isInRow(i, j, z) || isInCol(i, j, z) || isInSquare(i, j, z)) && (grid[i][j][z] != 0)) {
                            grid[i][j][z] = 0;
                            grid[i][j][10]--;
                            if(grid[i][j][10] == 1){
                                stuck = false;
                            }
                        }
                    }
                }
                else grid[i][j][10] = 0;
            }
        }
    }

    void printPossBoard(){
        String spacer;
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 2 || j == 5){
                    spacer = "|";
                }
                else spacer = " ";
                System.out.print(grid[i][j][10] + spacer);
            }
            if (i == 2 || i == 5){
                System.out.println();
                System.out.println("-----+-----+-----");
            }
            else{
                System.out.println();
            }
        }
        System.out.println();
    }

    void change1s(){
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j][10] == 1) {
                    for (int num = 1; num < 10; num++) {
                        if (grid[i][j][num] != 0){
                            grid[i][j][0] = num;
                        }
                    }
                }
            }
        }
    }

    boolean isSolved(){
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j][0] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    boolean stuck(){
        return stuck;
    }
}
