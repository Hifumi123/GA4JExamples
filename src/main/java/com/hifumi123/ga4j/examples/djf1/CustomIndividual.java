package com.hifumi123.ga4j.examples.djf1;

import com.hifumi123.ga4j.AbstractIndividual;
import com.hifumi123.ga4j.chromosome.Chromosome;

public class CustomIndividual extends AbstractIndividual {

	private double objectiveFunctionValue;
	
	public CustomIndividual(Chromosome chromosome) {
		super(chromosome);
		
		objectiveFunctionValue = 0;
	}
	
	public double decodeX1() {
		int t = getChromosome().decode(0, 10);
		
		return 10.24 * t / 1023 - 5.12;
	}
	
	public double decodeX2() {
		int t = getChromosome().decode(10, 20);
		
		return 10.24 * t / 1023 - 5.12;
	}
	
	public double decodeX3() {
		int t = getChromosome().decode(20, 30);
		
		return 10.24 * t / 1023 - 5.12;
	}

	@Override
	protected void customClone(AbstractIndividual newIndividual) {
		((CustomIndividual) newIndividual).objectiveFunctionValue = objectiveFunctionValue;
	}

	public double getObjectiveFunctionValue() {
		return objectiveFunctionValue;
	}

	public void setObjectiveFunctionValue(double objectiveFunctionValue) {
		this.objectiveFunctionValue = objectiveFunctionValue;
	}
}
