package com.loadbalancer.demo.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.loadbalancer.demo.algorithms.RandomLoadBalancer;
import com.loadbalancer.demo.algorithms.RoundRobinLoadBalancer;
import com.loadbalancer.demo.vo.Box;

/**
 * @author Shivakumar.D
 */
public class LoadBalancerTests {

	@Test
	public void roundRobin_test() {
		
		List<String> inputs = Arrays.asList("aa","bb","cc","dd","ee");
		List<Box> boxList= Arrays.asList(new Box(), new Box(), new Box());
		
		RoundRobinLoadBalancer rrLoad = new RoundRobinLoadBalancer();
				
		rrLoad.execute(boxList, inputs);
		
		int size = boxList.get(0).getBoxContent().size() + boxList.get(1).getBoxContent().size() 
					+ boxList.get(2).getBoxContent().size();

		assertEquals("RoundRobin count is fine", inputs.size(), size);
	}
	
	@Test
	public void random_loader_test() {
		
		List<String> inputs = Arrays.asList("aa","bb","cc","dd","ee");
		List<Box> boxList= Arrays.asList(new Box(), new Box(), new Box());
		
		RandomLoadBalancer random = new RandomLoadBalancer();
				
		random.execute(boxList, inputs);
		
		int size = boxList.get(0).getBoxContent().size() + boxList.get(1).getBoxContent().size() 
					+ boxList.get(2).getBoxContent().size();

		assertEquals("Random count is fine", inputs.size(), size);
	}
}