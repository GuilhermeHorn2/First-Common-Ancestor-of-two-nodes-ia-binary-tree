package misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import misc.Graph_1.Node;

import java.util.Date;

public class main_misc {
    
	
	public static void main(String[] args) {
	  
	
	Binary_tree b = new Binary_tree();
	b.add(0, 5);
	b.add(1, 7);
	b.add(2, 6);
	b.add(3, 4);
	b.add(4, 12);
	b.add(5, 3);
	b.add(6, 10);
	b.add(7, 7);
	
	b.link_left(0, 1);
	b.link_right(0, 5);
	
	b.link_left(1, 2);
	b.link_right(1, 3);
	
	b.link_left(2, 4);
	
	b.link_right(5, 6);
	
	b.link_left(6, 7);
	
	System.out.println(b.first_common_ancestor(b.get_node(4),b.get_node(7)));//should be the root node
	System.out.println(b.first_common_ancestor(b.get_node(4),b.get_node(3)));//should be the node with id 1
	
	}
		
	
	
		
	}
	
	
		
	
		

	
  
	
    
	
		

	

	
		
		
	

	
	
	
	
	
	
	
	
	

	


	
	

	
		
	
	


	

	
	


	
	
	

	


	
	

	
		
	
	


	

	
	

