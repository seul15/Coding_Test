import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            sb.append(str).append("\n");
        }
        
        System.out.println(sb);
    }
}