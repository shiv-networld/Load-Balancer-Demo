package com.loadbalancer.demo.algorithms;

import java.util.List;

import com.loadbalancer.demo.vo.Box;
/**
 * Round Robin Load Algorithm
 * 
 * @author Shivakumar.D
 */
public class RoundRobinLoadBalancer implements LoadBalancer {

	int counter = 0;
	
	@Override
	public void execute(List<Box> boxList, List<String> inputs) {
		inputs.stream().forEach(input -> {
			Box box = boxList.get(counter);
			box.addToBox(input);

			counter += 1; 
			if(counter == boxList.size()) {
				counter = 0;
			}
		});
	}
}
