class Solution {
    public String solution(int n) {
        String answer = "";
        String pattern1 = "수";
        String pattern2 = "박";
        
        for(int i=0; i < n; i++){
            if(i%2 == 0){
                answer += pattern1;
            }else{
                answer += pattern2;
            }
        }
        
        return answer;
    }
}