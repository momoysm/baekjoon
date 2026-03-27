import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                graph[l].add(r);
                graph[r].add(l);
            }

            int answer = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 1; i <= N; i++) {
                int sum = bfs(i);

                if(sum < min) {
                    min = sum;
                    answer = i;
                }
            }

            bw.write(answer + "");
            bw.flush();
        }
    }

    private static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }

        return sum;
    }

}