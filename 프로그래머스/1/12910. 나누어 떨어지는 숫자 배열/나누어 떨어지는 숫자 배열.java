class Solution {
    public int[] solution(int[] arr, int divisor) {
        int count = 0;
        int number = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                count++;
            }
        }
        
        if(count == 0){
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[count];
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] % divisor == 0){
                answer[number] = arr[i];
                number++;
            }
        }
        
        for(int i=0; i<count; i++){
            for(int j=i+1; j<count; j++){
                if(answer[i] > answer[j]){
                    int tmp = answer[i];
                    answer[i] = answer[j];
                    answer[j] = tmp;
                }
            }
        }
        
        return answer;
    }
}