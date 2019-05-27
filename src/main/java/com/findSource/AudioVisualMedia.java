package com.findSource;

import java.util.ArrayList;
import java.util.List;

public class AudioVisualMedia {

	public AudioVisualMedia() {
		
	}
	
	public List<String> findAudioVisualMediaSource(List<String> sources){
		List<String> audioVisualSource = new ArrayList<String>();
		List<CharSequence> charSequences = new ArrayList<CharSequence>();
		charSequences.add("[Film]");
		charSequences.add("(Yapýmcý)");
		charSequences.add("(Yönetmen)");
		charSequences.add("[Televizyon programý]");
		charSequences.add("[CD]");
		charSequences.add("[DVD]");
		charSequences.add("[Motion picture]");
		charSequences.add("(Director)");
		charSequences.add("(Producer)");
		charSequences.add("[Television broadcast]");
		
		int counter = 0;
		
		for(int i=0;i<sources.size();i++) {
			 for(int k=0;k<charSequences.size();k++) {
				 if(sources.get(i).contains(charSequences.get(k))) {
					 counter +=1;
				 }
			 }
			 if(counter>0) {
				 audioVisualSource.add(sources.get(i));
			 }
		}
		
		return audioVisualSource;
	}
	
	public Boolean isAudioVisualReference(String reference) {
		List<CharSequence> charSequences = new ArrayList<CharSequence>();
		charSequences.add("[Film]");
		charSequences.add("(Yapýmcý)");
		charSequences.add("(Yönetmen)");
		charSequences.add("[Televizyon programý]");
		charSequences.add("[CD]");
		charSequences.add("[DVD]");
		charSequences.add("[Motion picture]");
		charSequences.add("(Director)");
		charSequences.add("(Producer)");
		charSequences.add("[Television broadcast]");
		
		for(int i=0;i<charSequences.size();i++) {
			if(reference.contains(charSequences.get(i))) {
				return true;
			}
		}
		
		return false;
	}
	
}
