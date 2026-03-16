import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static int[] _switch;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            n = Integer.parseInt(br.readLine());
            _switch = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                _switch[i] = Integer.parseInt(st.nextToken());
            }

            m = Integer.parseInt(br.readLine());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int gender = Integer.parseInt(st.nextToken());
                int switchNo = Integer.parseInt(st.nextToken());

                switch(gender) {
                    case 1 :
                        processMale(switchNo);
                        break;
                    case 2 :
                        processFemale(switchNo);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(_switch[i]).append(" ");
                if(i % 20 == 0) {
                    sb.append("\n");
                }
            }

            bw.write(sb.toString());
            bw.flush();
        }
    }

    private static void processMale(int switchNo) {
        for (int i = switchNo; i <= n; i += switchNo) {
            doSwitch(i);
        }
    }

    private static void processFemale(int switchNo) {
        int count = 1;

        doSwitch(switchNo);

        while (switchNo + count <= n && switchNo - count > 0) {

            if (_switch[switchNo + count] == _switch[switchNo - count]) {
                doSwitch(switchNo + count);
                doSwitch(switchNo - count);
            }else {
                break;
            }

            count++;
        }
    }

    private static void doSwitch(int switchNo) {
        if (_switch[switchNo] == 0) {
            _switch[switchNo] = 1;
        } else {
            _switch[switchNo] = 0;
        }
    }
}