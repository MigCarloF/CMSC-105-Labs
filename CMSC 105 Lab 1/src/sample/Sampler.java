package sample;

import java.util.ArrayList;

public interface Sampler {
	public ArrayList<Data> sample(ArrayList<Data> population, int amount);
}
