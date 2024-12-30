//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // HashSet<Integer> s =new HashSet<>();
        // for(int i: arr){
        //     s.add(i);
        // }
        // ArrayList<Integer> l = new ArrayList<>(s);
        // Collections.sort(l,Collections.reverseOrder());
        // if(l.size()>1){
        //     int res = l.get(1);
        //     return res;
        // }
        // else{
        //     return -1;
        // }
        TreeSet<Integer> s = new TreeSet<>();
        
        for(int i: arr){
            s.add(i);
        }
        int max = 0;
        for(int i: s){
            if(i>max){
                max = i;
            }
        }
        if(s.size()<2) return -1;
        s.pollLast();
        int secMax=0;
        for(int i: s){
            if(i>secMax){
                secMax = i;
            }
        }
        return secMax;
        
        
    }
}