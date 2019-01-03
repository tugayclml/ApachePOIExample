package com.findSource;

import java.util.ArrayList;
import java.util.List;

public class NoAuthorNoDateSource {
	
	public NoAuthorNoDateSource() {
		
	}
	
	public List<String> findNoAuthorNoDate(List<String> sources){
		List<String> noAuthorNoDateSource = new ArrayList<String>();
		CharSequence cs="(b.t.)",cs2="(n.d.)";
		for(int i=0;i<sources.size();i++) {
			if(sources.get(i).contains(cs)||sources.get(i).contains(cs2)) {
				noAuthorNoDateSource.add(sources.get(i));
			}
		}
		return noAuthorNoDateSource;
	}
}
