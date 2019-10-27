package floppylab.matchsticks;

import java.util.*;

public class Matchsticks {
    
    public static void main(String[] args) {

         int s,t,i,c,k;s = 21; //local integer variables
         boolean ct = true; // local boolean variable. initial value true
         String str,ing = ""; //string
        
	    Scanner sc = new Scanner(System.in);
	    System.out.println("there are 21 matchsticks on the table");
	    System.out.println("computer's first");
	
	    while (s != 0) {
	        if (ct) {
	        	System.out.println("computer's thinking");
	            k = (s - 1) % 4;
	            if (k == 0) t = 1; else t = k;
	           // t = (r == 0)? 1 : r;
	
	            System.out.println("computer takes " + t);
	            
	    	    //take or end
	            if (s - t <= 0) {
	    	    	System.out.println("game over");
	    	    	if (ct == true) str = "you"; else str = "computer";
	    	    	System.out.println("the winner is " + str);
	    	        s = 0;
	    	    } else {
	    	        s -= t;
	    	    }
	            
	            ct = !ct;
	
	        } else {
	        	System.out.println("it is your turn");
	
	            do {
	                System.out.println("you can take 1, 2 or 3!");
	                System.out.println("so how many sticks will you take?");
	                t = sc.nextInt();
	            } while (!(t == 1 || t == 2 || t == 3));
	
	            //take or end
	    	    if (s - t <= 0) {
	    	    	System.out.println("game over");
	    	    	System.out.println("the winner is " + ((ct) ? "you" : "computer"));
	    	        s = 0;
	    	    } else { s -= t; }
	    
	            ct = !ct; //negate variable
	        }
            // print sticks
			System.out.println("there are "+s+" matchstick(s) on the table");
			i = 0;
			while (i++<s) { System.out.print("|"); }
			System.out.println("");
	    }
	    sc.close();
	}

}
