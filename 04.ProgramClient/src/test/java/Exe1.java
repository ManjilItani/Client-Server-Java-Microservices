import java.util.Arrays;


public class Exe1 {

    public static void main(String[] args) {

        matrix();

        System.out.println();

    }

//    task0
    public static int[][] matrix(int a, int b)
    {
        int[][] grid = new int[a][b];

        for(int i = 0; i < grid.length; i++ ) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = 1;
            }
        }

        System.out.println( Arrays.deepToString(grid));

        return null;
    }

//    taks 1
    public static int[][] matrix()
    {
        int[][] grid = new int[5][5];

        for(int i = 0; i < grid.length; i++ ) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = (int)(Math.random()*101);
            }
        }

        System.out.println( Arrays.deepToString(grid));

        return null;
    }
}
