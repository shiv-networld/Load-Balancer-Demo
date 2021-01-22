package com.loadbalancer.demo.algorithms;

import java.util.List;
import java.util.Random;

import com.loadbalancer.demo.vo.Box;
/**
 * Random load algorithm
 * 
 * @author Shivakumar.D
 */
public class RandomLoadBalancer implements LoadBalancer {

	@Override
	public void execute(List<Box> boxList, List<String> inputs) {
		Random random = new Random();
		inputs.stream().forEach(input -> {
			int boxNumber = random.nextInt(boxList.size());
			Box box = boxList.get(boxNumber);
			box.addToBox(input);
		});
	}

}
