package sample;

import java.util.ArrayList;
import java.util.Random;

public class Systematic implements Sampler {
	private ArrayList<Data> sample;

	@Override
	public ArrayList<Data> sample(ArrayList<Data> population, int amount) {
		sample = new ArrayList<Data>();
		int start = ((new Random()).nextInt(population.size())); // this
																	// randomizes
																	// the start
																	// value for
																	// Systematic
																	// sampling
		int k = start;
		int interval = (int) (Math.ceil(population.size() / amount));
		for (int i = 0; i < amount; i++) {
			while (true) {
				if (sample.contains(population.get(k)) == false) {
					sample.add(population.get(k));
					k = (k + interval) % population.size();
					break;
				} else {
					k++;
				}
			}
		}
		return sample;
	}

}
