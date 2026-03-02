import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            int[] info = new int[N];
            int[] line = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                info[i] = Integer.parseInt(st.nextToken());
            }

            for (int height = 1; height <= N; height++) {
                int count = info[height - 1];

                for (int i = 0; i < N; i++) {
                    if (line[i] == 0) {
                        if (count == 0) {
                            line[i] = height;
                            break;
                        }
                        count--;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(line[i] + " ");
            }

            bw.write(sb.toString());
            bw.flush();
        }

    }
}
