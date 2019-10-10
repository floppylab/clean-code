package floppylab.matchsticks;

import java.util.Scanner;

public class Matchsticks {
    
    static int s = 21;
    static boolean c = true;
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
	    Scanner sc = new Scanner(System.in);
	    System.out.println("there are 21 matchsticks on the table");
	    System.out.println("computer's first");
	
	    while (s != 0) {
	        if (c) {
	        	System.out.println("computer's thinking");
	            int r = (s - 1) % 4;
	            int t = (r == 0)? 1 : r;
	
	            System.out.println("computer takes " + t);
	            takeOrEnd(t);
	            c = !c;
	
	        } else {
	        	System.out.println("it is your turn");
	            int t;
	
	            do {
	                    System.out.println("you can take 1, 2 or 3!");
	                    System.out.println("so how many sticks will you take?");
	                t = sc.nextInt();
	            } while (!(t == 1 || t == 2 || t == 3));
	
	            takeOrEnd(t);
	            c = !c;
	        }
	
	        printSticks();
	    }
	    sc.close();
	}
	
	static void takeOrEnd(int t) {
	    if (s - t <= 0) {
	    	System.out.println("game over");
	    	System.out.println("the winner is " + ((c) ? "you" : "computer"));
	        s = 0;
	    } else {
	        s -= t;
	    }
	}
	
	static void printSticks() {
		System.out.println("there are "+s+" matchstick(s) on the table");
		int i = 0;
		while (i++<s) { System.out.print("|"); }
		System.out.println("");
	}

}
