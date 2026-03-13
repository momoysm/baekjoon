import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(br.readLine().trim());
            int[][] classInfo = new int[n + 1][6];

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int grade = 1; grade < 6; grade++) {
                    classInfo[i][grade] = Integer.parseInt(st.nextToken());
                }
            }

            int max = -1;
            int result = 1;

            for (int i = 1; i <= n; i++) { // 기준 학생
                int count = 0;

                for (int j = 1; j <= n; j++) { // 비교 학생
                    if(i == j) continue;

                    for (int grade = 1; grade < 6; grade++) {
                        if(classInfo[i][grade] == classInfo[j][grade]) {
                            count++;
                            break;
                        }
                    }
                }

                if(max < count) {
                    max = count;
                    result = i;
                }
            }

            bw.write(result + "");
            bw.flush();
        }
    }
}