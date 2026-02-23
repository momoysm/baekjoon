import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            double ax = Double.parseDouble(st.nextToken());
            double ay = Double.parseDouble(st.nextToken());
            double bx = Double.parseDouble(st.nextToken());
            double by = Double.parseDouble(st.nextToken());
            double cx = Double.parseDouble(st.nextToken());
            double cy = Double.parseDouble(st.nextToken());

            // 세 점의 외적이 0일 때 직선이다. 따라서 평행사변형을 그릴 수 없다.
            // 외적 공식 (x2−x1)(y3−y1)−(y2−y1)(x3−x1)
            if( (bx - ax) * (cy - ay) - (by - ay) * (cx - ax) == 0 ) {
                bw.write("-1");
                bw.flush();
                return;
            }

            double p1 = getPerimeter(ax, ay, bx, by, cx, cy); // A 기준: AB, AC변 (BC가 대각선)
            double p2 = getPerimeter(bx, by, ax, ay, cx, cy); // B 기준: BA, BC변 (AC가 대각선)
            double p3 = getPerimeter(cx, cy, ax, ay, bx, by); // C 기준: CA, CB변 (AB가 대각선)

            double max = Math.max(p1, Math.max(p2, p3));
            double min = Math.min(p1, Math.min(p2, p3));

            bw.write(String.format("%.9f", max - min));
            bw.flush();
        }
    }

    private static double getPerimeter(
        double x1, double y1
        , double x2, double y2
        , double x3, double y3
    ) {
        double side1 = dist(x1, y1, x2, y2);
        double side2 = dist(x1, y1, x3, y3);

        return (side1 + side2) * 2;
    }

    private static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}