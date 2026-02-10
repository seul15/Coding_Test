import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] check ={{1,2,3,4,5},{2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] scores = {0,0,0};
        
        for(int j=0; j<answers.length; j++){
            for(int i=0; i<3; i++){
                if(answers[j] == check[i][j%check[i].length]) scores[i]++;
            }
        }
        
        int maxValue = 0;
        for(int i=0; i<3; i++){
            maxValue = Math.max(maxValue,scores[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(maxValue == scores[i]) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}