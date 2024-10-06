import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        for(int i=1; i<=8; i++) {
            String row = br.readLine();

            if(i%2 != 0) {
                for(int j=0; j<row.length(); j++) {
                    if(row.charAt(j) == 'F' && j % 2 == 0){
                        count++;
                    }
                }
            } else {
                for(int j=0; j<row.length(); j++) {
                    if(row.charAt(j) == 'F' && j % 2 != 0){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}