import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        String str = st.nextToken();
        for(int i=0; i<str.length(); i++){
            char temp = str.charAt(i);
            if(temp>=65 && temp<=90){
                System.out.print(String.valueOf(temp).toLowerCase());
            }
            else System.out.print(String.valueOf(temp).toUpperCase());
        }
    }
}