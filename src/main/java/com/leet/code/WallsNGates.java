package com.leet.code;

import java.util.*;

public class WallsNGates {
    public static void main(String[] args) {
        int arr[][] =
                {{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}};
        new WallsNGates().wallsAndGates(arr);
        System.out.println(arr);
    }

    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    public void wallsAndGates(int[][] rooms) {
        System.out.println("Here");
        int m = rooms.length;
        if (m == 0) {
            return;
        }
        int n = rooms[0].length;

        Queue<Pair> queue = new LinkedList<>();
        Map<Pair, Integer> pairMap = new HashMap<>();

        // Get the gates and put them in the queue.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    Pair pair = new Pair(i, j);
                    queue.offer(pair);
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair pairFromQueue = queue.poll();
            pairMap.put(pairFromQueue, 0);
            int x = pairFromQueue.x;
            int y = pairFromQueue.y;
            for (int[] direction : DIRECTIONS) {
                int row = x + direction[0];
                int col = y + direction[1];

                if (row < 0 || col < 0 || row >= m || col >= n || rooms[row][col] != Integer.MAX_VALUE) {
                    continue;
                } else {
                    Pair pairToVisit = new Pair(row, col);
                    int countOfSteps = pairMap.get(pairToVisit) != null ? pairMap.get(pairToVisit) : 1;
                    countOfSteps++;
                    pairMap.put(pairToVisit, countOfSteps);
                    queue.offer(pairToVisit);
                }
            }
        }

        for (Pair pair : pairMap.keySet()) {
            int countOfSteps = pairMap.get(pair);
            rooms[pair.x][pair.y] = countOfSteps;
        }

    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object pair) {
            Pair p = (Pair) pair;
            if (this.x == p.x &&
                    this.y == p.y) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Long.valueOf(this.x * 31L + this.y).hashCode();
        }
    }
}
