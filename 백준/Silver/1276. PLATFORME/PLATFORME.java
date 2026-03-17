import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            int[][] platforms = new int[N][3]; // [Y, X1, X2]

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                platforms[i][0] = Integer.parseInt(st.nextToken()); // Y (높이)
                platforms[i][1] = Integer.parseInt(st.nextToken()); // X1 (왼쪽)
                platforms[i][2] = Integer.parseInt(st.nextToken()); // X2 (오른쪽)
            }

            // 높이(Y) 기준 오름차순 정렬
            Arrays.sort(platforms, (a, b) -> Integer.compare(a[0], b[0]));

            long result = 0;

            for (int i = 0; i < N; i++) {
                int Y  = platforms[i][0];
                int X1 = platforms[i][1];
                int X2 = platforms[i][2];

                // 왼쪽 기둥: X1+0.5 위치 → 아래 플랫폼 조건: lowerX1 < X1 < lowerX2
                // 오른쪽 기둥: X2-0.5 위치 → 아래 플랫폼 조건: lowerX1 < X2-1 < lowerX2
                //                             즉, lowerX1 < X2 && X2 < lowerX2+1
                //                             정수이므로: lowerX1 < X2 && X2 <= lowerX2

                int leftBase  = 0; // 왼쪽 기둥이 서는 플랫폼 높이 (없으면 바닥=0)
                int rightBase = 0; // 오른쪽 기둥이 서는 플랫폼 높이

                for (int j = 0; j < i; j++) {  // i보다 낮은 플랫폼만 체크
                    int lY  = platforms[j][0];
                    int lX1 = platforms[j][1];
                    int lX2 = platforms[j][2];

                    // 왼쪽 기둥(X1+0.5)이 이 플랫폼 위에 있는가?
                    // lX1 < X1+0.5 < lX2  →  lX1 <= X1 && X1 < lX2  (정수)
                    if (lX1 <= X1 && X1 < lX2) {
                        leftBase = Math.max(leftBase, lY);
                    }

                    // 오른쪽 기둥(X2-0.5)이 이 플랫폼 위에 있는가?
                    // lX1 < X2-0.5 < lX2  →  lX1 < X2 && X2 <= lX2  (정수)
                    if (lX1 < X2 && X2 <= lX2) {
                        rightBase = Math.max(rightBase, lY);
                    }
                }

                result += (Y - leftBase) + (Y - rightBase);
            }

            bw.write(result + "");
            bw.flush();
        }
    }
}