import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());

            HashSet<String> set = new HashSet<String>();
            for (int i = 0; i < N; i++) {
                set.add(br.readLine());
            }

            List<String> list = new ArrayList<>(set);
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    if(s1.length() != s2.length()) {
                        return s1.length() - s2.length();
                    }

                    return s1.compareTo(s2);
                }
            });

            StringBuilder sb = new StringBuilder();
            for (String word : list) {
                sb.append(word).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}