package com.hifumi123.ga4j.examples.djf2;

import com.hifumi123.ga4j.AbstractIndividual;
import com.hifumi123.ga4j.chromosome.Chromosome;

public class CustomIndividual extends AbstractIndividual {

	public CustomIndividual(Chromosome chromosome) {
		super(chromosome);
	}
	
	public double decodeX1() {
		int t = getChromosome().decode(0, 10);
		
		return 4.096 * t / 1023 - 2.048;
	}
	
	public double decodeX2() {
		int t = getChromosome().decode(10, 20);
		
		return 4.096 * t / 1023 - 2.048;
	}

	@Override
	protected void customClone(AbstractIndividual newIndividual) {}
}
