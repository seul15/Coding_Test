class Solution {
    public int solution(int a, int b) {
        String temp1=""; String temp2="";
        temp1 += a;
        temp1+=b;
        temp2+=b;
        temp2+=a;
        return (Integer.parseInt(temp1)>Integer.parseInt(temp2)) ? Integer.parseInt(temp1) : Integer.parseInt(temp2);
    }
}