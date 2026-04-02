import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int T = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < T; i++) {
                br.readLine(); // N은 사실 필요 없음
                sb.append("yes\n");
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }

}