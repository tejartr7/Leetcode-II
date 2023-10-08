//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution g = new Solution();
            head = g.sortedInsert(head,k);
            
            printList(head); 
            t--;
        }
    } 
} 

// } Driver Code Ends


/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head1, int key) {
        // Add your code here.
        if(head1==null)
        return new Node(key);
        Node curr=head1;
        if(key<=head1.data)
        {
            Node temp=new Node(key);
            temp.next=head1;
            head1=temp;
            return head1;
        }
        Node prev=null;
        while(curr!=null)
        {
            Node next=curr.next;
            if(curr.data==key)
            {
                Node temp=new Node(key);
                curr.next=temp;
                temp.next=next;
                return head1;
            }
            else if(next!=null)
            {
                if(curr.data<key && next.data>key)
                {
                Node temp=new Node(key);
                curr.next=temp;
                temp.next=next;
                return head1;
                }
            }
            else
            {
                if(curr.data<key)
                {
                Node temp=new Node(key);
                curr.next=temp;
                temp.next=next;
                return head1;
                }
            }
            prev=curr;
            curr=curr.next;
        }
        if(prev.data<key)
        {
            prev.next=new Node(key);
        }
        return head1;
    }
}