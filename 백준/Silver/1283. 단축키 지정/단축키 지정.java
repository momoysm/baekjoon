import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static Set<String> shortcut = new HashSet<>();
    private static String[] result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        result = new String[N];

        for (int i = 0; i < N; i++) {

            String text = br.readLine();
            String[] arr = text.split(" ");

            // 1️⃣ 각 단어 첫 글자
            for (String word : arr) {

                if (addShortcut(word.charAt(0))) {

                    result[i] = replaceChar(text, word, 0);
                    break;
                }
            }

            // 2️⃣ 각 단어 내부 글자
            for (String word : arr) {

                if (result[i] != null) break;

                for (int j = 1; j < word.length(); j++) {

                    if (addShortcut(word.charAt(j))) {

                        result[i] = replaceChar(text, word, j);
                        break;
                    }
                }
            }

            if (result[i] == null) {
                result[i] = text;
            }
        }

        for (String text : result) {
            bw.write(text + "\n");
        }

        bw.flush();
    }

    private static boolean addShortcut(char c) {

        String s = Character.toString(c).toLowerCase();
        return shortcut.add(s);
    }

    private static String replaceChar(String text, String word, int idx) {

        int start = text.indexOf(word);
        int pos = start + idx;

        return text.substring(0, pos)
                + "[" + text.charAt(pos) + "]"
                + text.substring(pos + 1);
    }
}