import java.util.*;

public class Main {
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        int result1;

        if(x == y){
            if(y == z){//x=y=z
                System.out.println(10000 + (x*1000));
            }else if(y != z){//x=y!=z
                System.out.println(1000 + (x*100));
            }
        }else if(x != y){
            if(y == z){//x!=y=z
                System.out.println(1000 + (y*100));
            }else if(y != z){
                if(x == z){//x=z!=y
                    System.out.println(1000 + (x*100));
                }else if(x != z){//x!=y!=z
                    result1 = (x > y) ? x : y;
                    int result2 = z > result1 ? z : result1;
                    System.out.println(result2*100);
                }
            }
        
        }
    }
}