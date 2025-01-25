//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();
        double[][] res = new double[n][2];
        for(int i=0;i<n;i++){
            res[i][0] = (double) val.get(i)/wt.get(i);
            res[i][1] = i;
        }
        Arrays.sort(res,(a,b) -> Double.compare(b[0],a[0]));
        double total = 0.0;
        for(double[] item: res){
            int idx = (int) item[1];
            if(capacity>= wt.get(idx)){
                total += val.get(idx);
                capacity -= wt.get(idx);
            }
            else{
                total += item[0]*capacity;
                break;
            }
        }
        return total;
    }
}