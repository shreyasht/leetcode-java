package com.leet.code;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int[][] DIRECTIONS = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };

        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    numOfIslands++;
                    grid[row][col] = '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{row, col});
                    while (!queue.isEmpty()) {
                        int[] arr = queue.remove();
                        int row1 = arr[0];
                        int col1 = arr[1];

                        for (int[] direction : DIRECTIONS) {
                            int r = row1 + direction[0];
                            int c = col1 + direction[1];
                            if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1') {
                                continue;
                            }
                            queue.add(new int[]{r, c});
                            grid[r][c] = '0';
                            System.out.println("row : " + r + " col : " + c);
                        }
                    }
                }
            }
        }
        return numOfIslands;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));
    }
}
