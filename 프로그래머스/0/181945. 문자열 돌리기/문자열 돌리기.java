import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] ans = str.toCharArray();
        
        for(char c: ans){
            System.out.println(c); 
        }

    }
}