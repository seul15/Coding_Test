import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int num = (arr.length+1)/2;
        int[] numbers = new int[num];
        String[] operators = new String[arr.length-num];
        
        for(int i=0; i<arr.length; i++){
            if(i%2 == 0) numbers[i/2] = Integer.valueOf(arr[i]);
            else operators[i/2] = arr[i];
        }
        
        int[][] max = new int[num][num];
        int[][] min = new int[num][num];
        for(int i=0; i<num; i++){
            Arrays.fill(max[i],Integer.MIN_VALUE);
            Arrays.fill(min[i],Integer.MAX_VALUE);
        }

        for(int i=0; i<num; i++){
            max[i][i] = numbers[i];
            min[i][i] = numbers[i];
        }
        
        for(int len=2; len<=num; len++){
            for(int i=0; i<=num-len; i++){
                int j = i+len -1;
                for(int k= i; k<j; k++){
                    if(operators[k].equals("+")){
                        // max 배열 
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k+1][j]);
                        // min 배열
                        min[i][j] = Math.min(min[i][j], max[i][k] + min[k+1][j]);
                    }
                    else{ // -일 경우
                        // max 배열
                        max[i][j] = Math.max(max[i][j],max[i][k] - min[k+1][j]);
                        // min 배열
                        min[i][j] = Math.min(min[i][j],min[i][k] - max[k+1][j]);    
                    }
                }
            }
        }
        
        return max[0][num-1];
    }
}