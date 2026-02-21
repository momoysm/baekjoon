import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];

            int result = 1;

            for (int i = 0; i < N; i++) {
                String line = br.readLine();

                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    result = Math.max(result, calculateSuqareArea(i, j));
                }
            }

            bw.write(result + "");
            bw.flush();
        }
    }

    private static int calculateSuqareArea(int x, int y) {
        int max_len = Math.min(N, M);

        int result = 1;

        for (int i = 1; i < max_len; i++) {
            if (x + i >= N || y + i >= M) {
                break;
            }

            int current = map[x][y];

            if (map[x + i][y] == current && map[x][y + i] == current
                && map[x + i][y + i] == current) {
                result = (i + 1) * (i + 1);
            }
        }

        return result;
    }
}
