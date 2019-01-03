package com.findSource;

import java.util.ArrayList;
import java.util.List;

public class FindDatabaseSource {
	
	public FindDatabaseSource() {
		
	}
	
	public List<String> findDatabaseSource(List<String> sources) {
		List<String> databaseSource = new ArrayList<String>();
		CharSequence cs = "database",cs2 = "veri tabaný";
		for(int i=0;i<sources.size();i++) {
			if(sources.get(i).contains(cs)||sources.get(i).contains(cs2)) {
				databaseSource.add(sources.get(i));
			}
		}
		return databaseSource;
	}
}
