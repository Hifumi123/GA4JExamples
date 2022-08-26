package com.hifumi123.ga4j.examples.djf2;

import com.hifumi123.ga4j.AbstractIndividual;
import com.hifumi123.ga4j.Evaluator;

public class CustomEvaluator implements Evaluator {

	@Override
	public void evaluate(AbstractIndividual individual) {
		CustomIndividual ci = (CustomIndividual) individual;
		
		double x1 = ci.decodeX1();
		double x2 = ci.decodeX2();
		
		double fitness = 100 * (x1 * x1 - x2) * (x1 * x1 - x2) + (1 - x1) * (1 - x1);

		ci.setFitness(fitness);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return this;
	}
}
