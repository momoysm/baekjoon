import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String L = st.nextToken();
            String R = st.nextToken();

            if(L.length() != R.length()) {
                bw.write("0");
                bw.flush();
                return;
            }
            
            int count = 0;
            for (int i = 0; i < L.length(); i++) {
                if(L.charAt(i) != R.charAt(i)) break; //앞자리가 다를 경우 ex) 800 / 900 이면 900때문에 0
                if(L.charAt(i) == '8') count++; // 앞자리가 같을 경우 ex) 8xx / 8xx 이면 800때문에 최소 1
            }

            bw.write(count + "");
            bw.flush();
        }
    }
}