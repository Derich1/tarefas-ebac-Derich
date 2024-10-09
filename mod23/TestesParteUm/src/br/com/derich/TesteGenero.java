package br.com.derich;

import java.util.*;

public class TesteGenero {

    public static void main(String[] args) {
        listaGenero();
    }

    public static Map<String, List<String>> listaGenero() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome de pessoas e seu gênero: ");
        String pessoas = s.nextLine();

        String[] nomes = pessoas.split(",");
        Map<String, List<String>> grupos = new HashMap<>();

        List<String> masculino = new ArrayList<>();
        List<String> feminino = new ArrayList<>();

        grupos.put("M", masculino);
        grupos.put("F", feminino);

        Arrays.stream(nomes).forEach(nome -> {
            String[] entrada = nome.split("-");
            String nomeEntrada = entrada[0];
            String sexoEntrada = entrada[1];
            grupos.get(sexoEntrada).add(nomeEntrada);
        });
        return grupos;
    }
}

