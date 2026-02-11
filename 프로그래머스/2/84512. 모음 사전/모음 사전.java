class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] weight = {781,156,31,6,1};
        String vowels = "AEIOU";
        
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            int idx = vowels.indexOf(c);
            answer += idx * weight[i];
        }
        
        answer += word.length();
        
        return answer;
    }
}