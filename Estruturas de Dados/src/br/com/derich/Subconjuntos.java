package br.com.derich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subconjuntos {

     /*
    Resolver com backtracking
    Transformar o array em arrays de tamanho N

    Entrada: S = [1, 2, 3], n = 2
    Saída: [1, 2], [1, 3], [2, 3]

    Entrada: S= [1, 2, 3, 4], n = 1
    Saída: [1], [2], [3] e [4]
     */

    private static int[] lista = {1, 2, 3, 4};
    private static int n = 2;

    public static void main(String[] args) {
        List<int[]> resultados = new ArrayList<>();
        gerarSubconjuntos(lista, n, 0, new ArrayList<>(), resultados);

        // Imprime os resultados
        for (int[] subconjunto : resultados) {
            System.out.println(Arrays.toString(subconjunto));
        }
    }

    private static void gerarSubconjuntos(int[] lista, int n, int inicio, List<Integer> atual, List<int[]> resultados) {
        // Caso base: se o tamanho do subconjunto atual for igual a n, adiciona à lista de resultados
        if (atual.size() == n) {
            resultados.add(atual.stream().mapToInt(Integer::intValue).toArray());
            return;
        }

        // Loop recursivo para gerar os subconjuntos
        for (int i = inicio; i < lista.length; i++) {
            // Adiciona o elemento atual ao subconjunto
            atual.add(lista[i]);

            // Recursão para o próximo elemento
            gerarSubconjuntos(lista, n, i + 1, atual, resultados);

            // Remover o último elemento
            atual.remove(atual.size() - 1);
        }
    }
}
