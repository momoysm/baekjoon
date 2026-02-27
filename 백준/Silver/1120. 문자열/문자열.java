import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();

            int diff = b.length() - a.length(); // 길이 차이
            int result = Integer.MAX_VALUE;

            // A를 0칸 ~ diff칸 뒤로 밀면서 모든 경우 체크
            for (int i = 0; i <= diff; i++) {
                // B의 i번째부터 a.length()만큼 잘라서 비교
                String b_sub = b.substring(i, i + a.length());
                result = Math.min(result, getDiff(a, b_sub));
            }

            bw.write(result + "");
            bw.flush();
        }
    }

    private static int getDiff(String a, String b) {
        int count = 0;

        char[] a_arr = a.toCharArray();
        char[] b_arr = b.toCharArray();

        for (int i = 0; i < a_arr.length; i++) {
            if(a_arr[i] == b_arr[i]) continue;

            count++;
        }

        return count;
    }
}