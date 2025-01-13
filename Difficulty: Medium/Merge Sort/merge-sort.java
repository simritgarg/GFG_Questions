//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    void mergeSort(int arr[], int l, int r) {
        if(l<r){
            int mid = l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merger(arr,l,mid,r);
        }
        
    }
    void merger(int[] arr, int l, int mid, int r){
        int[] mergerArr = new int[r-l+1];
        int idx1=l;
        int idx2=mid+1;
        int idx=0;
        while(idx1<=mid && idx2<=r){
            if(arr[idx1]<arr[idx2]){
                mergerArr[idx] = arr[idx1];
                idx++;
                idx1++;
            }
            else{
                mergerArr[idx] = arr[idx2];
                idx++;
                idx2++;
            }
        }
        while(idx1<=mid){
            mergerArr[idx] = arr[idx1];
            idx++;
            idx1++;
        }
        while(idx2<=r){
            mergerArr[idx] = arr[idx2];
            idx++;
            idx2++;
        }
        for(int i=0,j=l;i<mergerArr.length;i++,j++){
            arr[j] = mergerArr[i];
        }
    }
}
