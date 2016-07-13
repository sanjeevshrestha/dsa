/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Least Recently Used cache
 * @author sanjeev
 */

class Node
{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + "key=" + key + ", value=" + value + ", prev=" + prev + ", next=" + next + '}';
    }
    
    
}
public class LRU {
    
    Map<Integer,Node> cacheMap =new HashMap<>();
    
    int capacity;
    
    Node head;
    Node end;
    

    public LRU() {
    head=null;
    end=null;
    }
    

    public LRU(int capacity) {
        this.capacity = capacity;
        head=null;
        end=null;
    }

    public void setHead(Node n)
    {
        n.next=head;
        n.prev=null;
        
        if(head!=null)
        {
            n.prev=head.prev;
        }
        head=n;
        
        if(end==null)
        {
            end=head;
        }
    }
    
    public void remove(Node n)
    {
        if(n.prev!=null)
        {
            n.prev.next=n.next;
        }
        else
        {
            head=n.next;
        }
        
        if(n.next!=null)
        {
            n.next.prev=n.prev;
        }
        else
        {
            head=n.prev;
        }
        
        
    }
    
    
    public int get(int key)
    {
        if(cacheMap.containsKey(key))
        {
            Node n= cacheMap.get(key);
            int val=n.value;
            
           remove(n);
           setHead(n);
            
           return val;
           
        }
       return -1;
    }
    
    public void set(int key,int val)
    {
        
    }
    
    
    
}