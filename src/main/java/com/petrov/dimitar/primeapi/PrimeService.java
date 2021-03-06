package com.petrov.dimitar.primeapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PrimeService {

    public Primes getPrimesBruteForce(int max) {
        List<Integer> primes = new ArrayList<>();
        if (max >= 2) {
            primes.add(2);
        }

        for (int i = 3; i <= max; i += 2) {
            if (isPrimeBF(i)) {
                primes.add(i);
            }
        }

        return new Primes(primes);
    }

    public Primes getPrimesSieveOfEratosthenes(int max) {
        boolean primeArray[] = new boolean[max + 1];
        Arrays.fill(primeArray, true);

        for (int p = 2; p <= Math.sqrt(max); p++) {
            if (primeArray[p]) {
                for (int i = p * 2; i <= max; i += p) {
                    primeArray[i] = false;
                }
            }
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (primeArray[i]) {
                primeNumbers.add(i);
            }
        }

        return new Primes(primeNumbers);
    }

    private boolean isPrimeBF(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
