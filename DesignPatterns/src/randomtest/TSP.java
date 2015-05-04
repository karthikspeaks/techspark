package randomtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TSP {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader buf = new BufferedReader(
                new InputStreamReader(System.in));
        int t = Integer.parseInt(buf.readLine());

        while (t-- > 0) {
            String[] line = buf.readLine().split(" ");
            line = buf.readLine().split(" ");
            int sX = Integer.parseInt(line[0]);
            int sY = Integer.parseInt(line[1]);
            int n = Integer.parseInt(buf.readLine());
            int[][] matrix = new int[n + 1][n + 1];
            int[][] points = new int[n + 1][2];
            points[0][0] = sX;
            points[0][1] = sY;
            for (int i = 1; i <= n; i++) {
                line = buf.readLine().split(" ");
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                points[i][0] = x;
                points[i][1] = y;
            }
            for (int i = 0; i <= n; i++)
                for (int j = 0; j <= n; j++) {
                    matrix[i][j] = matrix[j][i] = Math.abs(points[j][0]
                            - points[i][0])
                            + Math.abs(points[j][1] - points[i][1]);
                }
            int[][] dp = new int[n + 1][(1 << (n + 1)) + 1];
            for (int i = 0; i < dp.length; i++)
                Arrays.fill(dp[i], -1);

            int min = TSP(0, 0, dp, matrix);
            System.out.printf("The shortest path has length %d\n", min);
        }
    }

    private static int TSP(int node, int bitmask, int[][] dp, int[][] matrix) {
        if (bitmask == (1 << dp.length) - 1 && node == 0)
            return 0;
        if (bitmask == (1 << dp.length) - 1)
            return 100000;
        else if (dp[node][bitmask] != -1)
            return dp[node][bitmask];
        else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < dp.length; i++)
                if ((bitmask & (1 << i)) == 0) {
                    min = Math.min(
                            min,
                            matrix[node][i]
                                    + TSP(i, bitmask | (1 << i), dp, matrix));

                }
            return dp[node][bitmask] = min;
        }
    }
}