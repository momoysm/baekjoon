import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String str = br.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char c : str.toCharArray()) {
                left.push(c);
            }

            int M = Integer.parseInt(br.readLine());
            while(M-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();

                if("L".equals(cmd)) {
                    if(!left.isEmpty()) right.push(left.pop());
                }
                else if("D".equals(cmd)) {
                    if(!right.isEmpty()) left.push(right.pop());
                }
                else if("B".equals(cmd)) {
                    if(!left.isEmpty()) left.pop();
                }
                else {
                    char c = st.nextToken().charAt(0);
                    left.push(c);
                }

            }

            StringBuilder sb = new StringBuilder();

            while (!left.isEmpty()) right.push(left.pop());
            while (!right.isEmpty()) sb.append(right.pop());
            
            bw.write(sb.toString());
            bw.flush();
        }
    }

}