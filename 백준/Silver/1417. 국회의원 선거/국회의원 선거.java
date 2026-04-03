import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            int dasom = Integer.parseInt(br.readLine());

            int count = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 1; i < N; i++) {
                pq.add(Integer.parseInt(br.readLine()));
            }

            while(!pq.isEmpty() && pq.peek() >= dasom) {
                int max = pq.poll();

                max--;
                dasom++;

                pq.add(max);
                count++;
            }

            bw.write(count + "");
            bw.flush();
        }
    }

}