//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.DivCountSum(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int DivCountSum(int n)
    {
        int count = 0;
        for(int i=1;i<=n;i++){
            // int c = 0;
            // for(int j=1;j<=i;j++){
            //     if(n%j==0){
            //         c++;
            //     }
            // }
            // count += c;
            count += (n / i);
        }
        return count;
    }
}