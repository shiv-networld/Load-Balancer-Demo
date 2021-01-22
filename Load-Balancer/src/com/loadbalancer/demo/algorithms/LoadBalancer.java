package com.loadbalancer.demo.algorithms;

import java.util.List;

import com.loadbalancer.demo.vo.Box;
/**
 * @author Shivakumar.D
 */
public interface LoadBalancer {

		public void execute(List<Box> boxList, List<String> inputs);
}
