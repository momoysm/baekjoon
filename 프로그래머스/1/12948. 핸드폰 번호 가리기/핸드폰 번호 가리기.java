class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        String star = phone_number.substring(0, phone_number.length() - 4);
        String openNumber = phone_number.substring(phone_number.length() - 4, phone_number.length());
        
        star = star.replaceAll("[0-9]", "*");
        
        answer = star + openNumber;
        
        return answer;
    }
}