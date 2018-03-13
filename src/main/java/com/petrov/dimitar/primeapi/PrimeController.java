package com.petrov.dimitar.primeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeController {

    private PrimeService primeService;

    @Autowired
    public PrimeController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping(value = "/primes/{max}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Primes getPrimes(@PathVariable("max") int max,
                            @RequestParam(value = "algorithm", defaultValue = "BF") Algorithm algorithm) {

        if (algorithm == null || algorithm == Algorithm.BF) {
            return primeService.getPrimesBruteForce(max);
        }
        return primeService.getPrimesSieveOfEratosthenes(max);
    }




}

