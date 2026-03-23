import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            boolean[][] visited = new boolean[6][6];
            int[][] path = new int[36][2];

            for (int i = 0; i < 36; i++) {
                String input = br.readLine();
                int col = input.charAt(0) - 'A';
                int row = input.charAt(1) - '1';

                path[i][0] = row;
                path[i][1] = col;

                if (visited[row][col]) {
                    bw.write("Invalid");
                    bw.flush();
                    return;
                }
                visited[row][col] = true;
            }

            for (int i = 0; i < 35; i++) {
                if (!isValidMove(path[i][0], path[i][1], path[i+1][0], path[i+1][1])) {
                    bw.write("Invalid");
                    bw.flush();
                    return;
                }
            }

            if (!isValidMove(path[35][0], path[35][1], path[0][0], path[0][1])) {
                bw.write("Invalid");
                bw.flush();
                return;
            }

            bw.write("Valid");
            bw.flush();
        }
    }

    private static boolean isValidMove(int r1, int c1, int r2, int c2) {
        int dr = Math.abs(r1 - r2);
        int dc = Math.abs(c1 - c2);
        return (dr == 2 && dc == 1) || (dr == 1 && dc == 2);
    }

}