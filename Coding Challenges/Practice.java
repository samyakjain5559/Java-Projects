package practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.*; 
import java.util.*; 
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Practice {
	
	public static void main(String[] args) {
		
		int min = 1;
	    int max = 6;
	    
	    ArrayList<Integer> scores_list = new ArrayList<Integer>();
	    
	    for(int j = 0; j < 1000; j++) {
	    	
	    	// New Game Setup
	    	int score = 0;
	    	// 5 dices
		    int random_int1 = (int)Math.floor(Math.random()*(max-min+1)+min);
		    int random_int2 = (int)Math.floor(Math.random()*(max-min+1)+min);
		    int random_int3 = (int)Math.floor(Math.random()*(max-min+1)+min);
		    int random_int4 = (int)Math.floor(Math.random()*(max-min+1)+min);
		    int random_int5 = (int)Math.floor(Math.random()*(max-min+1)+min);
		    
		    ArrayList<Integer> myNumbers = new ArrayList<Integer>();
		    myNumbers.add(random_int1);
		    myNumbers.add(random_int2);
		    myNumbers.add(random_int3);
		    myNumbers.add(random_int4);
		    myNumbers.add(random_int5);
	    	
	    	// Run till game is over
	    	while(myNumbers.isEmpty() == false) {
	    		
		    	if(myNumbers.contains(3)) {
				    for(int i = 0; i < myNumbers.size(); i++ ) {
				    	if(myNumbers.get(i) == 3) {
				    		myNumbers.remove(i);
				    		score = score + 0;
				    	}
				    }
			    }
		    	
			    // now 3,s are removed
			    if(myNumbers.contains(3) == false) {
			    	
			    	// sub dices with new random numbers
			    	int sizeleft = myNumbers.size();
			    	myNumbers.clear();  // refreshing list
			    	for(int i = 0; i < sizeleft; i++) {
			    		myNumbers.add((int)Math.floor(Math.random()*(max-min+1)+min));
			    	}
			    	
			    	// Continue if game over
			    	if(myNumbers.contains(3) || myNumbers.isEmpty()) {
			    		continue;
			    	}
			    	
			    	int minimum = myNumbers.get(0);
			    	int minindex = 0;
			    	for(int i = 0; i < myNumbers.size(); i++) {
			    		if (minimum > myNumbers.get(i)) {
			                minimum = myNumbers.get(i);
			                minindex = i;
			    		}
			    	}
			    	myNumbers.remove(minindex);
			    	score = score + minimum;
			    }
			    
		    }
	    	scores_list.add(score);
	    	
	    }
	    
	    
	    System.out.println("Scores of 1000 Games are --" + scores_list);
	    
	    for(int h = 0; h < 30; h++ ) {
	    	System.out.println("Total " + h+ " occured "+ Collections.frequency(scores_list, h));
	    }
	}
	
	

}
