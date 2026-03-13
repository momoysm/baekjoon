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

            int N = Integer.parseInt(br.readLine());
            int[][] classInfo = new int[N+1][6];

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int grade = 1; grade <= 5; grade++) {
                    classInfo[i][grade] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 1;
            int maxCount = 0;

            for (int i = 1; i <= N; i++) {
                int count = 0;
                for (int j = 1; j <= N; j++) {
                    if(i == j) continue;

                    boolean sameClass = false;
                    for (int grade = 1; grade <= 5; grade++) {
                        if(classInfo[i][grade] == classInfo[j][grade]) {
                            sameClass = true;
                            break;
                        }
                    }
                    if(sameClass) {
                        count++;
                    }
                }

                if(maxCount < count) {
                    maxCount = count;
                    result = i;
                }
            }

            bw.write(result + "");
            bw.flush();
        }
    }
}