// TODO: 12/4/2023

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {

        char[][] grid = {
                {'Y','Y','B','B','B'},
                {'Y','G','G','B','B'},
                {'G','G','B','B','B'},
                {'R','R','R','B','B'},
                {'R','R','B','B','B'}
        };

        printGrid(grid);
        fill(grid, new int[]{4,4}, 'B', 'C');
        printGrid(grid);

    }

    private static void fill(char[][] grid, int[] point, char oldColor, char newColor){

        if (!isIndexValid(grid, point[0], point[1]) || grid[point[0]][point[1]]!=oldColor) return;

        int[] rows = {0,0,-1,1, -1,1,-1,1};
        int[] cols = {-1,1,0,0, -1,-1,1,1};

        Queue<int[]> q = new LinkedList<>();

        q.add(point);
        grid[point[0]][point[1]] = newColor;

        while (!q.isEmpty()){
            int[] pR = q.remove();
            int x = 0;

            while (x<8){
                int r = pR[0] + rows[x];
                int c = pR[1] + cols[x++];
                if (isIndexValid(grid, r, c) && grid[r][c] == oldColor){
                    q.add(new int[]{r,c});
                    grid[r][c] = newColor;
                }
            }

        }

    }

    private static boolean isIndexValid(char[][] grid, int row, int col){
        if (row<grid.length && row>=0 && col<grid[0].length && col>=0){
            return true;
        }
        return false;
    }

    private static void printGrid(char[][] grid){
        for(char[] x : grid){
            System.out.print("[");
            for (char y : x){
                System.out.print(" "+y+" ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

}
