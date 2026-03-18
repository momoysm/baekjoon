import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            String[] words = new String[N];

            for (int i = 0; i < N; i++) {
                words[i] = br.readLine();
            }
            
            Arrays.sort(words);
            
            int count = 0;

            for (int i = 0; i < N-1; i++) {
                if(words[i+1].startsWith(words[i])) {
                    continue;
                }
                count++;
            }

            count++;

            bw.write(count + "");
            bw.flush();
        }
    }

}