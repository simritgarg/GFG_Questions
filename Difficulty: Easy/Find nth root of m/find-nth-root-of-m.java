//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthRoot(n, m);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int nthRoot(int n, int m) {
        int left = 1;
        int right = m;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(power(mid,n) == m) return mid;
            else if(power(mid,n)<m) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
    public int power(int x, int n){
        long result  = 1;
        while(n>0){
            if(n%2==1){ // odd
                result = x*result;
                n -= 1;
            }
            else{ // even
                x = x*x;
                n /= 2;
            }
        }
        
        return (int) result;
    }
}