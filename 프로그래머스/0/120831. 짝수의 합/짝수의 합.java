class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=0; 2*i<=n; i++){
            answer += 2*i;
        }
        
        return answer;
    }
}