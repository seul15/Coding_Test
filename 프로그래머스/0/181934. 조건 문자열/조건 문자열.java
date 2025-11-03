class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if(eq.equals("=") && ineq.equals(">")) return (n>=m) ? 1:0;
        else if(eq.equals("=") && ineq.equals("<")) return (n<=m) ? 1:0;
        else if(eq.equals("!") && ineq.equals(">")) return (n>m) ? 1:0;
        else if(eq.equals("!") && ineq.equals("<")) return (n<m) ? 1:0;
        return 0;
    }
}