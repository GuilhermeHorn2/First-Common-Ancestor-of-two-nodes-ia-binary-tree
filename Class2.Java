package misc;

import java.util.ArrayList;

import misc.Graph_1.Node;

public class Binary_tree {

	   public static class Node{
	    	public int _id;
	    	public ArrayList<Node> adj;
	    	public int marked = 0;
	    	public int value;
	    	
	    	public Node(int id,int val) {
	    		_id = id;
	    		value = val;
	    		adj = new ArrayList<>();
	    		adj.add(0,null);
	    		adj.add(1,null);
	    		adj.add(2,null);
	    	
	    	}
	    	
	    	public String toString() {
	    		return "{id:" + _id + " / value:" + value + "}";
	    	}
	    	
	    	public void set_value(int v) {
	    		value = v;
	    	}
	    	
		    public Node left() {
		    	if(this.adj.get(0) != null) {
		    		return this.adj.get(0);
		    	}
		    	return null;
		    }
		    public Node right() {
		    	if(this.adj.get(1) != null) {
		    		return this.adj.get(1);
		    	}
		    	return null;
		    }
		    
		    public Node get_parent(){
		    	if(this.adj.get(2) != null){
		    		return this.adj.get(2);
		    	}
		    	return null;
		    }
		    
	    	
	    }
	    
	    public ArrayList<Node> nodes;
	    
	    public Binary_tree() {
	    	nodes = new ArrayList<>();
	    }
	    
	    public void add(int i,int val) {
	    	Node novo = new Node(i,val);
	    	nodes.add(novo);
	    }
	    
	    public void link_left(int id1,int id2){
	    	Node n = nodes.get(id1);
	    	n.adj.remove(0);
	    	n.adj.add(0, nodes.get(id2));
	        Node r = nodes.get(id2);
	        if(r.adj.get(2) == null) {
	        	r.adj.remove(2);
	        	r.adj.add(2,n);
	        }
	    }
	    
	    public void link_right(int id1,int id2) {
	    	Node n = nodes.get(id1);
	    	n.adj.remove(1);
	    	n.adj.add(1,nodes.get(id2));
	    	Node r = nodes.get(id2);
	    	if(r.adj.get(2) == null) {
	    		r.adj.remove(2);
	    		r.adj.add(2,n);
	    	}
	    }
	    
	    
	    public Node get_node(int i) {
	    	return nodes.get(i);
	    }
	    
	    public ArrayList<Node> get_adj(Node n){
	    	return n.adj;
	    }
	    
	    
	    /*Find first common ancestor of two nodes*/
	    
	    //Now you cannot use the link to the parent
	    
	    /*
	     *   Check if p and q are descendants of the left subtree and the
             right subtree. If they are descendants of different subtrees, then the current node is the
             first common ancestor. If they are descendants of the same subtree, then that subtree
             holds the first common ancestor. 
	     */
	    
	    public boolean is_ancestor(Node a,Node b){
	    	//returns true if node a is ancestor of node b	    	
	    	//I want to get to b,without having to access a parent,just right and left
	    	
	    	if(a == b) {
	    		return true;
	    	}
	    	if(a.left() == null && a.right() == null){
	    		return false;
	    	}
	    	
	    	
	    	else {
	    		
	    		if(a.left() != null && is_ancestor(a.left(), b) == true) {
	    			return true;
	    		}
	    		if(a.right() != null && is_ancestor(a.right(),b) == true) {
	    			return true;
	    		}
	    		
	    	}
	        return false;	
	    	}
	    
	    public Node first_common_ancestor(Node n,Node a,Node b){
	    	boolean a_left = false;
	    	boolean a_right = false;
	    	boolean b_left = false;
	    	boolean b_right = false;
	    	
	    	if(n.left() != null) {
	    		a_left = is_ancestor(n.left(),a);
	    		b_left = is_ancestor(n.left(),b);
	    	}
	    	if(n.right() != null){
	    		a_right = is_ancestor(n.right(),a);
	    		b_right = is_ancestor(n.right(),b);;
	    	}
	    	
	    	
	    	Node k = null;
	    	
	    	if(a_left == true && b_right == true) {
	    		//a and b come from distinct subtrees
	    		return n;
	    	}
	    	if(a_right == true && b_left == true){
	    		//a and b come from distinct subtrees
	    		
	    		return n;
	    	}
	    	
	    	
	    	else{
	    		
	    		if(a_left == true && b_left == true){
	    			k = first_common_ancestor(n.left(),a,b);
	    		}
	    		else if(a_right == true && b_right == true) {
	    			 k = first_common_ancestor(n.right(),a,b);
	    		}	
	    	}
	    	
	        return k;
	    	
	    	
	    	
	    	
	    }
	    
	    
	    	
	    }
	   	

