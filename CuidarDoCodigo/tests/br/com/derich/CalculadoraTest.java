package br.com.derich;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    @Test
    public void testAdicionar_HappyPath(){
        Calculadora cal = new Calculadora();
        int soma = cal.adicionar(1, 2);
        assertEquals(3, soma);
    }

    @Test
    public void testSubtrair_HappyPath(){
        Calculadora cal = new Calculadora();
        int subtracao = cal.subtrair(1, 2);
        assertEquals(-1, subtracao);
    }

    @Test
    public void testMultiplicar_HappyPath(){
        Calculadora cal = new Calculadora();
        int multiplicacao = cal.multiplicar(1, 2);
        assertEquals(2, multiplicacao);
    }

    @Test
    public void testDividir_HappyPath(){
        Calculadora cal = new Calculadora();
        int divisao = cal.dividir(4, 2);
        assertEquals(2, divisao);
    }

    @Test
    public void testDividir_BEhZero(){
        Calculadora cal = new Calculadora();
        int divisao = cal.dividir(4, 0);
        assertEquals(-1, divisao);
    }
}
