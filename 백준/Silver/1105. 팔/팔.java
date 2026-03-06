import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String L = st.nextToken();
            String R = st.nextToken();

            int result = 0;

            if(L.length() != R.length()) {
                bw.write("0");
                bw.flush();
                return;
            }

            for (int i = 0; i < L.length(); i++) {
                if(L.charAt(i) == R.charAt(i)) {
                    if(L.charAt(i) == '8') {
                        result++;
                    }
                } else {
                    break;
                }
            }

            bw.write(result + "");
            bw.flush();
        }
    }
}