package br.com.derich;

import java.util.*;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        listaGenero();
    }

    private static void listaGenero() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome de pessoas e seu gênero: ");
        String pessoas = s.nextLine();

        String[] nomes = pessoas.split(",");
        Map<String, List<String>> grupos = new HashMap<>();
        grupos.put("M", new ArrayList<>());
        grupos.put("F", new ArrayList<>());

        Arrays.stream(nomes).forEach(nome -> {
            String[] entrada = nome.split("-");
            String nomeEntrada = entrada[0].toUpperCase();
            String sexoEntrada = entrada[1].toUpperCase();
            grupos.get(sexoEntrada).add(nomeEntrada);
        });
        System.out.println(grupos.get("F"));
    }
}

