//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int capacity = Integer.parseInt(br.readLine());
            String[] valInput = br.readLine().split(" ");
            String[] wtInput = br.readLine().split(" ");

            int[] val = new int[valInput.length];
            int[] wt = new int[wtInput.length];

            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            System.out.println(Solution.knapsack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int[][] dp = new int[wt.length+1][W+1];
        // for(int[] i: dp){
        //     Arrays.fill(i,-1);
        // }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return solve(W,0,val,wt,dp);
    }
    static int solve(int W, int idx, int[] val, int[] wt, int[][] dp){
        if(idx==wt.length) return 0;
        if(dp[idx][W] != -1) return dp[idx][W];
        int pick = 0;
        if(W>=wt[idx]){
            pick = val[idx] + solve(W-wt[idx],idx+1,val,wt,dp);
        }
        int skip =solve(W,idx+1,val,wt,dp);
        return dp[idx][W] = Math.max(pick,skip);
    }
}
