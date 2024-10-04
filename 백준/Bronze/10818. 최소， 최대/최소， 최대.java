
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int min = 0;
        int max = 0;
        int count = in.nextInt();
        int[] arr = new int[count];

        for(int i=0; i<count; i++) {
            arr[i] = in.nextInt();
        }

        for(int i=0; i<count; i++) {
            if(i == 0) {
                min = arr[i];
                max = arr[i];
            }else {
                if(min > arr[i]) {
                    min = arr[i];
                }
                if(max < arr[i]) {
                    max = arr[i];
                }
            }
        }

        System.out.println(min + " " + max);

    }
}