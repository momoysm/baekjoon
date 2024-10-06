import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for(int i=0; i<count; i++) {
            String[] arr = br.readLine().split(" ");

            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            int result = 1;
            for(int j=0; j<b; j++){
                result = (result * a) % 10;
            }
            if (result == 0) {
                System.out.println("10");
            } else{
                System.out.println(result);
            }
        }
    }
}