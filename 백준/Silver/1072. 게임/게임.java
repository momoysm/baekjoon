import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            long X = Long.parseLong(st.nextToken());
            long Y = Long.parseLong(st.nextToken());

            long Z = (Y * 100) / X;

            if(Z >= 99) {
                bw.write("-1");
                bw.flush();
                return;
            }

            long left = 1;
            long right = 1000000000;
            long answer = -1;

            while(left <= right) {
                long mid = (left + right) / 2;
                long newZ = ((Y + mid) * 100) / (X + mid);

                if(newZ > Z) {
                    answer = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            bw.write(answer + "");
            bw.flush();

        }
    }
}