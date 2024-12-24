//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        Boolean[][] dp = new Boolean[arr.length+1][target+1];
        if(checkTarget(arr,0,target,dp)) return true;
        else return false;
    }
    static boolean checkTarget(int[] arr, int idx, int target, Boolean[][] dp){
        if(target==0) return true;
        if(idx == arr.length) return false;
        boolean pick = false;
        if(dp[idx][target] != null) return dp[idx][target];
        if(arr[idx]<=target){
            pick = checkTarget(arr,idx+1,target-arr[idx],dp);
        }
        boolean skip = checkTarget(arr,idx+1,target,dp);
        dp[idx][target] = pick||skip;
        return dp[idx][target];
    }
}