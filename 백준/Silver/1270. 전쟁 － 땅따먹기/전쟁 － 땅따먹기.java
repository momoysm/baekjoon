import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
                String winner = "";

                for (int i = 0; i < Ti; i++) {
                    String key = st.nextToken();

                    if(count.containsKey(key)) {
                        count.put(key, count.get(key) + 1);
                    } else {
                        count.put(key, 1);
                    }
                }

                Set<Entry<String, Integer>> entrySet = count.entrySet();
                for (Entry<String, Integer> e : entrySet) {
                    if(Ti % 2 == 0) {
                        if(e.getValue() > Ti / 2) {
                            winner = e.getKey();
                        }
                    }
                    else {
                        if(e.getValue() >= (Ti / 2) +1) {
                            winner = e.getKey();
                        }
                    }
                }

                if("".equals(winner)) {
                    bw.write("SYJKGW" + "\n");
                }
                else {
                    bw.write(winner + "\n");
                }
            }

            bw.flush();
        }
    }
}