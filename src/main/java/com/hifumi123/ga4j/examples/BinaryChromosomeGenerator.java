package com.hifumi123.ga4j.examples;

import com.hifumi123.ga4j.chromosome.BinaryChromosome;
import com.hifumi123.ga4j.chromosome.Chromosome;

public class BinaryChromosomeGenerator implements ChromosomeGenerator {
	
	private int lengthOfChromosome;

	public BinaryChromosomeGenerator(int lengthOfChromosome) {
		this.lengthOfChromosome = lengthOfChromosome;
	}

	@Override
	public Chromosome generateChromosome() {
		return new BinaryChromosome(lengthOfChromosome);
	}
}
