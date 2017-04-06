package sample;

import java.util.ArrayList;
import java.util.Random;

public class Simple implements Sampler {
	private ArrayList<Data> sample;

	public ArrayList<Data> sample(ArrayList<Data> population, int amount) {
		sample = new ArrayList<Data>();
		Random rand = new Random();
		for (int i = 0; i < amount; i++) {
			while (true) {
				int n = rand.nextInt(population.size());
				if (sample.contains(population.get(n)) == false) {
					sample.add(population.get(n));
					break;
				}
			}
		}
		return sample;
	}
}
