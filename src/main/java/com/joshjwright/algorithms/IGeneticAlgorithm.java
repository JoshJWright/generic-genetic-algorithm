package com.joshjwright.algorithms;

import com.joshjwright.genetics.Individual;
import com.joshjwright.genetics.Population;

public interface IGeneticAlgorithm<M extends Individual<S, T>, S, T extends Comparable> {

    public void execute(Population<M, S, T> population);

}
