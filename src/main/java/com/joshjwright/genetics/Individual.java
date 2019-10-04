package com.joshjwright.genetics;

import lombok.Getter;

import java.util.Random;

public abstract class Individual<S, T> {

    /**
     * The objects genetic state
     */
    @Getter
    private final S state;
    /**
     * The id of this individual
     */
    @Getter
    private long id;
    /**
     * The object representing the individuals fitness
     */
    @Getter
    private T fitness;

    public Individual(S state) {
        this.state = state;
        this.id = new Random().nextLong();
    }

    /**
     * Static wrapper for crossing a with b.
     *
     * @param a parent 1
     * @param b parent 2
     * @return The crossed individual.
     */
    public static Individual crossover(Individual a, Individual b) {
        return a.crossoverWith(b);
    }

    /**
     * Crossover this individual with the other parent
     *
     * @param b parent 2
     * @return The crossed individual
     */
    public abstract Individual crossoverWith(Individual b);

    /**
     * Apply a mutation to this individual and return a new individual.
     *
     * @return
     */
    public abstract Individual mutate();

    /**
     * Get the fitness value
     *
     * @return
     */
    public abstract T getFitness();

    /**
     * Calculate the fitness value
     */
    public abstract void calculateFitness();

    /**
     * Print the individuals state.
     */
    @Override
    public abstract String toString();
}
