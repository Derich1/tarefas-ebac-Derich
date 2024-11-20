package br.com.derich;

public class Fibonacci {

    /** Exemplo de programação dinâmica
    * programação dinâmica é útil porque evita recálculos de subproblemas,
    * o que garante correção e eficiência
    * no caso esse código evita recalcular um índice que já foi calculado
    */
    private static final int Max_Elementos = 100;
    private static final int[] elementosFib = new int[Max_Elementos];

    public static int encontrarElementoPD(int n){

        /* inicia o array inteiro como -1 */
        for (int i = 0; i < Max_Elementos; i++){
            elementosFib[i] = -1;
        }

        return encontrarElemento(n);
    }

    public static int encontrarElemento(int n){

        /** Se o numero do array for -1 significa que
         * ele ainda não foi calculado pq n existe negativo na sequencia de Fibonacci
         * agora se ele já foi calculado não vai cair no if, vai direto para o return
         * ele vai se repetindo a partir do 100 (Max_elementos) até o elemento
         * que ainda não temos o valor calculado
         * caso ainda não tenha nenhum calculado, ele vai recursivamente
         * chamando a própria função passando o índice que queremos encontrar (n)
         * menos 1, ou seja, n-1
         * até chegar no elemento 0 e elemento 1, que será o próprio indice a resposta
         * dali em diante é só ir calculando
         */
        if (elementosFib[n] == -1) {
            if (n <= 1) {
                elementosFib[n] = n;
            } else {
                elementosFib[n] = encontrarElemento(n - 1) + encontrarElemento(n - 2);
            }
        }

        return elementosFib[n];
    }

    // n seria a posição no array
    public static void main(String[] args) {
        int n = 8;

        System.out.println(encontrarElementoPD(n));
    }
}
