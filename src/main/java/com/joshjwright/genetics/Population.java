package com.joshjwright.genetics;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Population<M extends Individual<S, T>, S, T extends Comparable> {

    @Getter
    private final int populationSize;
    @Getter
    private final M[] population;
    @Getter
    private final T goalFitness;

    @SuppressWarnings("unchecked")
    public Population(final int populationSize, final T goalFitness) {
        log.info("Creating population of size {}", populationSize);
        this.populationSize = populationSize;
        population = (M[]) new Individual[populationSize];
        for (int i = 0; i < populationSize; i++) {
            population[i] = (M) M.getRandom();
            log.debug("Created individual {} \n\tID: {}\n\t\t{}", i, Long.toHexString(population[i].getId()), population[i].toString());
        }
        this.goalFitness = goalFitness;
    }

    public M get(int index) {
        return population[index];
    }

    public M getRandom() {
        final Random r = new Random();
        return population[r.nextInt(populationSize)];
    }

    public void replace(M a, M b) {
        for (int i = 0; i < populationSize; i++) {
            if (population[i].equals(a)) {
                population[i] = b;
                log.debug("Replaced individual {} with individual {}.", a.getId(), b.getId());
                break;
            }
        }
    }
}
