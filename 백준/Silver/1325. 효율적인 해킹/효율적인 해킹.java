import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int[] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 🔥 역방향으로 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[B].add(A);
        }

        count = new int[N + 1];

        int max = 0;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            int result = bfs(i);
            count[i] = result;
            max = Math.max(max, result);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (count[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int cnt = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}