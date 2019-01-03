package com.findSource;

import java.util.ArrayList;
import java.util.List;

public class FindEditorSource {
	
	public FindEditorSource() {
		
	}
	
	public List<String> findEditorSource(List<String> sources){
		List<String> editorSource = new ArrayList<String>();
		
		CharSequence cs = "Ed.",cs2="Eds.";
		
		for(int i=0;i<sources.size();i++) {
			if(sources.get(i).contains(cs)||sources.get(i).contains(cs2)) {
				editorSource.add(sources.get(i));
			}
		}
		
		return editorSource;
	}
	
}
