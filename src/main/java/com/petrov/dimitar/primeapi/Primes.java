package com.petrov.dimitar.primeapi;

import java.util.List;

public class Primes {

    private List<Integer> primes;

    public Primes() {}

    public Primes(List<Integer> primes) {
        this.primes = primes;
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
