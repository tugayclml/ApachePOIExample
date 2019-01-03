package com.findSource;

import java.util.List;
import java.util.ArrayList;

public class FindWebSiteSource {

	public FindWebSiteSource() {
		
	}
	
	public List<String> findWebSiteSource(List<String> sources){
		List<String> webSiteSource = new ArrayList<String>();
		CharSequence cs = "http:",cs2 = "https:";
		
		for(int i=0;i<sources.size();i++) {
			if(sources.get(i).contains(cs)||sources.get(i).contains(cs2)) {
				webSiteSource.add(sources.get(i));
			}
		}
		return webSiteSource;
	}
	
}
