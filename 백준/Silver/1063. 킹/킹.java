import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String kingPos = st.nextToken();
            String stonePos = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            int kingCol = kingPos.charAt(0) - 'A'; // 열
            int kingRow = kingPos.charAt(1) - '1'; // 행

            int stoneCol = stonePos.charAt(0) - 'A'; // 열
            int stoneRow = stonePos.charAt(1) - '1'; // 행

            Map<String, int[]> dir = new HashMap<>();
            dir.put("R", new int[]{0, 1}); // {행, 열}
            dir.put("L", new int[]{0, -1});
            dir.put("B", new int[]{-1, 0});
            dir.put("T", new int[]{1, 0});
            dir.put("RT", new int[]{1, 1});
            dir.put("LT", new int[]{1, -1});
            dir.put("RB", new int[]{-1, 1});
            dir.put("LB", new int[]{-1, -1});

            while(N-- > 0) {
                String move = br.readLine();
                int[] d = dir.get(move);

                int nkRow = kingRow + d[0];
                int nkCol = kingCol + d[1];

                if(!isInBoard(nkRow, nkCol)) continue;

                if(nkRow == stoneRow && nkCol == stoneCol) {
                    int nsRow = stoneRow + d[0];
                    int nsCol = stoneCol + d[1];

                    if(!isInBoard(nsRow, nsCol)) continue;

                    stoneRow = nsRow;
                    stoneCol = nsCol;
                }
                kingRow = nkRow;
                kingCol = nkCol;
            }

            bw.write((char)(kingCol + 'A') + "" + (char)(kingRow + '1') + "\n");
            bw.write((char)(stoneCol + 'A') + "" + (char)(stoneRow + '1'));
            bw.flush();
        }
    }

    private static boolean isInBoard(int row, int col) {
        return (0 <= row && row < 8) && (0 <= col && col < 8);
    }
}