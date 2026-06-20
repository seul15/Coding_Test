class Solution {
    int answer=0;
    
    void dfs(int sum, int index, int[] numbers, int target){
        if(index == numbers.length){
            if(target == sum) answer++;
            return;
        }
        
        dfs(sum+numbers[index], index+1 , numbers, target);
        dfs(sum-numbers[index],index+1, numbers ,target);
    }
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(0,0,numbers,target);
        return answer;
    }
}