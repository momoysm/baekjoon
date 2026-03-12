import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(br.readLine());

            while(n-- > 0) {
                Map<String, Integer> count = new HashMap<>();

                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int Ti = Integer.parseInt(st.nextToken());
                String winner = "SYJKGW";

                for (int i = 0; i < Ti; i++) {
                    String key = st.nextToken();
                    int val = count.getOrDefault(key,0);

                    count.put(key, val+1);

                    if(val+1 > Ti /2) {
                        winner = key;
                    }
                }

                bw.write(winner + "\n");
            }

            bw.flush();
        }
    }
}