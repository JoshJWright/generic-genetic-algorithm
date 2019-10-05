package com.joshjwright.algorithms;

import com.joshjwright.genetics.Individual;
import com.joshjwright.genetics.Population;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TournamentSelectionWithMutation<M extends Individual<S, T>, S, T extends Comparable> implements IGeneticAlgorithm{

    private int numFitnessEvals = 0;

    private T maxFitness;
    private T minFitness;

    @SuppressWarnings("unchecked")
    @Override
    public void execute(Population population) {
        log.info("Performing Tournament Selection on population of size {}", population.getPopulationSize());
        log.info("Evaluating current population fitness...");
        for (Individual i : population.getPopulation()) {
            i.calculateFitness();
            numFitnessEvals++;
            log.info("Evaluated fitness for {}", Long.toHexString(i.getId()));
            if (maxFitness == null || i.getFitness().compareTo(maxFitness) > 0) {
                maxFitness = (T) i.getFitness();
            } else if (minFitness == null || i.getFitness().compareTo(minFitness) < 0) {
                minFitness = (T) i.getFitness();
            }
        }

        log.info("Finished evaluating population:\n\tMax: {}\n\tMin: {}", maxFitness.toString(), minFitness.toString());

        while (maxFitness.compareTo(population.getGoalFitness()) < 0) {
            //DO algorithm
        }

    }
}
