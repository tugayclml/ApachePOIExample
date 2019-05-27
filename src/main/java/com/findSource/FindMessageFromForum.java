package com.findSource;

import java.util.List;
import java.util.ArrayList;

public class FindMessageFromForum {
	
	public FindMessageFromForum() {
		
	}
	
	public List<String> findMessageFromForum(List<String> sources){
		List<String> forumSource = new ArrayList<String>();
		CharSequence cs = "[Msg-";
		
		for(int i=0;i<sources.size();i++) {
			if(sources.get(i).contains(cs)) {
				forumSource.add(sources.get(i));
			}
		}
		return forumSource;
	}
	
	public Boolean isMessageFromForumReference(String reference) {
		CharSequence cs = "[Msg-";
		if(reference.contains(cs)) {
			return true;
		}else {
			return false;
		}
	}

}
