package com.leet.code;

public class TwoDMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}

		int row = matrix.length;
		int col = matrix[0].length;

		for (int i = 0; i <= row - 1; i++) {

			if (matrix[i][0] <= target && target <= matrix[i][col - 1]) {
				int left = 0;
				int right = col - 1;

				while (left <= right) {
					int mid = (left + right) / 2;

					if (target < matrix[i][mid]) {
						right = mid-1;
					} else if (target > matrix[i][mid]) {
						left = mid+1;
					} else {
						return true;
					}
				}
			}

		}
		return false;
	}

	public static void main(String[] args) {
		int mat[][] = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
		System.out.println(searchMatrix(mat, 13));
		System.out.println(searchMatrix(new int [][]{{1}}, 1));
	}
}
