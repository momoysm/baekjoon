import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int B, W;
    private static char[][] board;
    private static boolean[][] visited;
    private static int count = 1;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            board = new char[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                board[i] = st.nextToken().toCharArray();
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    count = 1;

                    if(!visited[i][j]) {
                        dfs(i, j);

                        if(board[i][j] == 'B') {
                            B += count * count;
                        } else {
                            W += count * count;
                        }
                    }
                }
            }

            bw.write(W + " " + B);
            bw.flush();
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        char c = board[y][x];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < N && nx >= 0 && ny < M && ny >=0) {
                if(!visited[ny][nx] && board[ny][nx] == c) {
                    count++;
                    dfs(ny, nx);
                }
            }
        }
    }

}