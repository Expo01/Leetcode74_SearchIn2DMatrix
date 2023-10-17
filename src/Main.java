public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

// m = rows, y axis, depth, n = columns, x axis, width
// length = # of rows = m
// int [][] matrix is such that outer array is m and inner is n. [m][n]
// will want to binary search through m (depth) through span of 1<=n for each loop

// my solution beats 100% time, 75% memory. FERK YEEAH
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (binarySearch(row, row.length-1, target)) { // pass a row, the start cell, end cell and target
                return true; // if target found in any iteration, return true
            }
        }
        return false; // if loop completes, all rows searched, target not found, return F
    }

    private boolean binarySearch(int[] row, int end, int target) { // standard binary search of an array
        int mid = 0;
        int start = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}


// loop 1 through n assuming n is height. binary search 1 through m each row. return T/F