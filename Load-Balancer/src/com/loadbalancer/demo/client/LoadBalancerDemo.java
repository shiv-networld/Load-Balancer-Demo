package com.loadbalancer.demo.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.loadbalancer.demo.algorithms.LoadBalancer;
import com.loadbalancer.demo.algorithms.LoadBalancerFactory;
import com.loadbalancer.demo.vo.Box;

/**
 * Demonstrating Load Balancer
 * 
 * @author Shivakumar.D
 *
 */
public class LoadBalancerDemo {

	public static final String RANDOM_ALGO = "Random";
	public static final String ROUND_ROBIN_ALGO = "RoundRobin";
	
	public static void main(String[] args) {

		List<Box> boxList = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		/** Get number of Boxes  */
		getNumberOfBoxes(scan, boxList);
				
		/** Get Algorithm  */
		Optional<String> balancerToRun = getRequiredAlgorithm(scan);
		
		/** Get Inputs */
		List<String> inputs = getInputs(scan);
		
		/** Getting Load-balancer */
		LoadBalancerFactory factory = LoadBalancerFactory.getInstance();
		LoadBalancer loadBalancer = factory.getLoadBalancer(balancerToRun.get());

		/** Execute based on algorithm  */
		loadBalancer.execute(boxList, inputs);
		print(boxList);
		
		scan.close();
	}

	/**
	 * @param scan
	 * @return
	 */
	private static List<String> getInputs(Scanner scan) {
		/** No. of inputs  */
		System.out.print("\nEnter number of inputs: ");
		int noOfInputs = scan.nextInt();
		validateInputNumber(noOfInputs);

		System.out.println("\nPlease enter all "+ noOfInputs +" input strings:");
		List<String> inputs = new ArrayList<>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		IntStream.range(0, noOfInputs).forEach(i -> inputs.add(sc.nextLine()));

		System.out.println("\n\nYour Inputs =>" + inputs);

		return inputs;
	}

	/**
	 * @param scan
	 * @return
	 */
	private static Optional<String> getRequiredAlgorithm(Scanner scan) {
		System.out.println("Press 1 for Random");
		System.out.println("Press 2 for Round-Robin");
		System.out.print("Select which Algorithm to use: ");
		int algoToRun = scan.nextInt();
		Optional<String> balancerToRun = Optional.empty();

		if(algoToRun == 1) {
			balancerToRun = Optional.of(RANDOM_ALGO);
		} else if(algoToRun == 2) {
			balancerToRun = Optional.of(ROUND_ROBIN_ALGO);
		}

		if(balancerToRun.isPresent()) {
			System.out.println("\nYou have chosed "+ balancerToRun.get() +" algorithm.");
		} else {
			balancerToRun = Optional.of(ROUND_ROBIN_ALGO);
			System.out.println("Invalid Option! Defaulted to Round-Robin Algorithm.");
		}
		
		return balancerToRun;
	}

	/**
	 * @param boxList
	 * @return
	 */
	private static void getNumberOfBoxes(Scanner scan, List<Box> boxList) {
		System.out.print("Please enter number of Boxes: ");
		int noOfBoxes = scan.nextInt();
		validateInputNumber(noOfBoxes);

		IntStream.range(0, noOfBoxes).forEach(i -> boxList.add(new Box()));
		System.out.println("\nYou have selected " + noOfBoxes + " boxes.\n\n");
	}
	
	/**
	 * 
	 * @param boxList
	 */
	public static void print(List<Box> boxList) {
		System.out.println("\n\nAfter load balancing....\n");
		boxList.stream().forEach(box -> System.out.println("Box "+ (boxList.indexOf(box)+1) + " has => " +box.getBoxContent()));
	}

	/**
	 * 
	 * @param num
	 */
	public static void validateInputNumber(int num) {
		if(num <= 0) {
			System.out.println("\nInvalid, should be more than 0");
			System.exit(1);
		}
	}
}