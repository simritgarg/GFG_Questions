//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        
System.out.println("~");
}
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    // MEMOIZATION
    public int minimumEnergy(int arr[],int N) {
        int[] dp = new int[N];
        Arrays.fill(dp,-1);
        return TotalEnergy(arr, arr.length-1, dp);
    }
    public static int TotalEnergy(int[] arr, int index, int[] dp){
        if(index==0) return 0;
        if(dp[index]!=-1) return dp[index];
        int step1 = TotalEnergy(arr,index-1,dp) + Math.abs(arr[index]-arr[index - 1]);
        int step2 = Integer.MAX_VALUE;
        if(index>1){
            step2 = TotalEnergy(arr,index-2,dp) + Math.abs(arr[index]-arr[index - 2]);
        }
        return dp[index] = Math.min(step1,step2);

        
    }

    //TABULATION
    // public int minimumEnergy(int arr[],int N) {
    //     int[] dp = new int[N];
    //     dp[0] = 0;
    //     for(int i=1;i<N;i++){
    //         int step1 = dp[i-1] + Math.abs(arr[i]-arr[i - 1]);
    //         int step2 = Integer.MAX_VALUE;
    //         if(i>1){
    //             step2 = dp[i-2] + Math.abs(arr[i]-arr[i - 2]);
    //         }
    //         dp[i] = Math.min(step1,step2);
    //     }
    //     return dp[N-1];
        
    // }
}
