import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int[] rank = new int[P];

            if(N > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int i = 0; i < N; i++) {
                    rank[i] = Integer.parseInt(st.nextToken());
                }
            }

            int ranking = 1;

            for (int i = 0; i < N; i++) {
                if(rank[i] > score) {
                    ranking++;
                }
            }

            if(N == P && rank[N-1] >= score) {
                bw.write(-1 + "");
            }
            else {
                bw.write(ranking + "");
            }

            bw.flush();
        }
    }
}