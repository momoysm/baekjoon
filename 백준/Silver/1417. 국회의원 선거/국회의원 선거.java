import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    
    private static int N;
    private static int[] arr;
    private static int maxIdx;

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            maxIdx = -1;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());

                if(max <= arr[i]) {
                    max = arr[i];
                    maxIdx = i;
                }
            }
            
            int result = bribe();

            bw.write(result + "");
            bw.flush();
        }
    }

    private static int bribe() {
        int count = 0;

        while(maxIdx != 0) {
            arr[maxIdx]--;
            arr[0]++;
            count++;

            for (int i = 0; i < N; i++) {
                if(arr[maxIdx] <= arr[i]) {
                    maxIdx = i;
                }
            }
        }

        return count;
    }

}