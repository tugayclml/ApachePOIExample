package com.puctuation;

import java.util.Vector;

public class CounterPunctuation {
	
	public CounterPunctuation() {
		
	}
	
	public int CounterPunctuations(String text,CharSequence cs) {
		int counter=0;
		String d = text;
		Vector vector = new Vector();
		
		int n=1;
		
		for(int i=0;i<d.length()-n+1;i++) {
			String x = d.substring(i, i+n);
			boolean found = false;
			for(int k=0;k<vector.size();k++) {
				Counter c = (Counter)vector.elementAt(k);
				if(x.equals(c.ngram)) {
					found = true;
					c.num++;
				}
			}
			if(!found) {
				vector.add(new Counter(1,x));
			}
		}
		
		for(int i=0;i<vector.size();i++) {
			Counter c = (Counter)vector.elementAt(i);
			if(c.ngram.equals(cs)) {
				counter = c.num;
			}
		}
		return counter;
	}
}
