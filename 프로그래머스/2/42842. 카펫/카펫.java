class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int check = brown/2 +2;
        int total = brown + yellow;
        
        int limit = (int)Math.floor(Math.sqrt(total));
        for(int i=3; i<= limit; i++){
            if(total % i == 0){
                if((total/i) + i == check){
                    answer[0] = total/i;
                    answer[1] = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}