package com.findSource;

import java.util.ArrayList;
import java.util.List;

public class FindThesisSource {
	
	public FindThesisSource() {
		
	}
	
	public List<String> findThesisSource(List<String> sources){
		List<String> thesisSource = new ArrayList<String>();
		CharSequence cs="Üniversitesi" , cs2="University",cs3="tezi",cs4="thesis";
		for(int i=0;i<sources.size();i++) {
			if(sources.get(i).contains(cs)||sources.get(i).contains(cs2)) {
				if(sources.get(i).contains(cs3)||sources.get(i).contains(cs4)) {
					thesisSource.add(sources.get(i));
				}
			}
		}
		return thesisSource;
	}
	
}
