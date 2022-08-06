package com.hifumi123.ga4j.examples;

import com.hifumi123.ga4j.chromosome.Chromosome;
import com.hifumi123.ga4j.chromosome.GrayCodeChromosome;

public class GrayCodeChromosomeGenerator implements ChromosomeGenerator {

	private int lengthOfChromosome;
	
	public GrayCodeChromosomeGenerator(int lengthOfChromosome) {
		this.lengthOfChromosome = lengthOfChromosome;
	}
	
	@Override
	public Chromosome generateChromosome() {
		return new GrayCodeChromosome(lengthOfChromosome);
	}
}
