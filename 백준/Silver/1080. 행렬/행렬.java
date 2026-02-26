import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[][] A, B;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N][M];
            B = new int[N][M];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();

                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(str.substring(j, j+1));
                }
            }

            for (int i = 0; i < N; i++) {
                String str = br.readLine();

                for (int j = 0; j < M; j++) {
                    B[i][j] = Integer.parseInt(str.substring(j, j+1));
                }
            }

            int answer = 0;
            if(N < 3 || M < 3) {
                if(isSameMatrix()) {
                    bw.write(answer + "");
                    bw.flush();
                    return;
                }

                bw.write("-1");
                bw.flush();
                return;
            }

            for (int i = 0; i < N-2; i++) {
                for (int j = 0; j < M-2; j++) {
                    if(A[i][j] != B[i][j]) {
                        changeMatrix(i, j);
                        answer++;
                    }
                }
            }

            if(!isSameMatrix()) {
                answer = -1;
            }

            bw.write(answer + "");
            bw.flush();
        }
    }

    private static boolean isSameMatrix() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void changeMatrix(int y, int x) {
        for (int i = y; i < y+3; i++) {
            for (int j = x; j < x+3; j++) {
                if(A[i][j] == 0) {
                    A[i][j] = 1;
                }else {
                    A[i][j] = 0;
                }
            }
        }
    }

}