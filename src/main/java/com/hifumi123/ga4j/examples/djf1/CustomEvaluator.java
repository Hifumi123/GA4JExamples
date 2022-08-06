package com.hifumi123.ga4j.examples.djf1;

import com.hifumi123.ga4j.AbstractIndividual;
import com.hifumi123.ga4j.Evaluator;

public class CustomEvaluator implements Evaluator {

	@Override
	public void evaluate(AbstractIndividual individual) {
		CustomIndividual ci = (CustomIndividual) individual;
		
		double x1 = ci.decodeX1();
		double x2 = ci.decodeX2();
		double x3 = ci.decodeX3();
		
		double ofv = x1 * x1 + x2 * x2 + x3 * x3;
		
		ci.setObjectiveFunctionValue(ofv);
		//ofv 的最大值为 78.64320000000001
		ci.setFitness(80 - ofv);
	}
}
