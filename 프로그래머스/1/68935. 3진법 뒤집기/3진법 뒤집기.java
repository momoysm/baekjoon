class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String a = "";
        
        while(n >= 1){
            a += n%3;
            n /= 3;
        }
        
        for(int i=0; i < a.length(); i++){
            
            int tmp = Integer.parseInt(a.substring(a.length() - i - 1, a.length() - i));
            answer += tmp * Math.pow(3, i);
            
        }
        
        
        return answer;
    }
}