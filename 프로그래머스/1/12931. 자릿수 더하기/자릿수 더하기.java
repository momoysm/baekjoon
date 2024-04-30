import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String trans = Integer.toString(n);
        
        for(int i=0; i<trans.length(); i++){
            answer += Integer.parseInt(trans.substring(i, i+1));
        }
        
        
        return answer;
    }
}