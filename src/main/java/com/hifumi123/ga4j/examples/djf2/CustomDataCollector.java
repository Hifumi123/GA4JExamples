package com.hifumi123.ga4j.examples.djf2;

import java.util.ArrayList;
import java.util.List;

import com.hifumi123.ga4j.DataCollector;
import com.hifumi123.ga4j.Population;

public class CustomDataCollector implements DataCollector {
	
	private List<Double> bestFitnessList;
	
	private List<Double> meanFitnessList;
	
	private List<Double> worstFitnessList;
	
	public CustomDataCollector(int maxGeneration) {
		bestFitnessList = new ArrayList<Double>(maxGeneration + 1);
		meanFitnessList = new ArrayList<Double>(maxGeneration + 1);
		worstFitnessList = new ArrayList<Double>(maxGeneration + 1);
	}
	
	@Override
	public void collectData(Population population, int generation) {
		CustomIndividual first = (CustomIndividual) population.get(0);
		double sumFitness = first.getFitness();
		CustomIndividual best = first;
		CustomIndividual worst = first;
		
		for (int i = 1; i < population.size(); i++) {
			CustomIndividual ci = (CustomIndividual) population.get(i);
			
			if (ci.getFitness() > best.getFitness())
				best = ci;
			
			if (ci.getFitness() < worst.getFitness())
				worst = ci;
			
			sumFitness += ci.getFitness();
		}
		
		bestFitnessList.add(best.getFitness());
		meanFitnessList.add(sumFitness / population.size());
		worstFitnessList.add(worst.getFitness());
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
}
