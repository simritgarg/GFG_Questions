//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String [] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-- > 0) {
			int N = sc.nextInt();
			Solution obj = new Solution();
			obj.toBinary(N);
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	void toBinary(int N) {
	    int[] arr = new int[32];
	    int idx = 0;
		if(N==0){
		    System.out.print(0);
		    return;
		}
		while(N>0){
		    arr[idx] = N%2;
		    idx++;
		    N/=2;
		}
		for (int i = idx - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
	}
}