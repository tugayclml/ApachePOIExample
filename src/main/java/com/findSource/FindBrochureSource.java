package com.findSource;

import java.util.ArrayList;
import java.util.List;

public class FindBrochureSource {
	
	public FindBrochureSource() {
		
	}
	
	public List<String> findBrochureSource(List<String> sources){
		List<String> brochureSource = new ArrayList<String>();
		CharSequence cs="[Broþür]",cs2="[Brochure]";
		for(int i=0;i<sources.size();i++) {
			if (sources.get(i).contains(cs)||sources.get(i).contains(cs2)) {
				brochureSource.add(sources.get(i));
			}
		}
		return brochureSource;
	}

}
