import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());

            int count = 99;

            if(N < 100) {
                bw.write(N + "");
                bw.flush();
                return;
            }

            for (int i = 100; i <= N; i++) {
                if(isHansu(i)) count++;
            }

            bw.write(count + "");
            bw.flush();
        }
    }

    private static boolean isHansu(int num) {
        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num  % 10;

        return (b - a) == (c - b);
    }
}