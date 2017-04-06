package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SamplerControl {
	public SamplerControl() {
		Boolean execute = false;
		String choice = "2";
		Sampler sampler = null;
		while (choice.equals("4") == false) {
			if (execute == false) {
				System.out.println("--Basic Sampling Methods--");
				System.out.println("");
				System.out.println("1) Simple Random Sampling");
				System.out.println("2) Systematic Sampling");
				System.out.println("3) Stratified Sampling");
				System.out.println("4) Quit");
				System.out.println("");
				System.out.print("Input number: ");
				choice = getInput();
				System.out.println("");
			}
			switch (choice) {
			case "1":
				sampler = new Simple();
				execute = true; // bypasses user input
				choice = "-1"; // bypasses choice to execute
				break;
			case "2":
				sampler = new Systematic();
				execute = true;
				choice = "-1";
				break;
			case "3":
				sampler = new Stratified();
				execute = true;
				choice = "-1";
				break;
			case "4":
				break;
			case "-1": // this code block executes the sampler. This will only
						// execute if execute is true and choice is set to -1
				if (execute) {
					ArrayList<Data> population = collectPopulation();
					int amount = (int) (Math.ceil(population.size() * 0.2));
					System.out.println("POPULATION");
					displayData(population);
					if (sampler instanceof Stratified) { // asks for sample
															// percent if
															// stratified
						System.out.println("Input percent of samples wanted per strata: ");
						amount = getInputInt();
						while (amount > 100 || amount < 0) {
							System.out.println("Please input from 1% to 100% only");
							amount = getInputInt();
						}
					} else { // asks for sample percent if not stratified
						System.out.println("Input sample size? 1. YES 2. NO (Will use 20% sample size): ");
						int toSampleSize = 0; // inputs for user input sample
												// size

						while (true) { // checks if input is 1 or 2 for sample
										// input
							toSampleSize = getInputInt();
							if (toSampleSize >= 1 && toSampleSize <= 2) {
								break;
							} else {
								System.out.print("Please use 1 or 2 only: ");
							}
						}

						if (toSampleSize == 1) {
							System.out.print("Input amount of samples wanted: ");
							amount = getInputInt();
							while (amount > population.size()) {
								System.out.println(population.size());
								System.out.println(
										"Error: Samples wanted is more than total population, Lower amount of samples wanted");
								System.out.println("");
								System.out.print("Input amount of samples wanted: ");
								amount = getInputInt();
							}

						}
					}
					ArrayList<Data> sample = sampler.sample(population, amount);
					System.out.println("\nPOPULATION");
					displayData(population);
					System.out.println("\nSAMPLE");
					displayData(sample);
					execute = false; // ends execution to allow user to reinput
				} else { // incase user inputs -1 manually
					System.out.println("\nPlease select only from the choices\n");
				}
			default:
				if (choice != "-1") {
					System.out.println("\nPlease select only from the choices\n");
				}
				break;
			}
			System.out.println("");
		}
	}

	private void displayData(ArrayList<Data> population) {
		ArrayList<Data> pop = (ArrayList<Data>) population.clone();
		Stack<String> value = new Stack<String>();
		Stack<Integer> index = new Stack<Integer>();
		Data current = null;
		while (pop.isEmpty() == false) {
			current = pop.remove(pop.size() - 1);
			value.push(current.getValue());
			index.push(current.getIndex());
		}

		while (index.isEmpty() == false) {
			System.out.print("INDEX " + (index.pop() + 1) + "\t\t");
		}

		System.out.println("");

		while (value.isEmpty() == false) {
			System.out.print(value.pop() + "\t\t");
		}

		System.out.println("");
	}

	private ArrayList<Data> collectPopulation() {

		ArrayList<Data> population = new ArrayList<Data>();
		System.out.println("Data type input");
		System.out.println("1. Integer");
		System.out.println("2. Character");
		System.out.print("Select data type: ");
		while (true) {
			int choice = getInputInt();
			if (choice == 1) { // CHECKED
				System.out.print("Input amount of population: ");
				int max = getInputInt();
				System.out.println("");
				System.out.println("Input sample frame: ");
				for (int i = 0; i < max; i++) {
					System.out.print((i + 1) + ") ");
					int value = getInputInt();
					String val = String.valueOf(value);
					population.add(new Data(val, i));
				}
				break;
			} else if (choice == 2) {
				System.out.print("Input amount of population: ");
				int max = getInputInt();
				System.out.println("");
				System.out.println("Input sample frame: ");
				for (int i = 0; i < max; i++) {
					System.out.print((i + 1) + ") ");
					char value = getInputChar();
					String val = String.valueOf(value);
					population.add(new Data(val, i));
				}
				break;
			} else {
				System.out.println("Input 1 or 2 only");
			}
		}

		return population;
	}

	public String getInput() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}

	public char getInputChar() {
		char chr = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			String str = sc.nextLine();
			if (str.length() == 1) { // checks if input is only 1 character
				chr = str.toCharArray()[0];
				break;
			} else {
				System.out.println("Input a character only: ");
			}
		}
		return chr;
	}

	public int getInputInt() {
		Scanner sc = new Scanner(System.in);
		int x = -1;
		while (true) {
			try {
				x = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Input nubmers only: ");
				sc.next();
			}
		}
		return x;
	}
}
