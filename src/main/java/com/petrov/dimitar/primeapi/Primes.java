package com.petrov.dimitar.primeapi;

import java.util.List;
import java.util.Objects;

public class Primes {

    private List<Integer> primes;

    public Primes() {}

    public Primes(List<Integer> primes) {
        this.primes = primes;
    }

    public List<Integer> getPrimes() {
        return primes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Primes primes1 = (Primes) o;
        return Objects.equals(primes, primes1.primes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primes);
    }
}
