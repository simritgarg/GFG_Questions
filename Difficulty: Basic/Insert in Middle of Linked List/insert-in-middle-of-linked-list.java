//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Main {
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
            String inputLine = br.readLine().trim();

            // Check if the input line is not empty before processing
            if (!inputLine.isEmpty()) {
                String[] inputParts = inputLine.split(" ");
                for (String part : inputParts) {
                    if (!part.isEmpty()) { // Ensure the part is not empty
                        arr.add(Integer.parseInt(part));
                    }
                }
            }

            String xLine = br.readLine().trim();
            int x = 0;

            // Check if the xLine is not empty before parsing
            if (!xLine.isEmpty()) {
                x = Integer.parseInt(xLine);
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

            Solution ob = new Solution();
            Node ans = ob.insertInMiddle(head, x);
            printList(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    public int calculateLength(Node head){
        int count = 1;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
            
        }
        return count;
    }
    public Node insertInMiddle(Node head, int x) {
        Node newNode = new Node(x);
        if(head == null) return newNode;
        int len = calculateLength(head);
        int mid = len/2;
        Node curr = head;
        for(int i=1;i<mid;i++){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
        
    }
}