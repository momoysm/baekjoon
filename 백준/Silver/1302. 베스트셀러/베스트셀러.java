import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            String[] books = new String[N];

            for (int i = 0; i < N; i++) {
                books[i] = br.readLine();
            }

            Arrays.sort(books);

            String result = books[0];
            int max = 1;
            int count = 1;

            for (int i = 1; i < N; i++) {
                if(books[i].equals(books[i-1])) {
                    count++;
                } else {
                    count = 1;
                }

                if(count > max) {
                    max = count;
                    result = books[i];
                }
            }

            bw.write(result);
            bw.flush();
        }
    }

}