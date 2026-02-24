import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Deque<Integer> deque = new LinkedList<>();

            for (int i = 1; i <= N; i++) {
                deque.addLast(i);
            }

            st = new StringTokenizer(br.readLine(), " ");

            int count = 0;

            for (int i = 0; i < M; i++) {
                int target = Integer.parseInt(st.nextToken());

                int idx = 0;

                for(int num : deque) {
                    if (num == target) break;
                    idx++;
                }

                int left = idx;
                int right = deque.size() - idx;

                if(left <= right) {
                    for (int j = 0; j < left; j++) {
                        deque.addLast(deque.pollFirst());
                        count++;
                    }
                }
                else {
                    for (int j = 0; j< right; j++) {
                        deque.addFirst(deque.pollLast());
                        count++;
                    }
                }

                deque.pollFirst();
            }

            bw.write(count + "");
            bw.flush();
        }
    }

}