import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    private static int N, M, V;
    private static List<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            // 배열 초기화
            graph = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            // 노드 설정
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            for (int i = 1; i <= N; i++) {
                Collections.sort(graph[i]);
            }

            visited = new boolean[N+1];
            dfs(V);
            sb.append("\n");

            visited = new boolean[N+1];
            bfs(V);

            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for(int next : graph[start]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");

            for(int next : graph[node]) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}