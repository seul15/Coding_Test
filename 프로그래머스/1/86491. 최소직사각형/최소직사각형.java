class Solution {
    public int solution(int[][] sizes) {
        int height =0;
        int width =0;
        for(int[] s : sizes){
            int h = Math.min(s[0],s[1]);
            int w = Math.max(s[0],s[1]);
            
            height = Math.max(height,h);
            width = Math.max(width, w);
        }
        return height*width;
    }
}