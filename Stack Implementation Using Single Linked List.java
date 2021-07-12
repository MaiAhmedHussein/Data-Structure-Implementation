import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {
  
  /*** Removes the element at the top of stack and returnsthat element.
  * @return top of stack element, or through exception if empty
  */
  
  public Object pop();
  
  /*** Get the element at the top of stack without removing it from stack.
  * @return top of stack element, or through exception if empty
  */
  
  public Object peek();
  
  /*** Pushes an item onto the top of this stack.
  * @param object to insert*
  */
  
  public void push(Object element);
  
  /*** Tests if this stack is empty
  * @return true if stack empty
  */
  public boolean isEmpty();
  
  public int size();
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Node{
    Object data;
    Node next;
}


public class MyStack implements IStack {
     static Node top;
     static int size=0;  

    
     public void push(Object element){
        Node node = new Node();
        node.data = element;
        node.next = top;
        top = node;
        size++;
     }
    
    
     public Object pop(){
        if(top == null)
            throw new NullPointerException("Error");
        Node temp = top;
        top = top.next;
        size--;
        return temp.data;
     }
    
    
     public Object peek(){
        if(top == null)
            throw new NullPointerException("Error");
        return top.data;
     }
    
    
     public int size(){
        return size;
     }
     
    
     public boolean isEmpty(){
        return(size() == 0); 
     }
    
     public void show(){
        if(top == null){
            System.out.println("[]");
        }else{
        
            Node p = top;
            System.out.print("[");
            while(p.next!= null){
                System.out.print(p.data + ", ");
                p = p.next;
            }
            System.out.println(p.data + "]");
        }
    }
    
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        Scanner input =new Scanner(System.in);
        String sin =input.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        String option =input.nextLine();
        
        if (s.length != 1 || !(s[0].isEmpty())) { 
            for(int i = s.length-1; i >=0; i--){
             obj.push( Integer.parseInt(s[i]));
             
            }
        }
        
        try { 
          switch(option){
              case "push":{
                  int element = input.nextInt();
                  obj.push(element);
                  obj.show();
              };break;
              case "pop":{
                  obj.pop();
                  obj.show();
              };break;
              case "peek":{
                  System.out.println(obj.peek());
              };break;
              case "size":{
                  System.out.println(obj.size());
              };break;    
              case"isEmpty":{
                  if(obj.isEmpty()){
                       System.out.println("True");
                  }else{
                       System.out.println("False");
                  }
              };break;    
                  
          }
        }catch( NullPointerException ex) {
            System.out.print("Error");  
        }    
    }
}
