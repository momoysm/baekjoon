import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int x = in.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        for(int j : arr) {
            if(j<x){
                System.out.print(j + " ");
            }
        }

    }
}