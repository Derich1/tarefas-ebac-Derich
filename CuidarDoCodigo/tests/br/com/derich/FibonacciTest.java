package br.com.derich;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {

    @Test
    public void testEncontrarElemento_PrimeiroElemento(){
        Fibonacci fib = new Fibonacci();
        int n = 1;
        int x = Fibonacci.encontrarElementoPD(n);
        int target = Fibonacci.encontrarElemento(n);
        assertEquals(1, target);
    }

    @Test
    public void testEncontrarElemento_SegundoElemento(){
        Fibonacci fib = new Fibonacci();
        int n = 2;
        int x = Fibonacci.encontrarElementoPD(n);
        int target = Fibonacci.encontrarElemento(n);
        assertEquals(1, target);
    }
}
