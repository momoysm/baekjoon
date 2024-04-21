import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String[] c_alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int count = 0;

        for(int i=0; i<c_alphabet.length; i++){
            if(a.contains(c_alphabet[i])){
                a = a.replace(c_alphabet[i], "!");
            }
        }

        System.out.println(a.length());
    }

}