//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			
			Solution obj = new Solution();
			
			System.out.println(obj.reverseBits(n));
            
            t--;
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        while(n>0){
            rev <<= 1;
            if((n&1) == 1){
                rev |= 1;
            }
            n>>=1;
        }
        return rev;
    }
}