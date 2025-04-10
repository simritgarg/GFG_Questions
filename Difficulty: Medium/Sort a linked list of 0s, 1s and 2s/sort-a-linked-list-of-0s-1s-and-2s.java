//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends

// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        if(head == null || head.next == null) return head;
        Node zeroesList = new Node(-1);
        Node onesList = new Node(-1);
        Node twosList = new Node(-1);
        
        Node zero = zeroesList;
        Node one = onesList;
        Node two = twosList;
        
        Node curr = head;
        while(curr != null){
            if(curr.data == 0){
                zero.next = curr;
                zero = zero.next;
            }
            else if(curr.data == 1){
                one.next = curr;
                one = one.next;
            }
            else{
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        
        zero.next = (onesList.next != null) ? onesList.next : twosList.next;
        one.next = twosList.next;
        two.next = null;
        
        return zeroesList.next;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends