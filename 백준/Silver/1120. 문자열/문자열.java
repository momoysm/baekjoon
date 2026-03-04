import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String A = st.nextToken();
            String B = st.nextToken();

            int diff = B.length() - A.length();
            int result = Integer.MAX_VALUE;

            for (int i = 0; i <= diff; i++) {
                result = Math.min(result, getDiff(A, B.substring(i, i + A.length())));
            }

            bw.write(result + "");
            bw.flush();
        }
    }

    private static int getDiff(String A, String B) {
        int result = 0;

        char[] A_arr = A.toCharArray();
        char[] B_arr = B.toCharArray();

        for (int i = 0; i < A.length(); i++) {
            if(A_arr[i] != B_arr[i]) result ++;
        }
        return result;
    }
}