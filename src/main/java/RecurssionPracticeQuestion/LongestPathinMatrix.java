package RecurssionPracticeQuestion;

/**
 * https://www.geeksforgeeks.org/longest-possible-route-in-a-matrix-with-hurdles/
 * Given an N x M matrix, with a few hurdles(denoted by 0) arbitrarily placed, calculate the length of the longest possible route possible from source(xs,ys) to a destination(xd,yd) within the matrix.
 * We are allowed to move to only adjacent cells which are not hurdles.
 * The route cannot contain any diagonal moves and a location once visited in a particular path cannot be visited again.
 * If it is impossible to reach the destination from the source return -1.
 * Date: 11/29/2023
 * @author parth
 */
public class LongestPathinMatrix {

    static int finalx;
    static int finaly;

    public static void main(String args[]) {
        int[][] board = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        int result = longestPathinMatrix(board, 0, 0, 0, 8);
        System.out.println(result);
    }

    public static int longestPathinMatrix(int[][] board, int sourcex, int sourcey, int destinationx, int destinationy) {
        finalx = destinationx;
        finaly = destinationy;

        if (board[sourcex][sourcey] == 0 || board[finalx][finaly] == 0) {
            return -1;
        }
        int answer = longestPathinMatrix(board, sourcex, sourcey);
        return answer;
    }

    public static boolean isValid(int[][] board, int row, int column) {
        return row >= 0 && column >= 0 && row < board.length && column < board[0].length && board[row][column] != 0;
    }

    public static int longestPathinMatrix(int[][] board, int row, int column) {
        // Base Case
        if (row == finalx && column == finaly) {
            return 0;
        }
        if (!isValid(board, row, column)) {
            return -1;
        }
        board[row][column] = 0;
        int right =  1+longestPathinMatrix(board, row, column + 1);
        int left =  1+ longestPathinMatrix(board, row, column - 1);
        int up = 1+ longestPathinMatrix(board, row - 1, column);
        int down = 1+  longestPathinMatrix(board, row + 1, column);

        board[row][column] = 1;

        return Math.max(Math.max(right, left), Math.max(up, down));
    }
}
