//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length-1;
        int floor = -1, ceil = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(x>=arr[mid]){
                floor = arr[mid];
                l = mid+1;
            } 
            else r = mid-1;
            
        }
        l = 0;
        r = arr.length-1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] >= x) {
                ceil = arr[mid];
                r = mid - 1; 
            } else {
                l = mid + 1;
            }
        }
        return new int[]{floor, ceil};
        
    }
}
