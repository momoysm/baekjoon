import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int R, C, K;
    private static char[][] map;
    private static boolean[][] visited;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new char[R][C];
            visited = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                String line = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = line.charAt(j);

                    if(map[i][j] == 'T') {
                        visited[i][j] = true;
                    }
                }
            }

            visited[R-1][0] = true;
            dfs(R-1, 0, 1);

            bw.write(count + "");
            bw.flush();
        }
    }

    private static void dfs(int y, int x, int move) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        if(y == 0 && x == C-1) {
            if(move == K) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(ny < 0 || ny > R-1 || nx < 0 || nx > C-1) {
                continue;
            }

            if(map[ny][nx] == 'T' || visited[ny][nx]) {
                continue;
            }

            visited[ny][nx] = true;
            dfs(ny, nx, move+1);
            visited[ny][nx] = false;
        }

    }
}