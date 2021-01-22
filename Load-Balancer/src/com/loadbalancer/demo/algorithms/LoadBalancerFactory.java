package com.loadbalancer.demo.algorithms;
/**
 * Factory for getting algorithm
 * 
 * @author Shivakumar.D
 */
public class LoadBalancerFactory {
	
	private static LoadBalancerFactory loadBalancerFactory;
	
	private LoadBalancerFactory() {
		
	}
	
	public static synchronized LoadBalancerFactory getInstance() {
		if(loadBalancerFactory == null) {
			loadBalancerFactory = new LoadBalancerFactory();
		}
		return loadBalancerFactory; 
	}

	public LoadBalancer getLoadBalancer(String loadBalancer) {
		if(loadBalancer == null || loadBalancer.isEmpty()) {
			return null;
		}
		if(loadBalancer.equalsIgnoreCase("Random")) {
			return new RandomLoadBalancer();
		} else if(loadBalancer.equalsIgnoreCase("RoundRobin")) {
			return new RoundRobinLoadBalancer();
		}
		
		return null;
	}
}