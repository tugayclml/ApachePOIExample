package com.findSource;

import java.util.ArrayList;
import java.util.List;

public class FindEncyclopediaSource {
	
	public FindEncyclopediaSource() {
		
	}
	
	public List<String> findEncyclopediaSource(List<String> sources){
		List<String> encyclopediaSource = new ArrayList<String>();
		CharSequence cs="i�inde",cs2="��inde";
		for(int i=0;i<sources.size();i++) {
			if(sources.get(i).contains(cs)||sources.get(i).contains(cs2)) {
				encyclopediaSource.add(sources.get(i));
			}
		}
		return encyclopediaSource;
	}
	
	public Boolean isEncyclopediaReference(String reference) {
		CharSequence cs="i�inde",cs2="��inde";
		if(reference.contains(cs) || reference.contains(cs2)) {
			return true;
		}else {
			return false;
		}
	}
}
