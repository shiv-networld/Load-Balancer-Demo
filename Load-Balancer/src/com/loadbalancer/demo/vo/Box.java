package com.loadbalancer.demo.vo;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Shivakumar.D
 */
public class Box {

	List<String> boxContent = new ArrayList<>();

	public List<String> getBoxContent() {
		return boxContent;
	}

	public void setBoxContent(List<String> boxContent) {
		this.boxContent = boxContent;
	}
	
	public void addToBox(String input) {
		boxContent.add(input);
	}
}
