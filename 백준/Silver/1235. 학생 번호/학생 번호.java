import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];

            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine();
            }

            int result = arr[0].length();

            for (int i = 1; i <= arr[0].length(); i++) {
                if(isAble(i, arr)) {
                    result = i;
                    break;
                }
            }

            bw.write(result + "");
            bw.flush();
        }
    }

    private static boolean isAble(int index, String[] arr) {
        Set<String> set = new HashSet<>();
        for (String s : arr) {
            set.add(s.substring(s.length() - index));
        }

        if(set.size() == arr.length) {
            return true;
        }

        return false;
    }
}