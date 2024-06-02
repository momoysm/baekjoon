class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for(int i=0; i+p.length() <= t.length(); i++){
            Long a = Long.parseLong(t.substring(i, i+p.length()));
            
            if(a <= Long.parseLong(p)){
                answer++;
            }
            
        }
        
        return answer;
    }
}