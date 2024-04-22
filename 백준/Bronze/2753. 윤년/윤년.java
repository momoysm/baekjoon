import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        int result = 0;

        if(year%4 == 0){ //4의 배수일 떄
            result = 1;
            if(year%100 == 0){ //4의 배수이면서 100의 배수일 떄
                result = 0;
                if(year%400 == 0){ //4의 배수이면서 100의 배수이면서 400의 배수일떄
                    result = 1;
                }
            }
        }else{
            result = 0;
        }

        System.out.println(result);
    }

}