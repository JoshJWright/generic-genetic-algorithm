package com.joshjwright.genetics;

import lombok.Getter;

import java.util.Random;

public abstract class Population<M extends Individual<S, T>, S, T> {

    @Getter
    private final int populationSize;
    private final M[] population;

    public Population(int populationSize) {
        this.populationSize = populationSize;
        //noinspection unchecked
        population = (M[]) new Individual[populationSize];
    }

    public M get(int index) {
        return population[index];
    }

    public M getRandom() {
        final Random r = new Random();
        return population[r.nextInt(populationSize)];
    }

    public void replace(M a, M b) {
        for(int i = 0; i < populationSize; i++) {
            if(population[i].equals(a)) {
                population[i] = b;
                break;
            }
        }
    }
}
