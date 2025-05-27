class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int length = Integer.MAX_VALUE;
        int start=0; int end=0;
        int sum=0;
        while(true){
            if(sum >= k) sum-=sequence[start++];
            else if(end == sequence.length) break;
            else sum += sequence[end++];
            if(sum==k){
                if(end-start-1<length){
                    answer[0] = start;
                    answer[1] = end-1;
                    length = end-start-1;
                }
            }
        }
        return answer;
    }
}