package sample;

import java.util.ArrayList;
import java.util.LinkedList;

public class Stratified implements Sampler {
	private ArrayList<Data> sample;
	@SuppressWarnings("rawtypes")
	private ArrayList<LinkedList> strataList;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ArrayList<Data> sample(ArrayList<Data> population, int amount) {

		sample = new ArrayList<Data>();
		strataList = new ArrayList<LinkedList>();
		Boolean added = false;
		// leaves blank linkedlist for adding new element
		LinkedList<Data> tStrata;
		for (Data d : population) {
			added = false;
			for (LinkedList<Data> strata : strataList) {
				if (strata.getFirst().getValue().equals(d.getValue())) {
					strata.addFirst(d);
					added = true;
					break;
				}
			}
			if (added == false) {
				tStrata = new LinkedList<Data>();
				tStrata.addFirst(d);
				strataList.add(tStrata);
			}
		}
		Sampler simple = new Simple();
		ArrayList<Data> newStrata = new ArrayList(); // to be able to convert
														// LinkedList to
														// ArrayList
		int numberOfSamples;
		
		for (LinkedList<Data> strata : strataList) {
			newStrata.addAll(strata);
			numberOfSamples = (int) (((float) amount / 100.0) * (float) strata.size()); //For Floor
			//numberOfSamples = (int) Math.ceil((((float) amount / 100.0) * (float) strata.size())); //For Ceiling 
			if (numberOfSamples == 0) {
				numberOfSamples = 1;
			}
			sample.addAll(simple.sample(newStrata, numberOfSamples));
			newStrata.clear();
			System.out.println("n of " + strata.getFirst().getValue() + " = " + strata.size());
		}

		return sample;
	}
}
