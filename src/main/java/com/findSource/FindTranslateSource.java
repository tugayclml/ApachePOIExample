package com.findSource;

import java.util.List;
import java.util.ArrayList;

public class FindTranslateSource {
	
	public FindTranslateSource() {
		
	}
	
	public List<String> findTranslateSource(List<String> sources){
		List<String> translateSource = new ArrayList<String>();
		CharSequence cs = "Çev.",cs2="Trans.";
		
		for(int i=0;i<sources.size();i++) {
			if(sources.get(i).contains(cs)||sources.get(i).contains(cs2)) {
				translateSource.add(sources.get(i));
			}
		}
		
		return translateSource;
	}
	
}
