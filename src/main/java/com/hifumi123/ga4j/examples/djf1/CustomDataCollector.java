package com.hifumi123.ga4j.examples.djf1;

import java.util.ArrayList;
import java.util.List;

import com.hifumi123.ga4j.AbstractIndividual;
import com.hifumi123.ga4j.DataCollector;

public class CustomDataCollector implements DataCollector {

	private List<Double> bestFitnessList;
	
	private List<Double> meanFitnessList;
	
	private List<Double> worstFitnessList;
	
	private List<List<List<Double>>> xsList;
	
	public CustomDataCollector(int maxGeneration) {
		bestFitnessList = new ArrayList<Double>(maxGeneration + 1);
		meanFitnessList = new ArrayList<Double>(maxGeneration + 1);
		worstFitnessList = new ArrayList<Double>(maxGeneration + 1);
		xsList = new ArrayList<List<List<Double>>>(maxGeneration + 1);
	}

	@Override
	public void collectData(List<AbstractIndividual> individuals, int generation) {
		CustomIndividual first = (CustomIndividual) individuals.get(0);
		double sumFitness = first.getFitness();
		CustomIndividual best = first;
		CustomIndividual worst = first;
		
		List<List<Double>> xsInGeneration = new ArrayList<List<Double>>(3);
		for (int i = 0; i < 3; i++) {
			List<Double> xs = new ArrayList<Double>(individuals.size());
			xsInGeneration.add(xs);
		}
		
		for (int i = 1; i < individuals.size(); i++) {
			CustomIndividual ci = (CustomIndividual) individuals.get(i);
			
			if (ci.getFitness() > best.getFitness())
				best = ci;
			
			if (ci.getFitness() < worst.getFitness())
				worst = ci;
			
			sumFitness += ci.getFitness();
			
			xsInGeneration.get(0).add(ci.decodeX1());
			xsInGeneration.get(1).add(ci.decodeX2());
			xsInGeneration.get(2).add(ci.decodeX3());
		}
		
		bestFitnessList.add(best.getFitness());
		meanFitnessList.add(sumFitness / individuals.size());
		worstFitnessList.add(worst.getFitness());
		
		xsList.add(xsInGeneration);
	}

	public List<Double> getBestFitnessList() {
		return bestFitnessList;
	}

	public List<Double> getMeanFitnessList() {
		return meanFitnessList;
	}

	public List<Double> getWorstFitnessList() {
		return worstFitnessList;
	}

	public List<List<List<Double>>> getXsList() {
		return xsList;
	}
}
