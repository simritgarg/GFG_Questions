//{ Driver Code Starts


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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution
{
    public int[] AllPrimeFactors(int N)
    {
        List<Integer> primeFactors = new ArrayList<>();
        if (N % 2 == 0) {
            primeFactors.add(2);
            while (N % 2 == 0) {
                N /= 2;
            }
        }
        for (int i = 3; i * i <= N; i += 2) {
            if (N % i == 0) {
                primeFactors.add(i);
                while (N % i == 0) {
                    N /= i;
                }
            }
        }
        if (N > 1) {
            primeFactors.add(N);
        }
        int[] result = new int[primeFactors.size()];
        for (int i = 0; i < primeFactors.size(); i++) {
            result[i] = primeFactors.get(i);
        }
        return result;
    }
}