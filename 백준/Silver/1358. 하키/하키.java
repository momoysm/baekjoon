import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int result = 0;

            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int p_x = Integer.parseInt(st.nextToken());
                int p_y = Integer.parseInt(st.nextToken());

                if(isInSquare(x, y, w, h, p_x, p_y)) {
                    result++;
                    continue;
                }

                if(isInCircle(x, y, h, p_x, p_y) || isInCircle(x + w, y, h, p_x, p_y)) {
                    result++;
                }
            }

            bw.write(result + "");
            bw.flush();

        }
    }

    private static boolean isInSquare(int x0, int y0, int w, int h, int x1, int y1) {

        return x0 <= x1 && x1 <= x0 + w && y0 <= y1 && y1 <= y0 + h;
    }

    private static boolean isInCircle(int x0, int y0, int h, int x1, int y1) {
        int r = h / 2;

        int centerY = y0 + r;

        int dx = x1 - x0;
        int dy = y1 - centerY;

        return (dx * dx) + (dy * dy) <= (r * r);
    }
}