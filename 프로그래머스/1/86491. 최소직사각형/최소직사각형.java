class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max_v = 0;
        int min_h = 0;
        
        for(int i=0; i<sizes.length; i++){
            int v = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            max_v = Math.max(v, max_v);
            min_h = Math.max(h, min_h);
        }
        
        return answer = max_v * min_h;
    }
}