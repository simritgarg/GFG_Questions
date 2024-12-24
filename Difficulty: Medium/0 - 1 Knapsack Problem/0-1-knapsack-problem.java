//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            // Read capacity
            int capacity = Integer.parseInt(br.readLine());

            // Read values
            String[] valInput = br.readLine().split(" ");
            int[] val = new int[valInput.length];
            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            // Read weights
            String[] wtInput = br.readLine().split(" ");
            int[] wt = new int[wtInput.length];
            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            // Call the knapSack function and print the result
            System.out.println(Solution.knapSack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        int n = wt.length;
        int[][] dp = new int[n+1][capacity+1];
        for(int i=0;i<=wt.length;i++){
            for(int j=0;j<=capacity;j++){
                dp[i][j] = -1;
            }
        }
        return ways(capacity,0,val,wt,dp);
    }
    static int ways(int capacity, int idx, int val[], int wt[], int[][] dp){
        if(capacity == 0) return 0;
        if(idx == wt.length) return 0;
        if(dp[idx][capacity]!=-1) return dp[idx][capacity];
        int pick = 0;
        if(wt[idx]<=capacity){
            pick = val[idx] + ways(capacity-wt[idx],idx+1,val,wt,dp);
        }
        int skip = ways(capacity,idx+1,val,wt,dp);
        dp[idx][capacity] = Math.max(pick,skip);
        return dp[idx][capacity];
        
        
    }
}
