package br.com.derich;

public class Calculadora {

    /**
     * Função para somar dois elementos, a e b.
     * @param a
     * @param b
     * @return soma de a e b
     */
    public int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * Função para subtrair dois elementos, a e b.
     * @param a
     * @param b
     * @return subtração de a e b
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Função para multiplicar dois elementos, a e b.
     * @param a
     * @param b
     * @return multiplicação de a e b
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Função para dividir dois elementos, a e b.
     * Caso o segundo elemento seja 0 ele retorna -1 para indicar que não é possível realizar essa operação.
     * @param a
     * @param b
     * @return divisão de a e b
     */
    public int dividir (int a, int b) {

        if (b != 0){
            return a / b;
        }
        else {
            return -1;
        }
    }
}
