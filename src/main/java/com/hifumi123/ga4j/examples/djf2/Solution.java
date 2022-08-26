package com.hifumi123.ga4j.examples.djf2;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.hifumi123.ga4j.Evaluator;
import com.hifumi123.ga4j.IndividualGenerator;
import com.hifumi123.ga4j.SimpleGeneticAlgorithm;
import com.hifumi123.ga4j.crossover.CrossoverOperator;
import com.hifumi123.ga4j.crossover.OnePointCrossover;
import com.hifumi123.ga4j.examples.BinaryChromosomeGenerator;
import com.hifumi123.ga4j.examples.ChromosomeGenerator;
import com.hifumi123.ga4j.mutation.MutationOperator;
import com.hifumi123.ga4j.mutation.SimpleMutation;
import com.hifumi123.ga4j.selection.ElitistProportionalModelSelection;
import com.hifumi123.ga4j.selection.SelectionOperator;

/**
 * 计算 De Jong 函数 F2（Rosenbrock 函数）的最大值。<br>
 * De Jong 函数 F2：<br>
 * f(x1, x2) = 100 * (x1^2-x2)^2 + (1 - x1)^2<br>
 * 条件为：<br>
 * -2.048 <= xi <= 2.048 (i = 1, 2)
 * 
 * @author Hifumi123
 *
 */
public class Solution {
	
	private void writeResultFile(CustomDataCollector dataCollector) {
		String fitnessesFilepath = "Fitnesses.csv";
		
		try {
			CSVPrinter printer = new CSVPrinter(new FileWriter(fitnessesFilepath), CSVFormat.EXCEL);
			printer.printRecord(dataCollector.getBestFitnessList());
			printer.printRecord(dataCollector.getMeanFitnessList());
			printer.printRecord(dataCollector.getWorstFitnessList());
			
			printer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		int populationSize = 80;
		int maxGeneration = 200;
		double probabilityOfCrossover = 0.6;
		double probabilityOfMutation = 0.001;
		
		ChromosomeGenerator chromosomeGenerator = new BinaryChromosomeGenerator(20);
		IndividualGenerator individualGenerator = new CustomIndividualGenerator(chromosomeGenerator);
		Evaluator evaluator = new CustomEvaluator();
		
		SelectionOperator selection = new ElitistProportionalModelSelection();
		CrossoverOperator crossover = new OnePointCrossover();
		MutationOperator mutation = new SimpleMutation();
		
		CustomDataCollector dataCollector = new CustomDataCollector(maxGeneration);
		
		SimpleGeneticAlgorithm ga = new SimpleGeneticAlgorithm(populationSize, maxGeneration, probabilityOfCrossover, probabilityOfMutation, individualGenerator, evaluator, selection, crossover, mutation);
		ga.setDataCollector(dataCollector);
		long startTime = System.currentTimeMillis();
		CustomIndividual individual = (CustomIndividual) ga.run();
		long duration = System.currentTimeMillis() - startTime;
		
		System.out.println("Population Size: " + populationSize);
		System.out.println("Max Generation: " + maxGeneration);
		System.out.println("Probability Of Crossover: " + probabilityOfCrossover);
		System.out.println("Probability Of Mutation: " + probabilityOfMutation);
		System.out.println("Duration: " + duration + " ms");
		System.out.println("X1 = " + individual.decodeX1());
		System.out.println("X2 = " + individual.decodeX2());
		System.out.println("Fitness = " + individual.getFitness());
		
		writeResultFile(dataCollector);
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.run();
	}
}
