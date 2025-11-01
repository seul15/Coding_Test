class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String ans = my_string.substring(0,s);
        ans += overwrite_string;
        if(overwrite_string.length()+s<my_string.length()){
            ans+=my_string.substring(s+overwrite_string.length(),my_string.length());
        }
        return ans;
    }
}