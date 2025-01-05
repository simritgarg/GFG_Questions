//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
        int n = arr.length;
        int i = 0;
        int max = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int j=0;j<n;j++){
            mp.put(arr[j],mp.getOrDefault(arr[j],0)+1);
            if(mp.size()>2){
                mp.put(arr[i],mp.get(arr[i])-1);
                if(mp.get(arr[i])==0){
                    mp.remove(arr[i]);
                }
                i++;
            }
            max = Math.max(max,j-i+1);
        }
        return max;
    }
}