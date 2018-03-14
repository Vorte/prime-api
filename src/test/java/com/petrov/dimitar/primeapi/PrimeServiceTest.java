package com.petrov.dimitar.primeapi;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class PrimeServiceTest {

    private PrimeService primeService;

    @Before
    public void setup() {
        this.primeService = new PrimeService();
    }

    @Test
    public void getPrimesBruteForce() throws Exception {
        Primes primes = primeService.getPrimesBruteForce(10);

        assertThat(primes.getPrimes(), equalTo(Arrays.asList(2, 3, 5, 7)));
    }

    @Test
    public void getPrimesSieveOfEratosthenes() throws Exception {
        Primes primes = primeService.getPrimesSieveOfEratosthenes(10);

        assertThat(primes.getPrimes(), equalTo(Arrays.asList(2, 3, 5, 7)));
    }

    @Test
    public void getPrimesBruteForce_singleValue() throws Exception {
        Primes primes = primeService.getPrimesBruteForce(2);

        assertThat(primes.getPrimes(), equalTo(Arrays.asList(2)));
    }

    @Test
    public void getPrimesSieveOfEratosthenes_singleValue() throws Exception {
        Primes primes = primeService.getPrimesSieveOfEratosthenes(2);

        assertThat(primes.getPrimes(), equalTo(Arrays.asList(2)));
    }

}