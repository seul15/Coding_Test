import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = Integer.parseInt(br.readLine());
        
        if(ans%2==1) System.out.println(ans+ " is odd");
        else System.out.println(ans+ " is even");
    }
}