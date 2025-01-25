//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
class Solution {

    // public int minCoins(int coins[], int sum) {
    //     int[] dp = new int[sum+1];
    //     Arrays.fill(dp,-1);
    //     int res =  totalCoins(coins,sum, dp);
    //     return (res == Integer.MAX_VALUE) ? -1 : res;
    // }
    // public int totalCoins(int[] coins,int sum, int[]dp){
    //     if(sum == 0) return 0;
    //     if(sum < 0) return Integer.MAX_VALUE;
    //     if(dp[sum] != -1) return dp[sum];
    //     int min = Integer.MAX_VALUE;
    //     for(int coin: coins){
    //         int res = totalCoins(coins, sum - coin, dp);
    //         if (res != Integer.MAX_VALUE) {
    //             min = Math.min(min, res + 1);
    //         }
    //     }
    //     dp[sum] = min;
    //     return dp[sum];
    // }
    
    public int minCoins(int coins[], int sum) {
    int[] dp = new int[sum + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i <= sum; i++) {
        for (int coin : coins) {
            if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }

    return dp[sum] == Integer.MAX_VALUE ? -1 : dp[sum];
}

}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends