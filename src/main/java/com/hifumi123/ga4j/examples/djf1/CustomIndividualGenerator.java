package com.hifumi123.ga4j.examples.djf1;

import com.hifumi123.ga4j.AbstractIndividual;
import com.hifumi123.ga4j.IndividualGenerator;
import com.hifumi123.ga4j.examples.ChromosomeGenerator;

public class CustomIndividualGenerator implements IndividualGenerator {
	
	private ChromosomeGenerator chromosomeGenerator;

	public CustomIndividualGenerator(ChromosomeGenerator chromosomeGenerator) {
		this.chromosomeGenerator = chromosomeGenerator;
	}

	@Override
	public AbstractIndividual generateIndividual() {
		return new CustomIndividual(chromosomeGenerator.generateChromosome());
	}
}
