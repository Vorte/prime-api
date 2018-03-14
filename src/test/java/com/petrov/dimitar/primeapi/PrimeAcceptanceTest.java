package com.petrov.dimitar.primeapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PrimeAcceptanceTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private Primes expected;

    @Before
    public void setUp() {
        expected = new Primes(Arrays.asList(2, 3, 5, 7, 11, 13));
    }

    @Test
    public void getPrimes_noParam_ok() {
        ResponseEntity<Primes> entity = restTemplate.getForEntity("/primes/13", Primes.class);

        assertThat(entity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(entity.getBody(), equalTo(expected));
    }

    @Test
    public void getPrimes_SOE_ok() {
        ResponseEntity<Primes> entity = restTemplate.getForEntity("/primes/13?algorithm=SOE", Primes.class);

        assertThat(entity.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(entity.getBody(), equalTo(expected));
    }

    @Test
    public void getPrimes_invalidAlgorithm_badRequest() {
        ResponseEntity<Primes> entity = restTemplate.getForEntity("/primes/13?algorithm=QWE", Primes.class);

        assertThat(entity.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }

    @Test
    public void getPrimes_invalidMaxValue_badRequest() {
        ResponseEntity<Primes> entity = restTemplate.getForEntity("/primes/a1", Primes.class);

        assertThat(entity.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
    }
}
