package br.com.derich;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Colecoes {

    public static void main(String[] args) {
        lista();
        listaGenero();
    }

    private static void lista(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome de pessoas: ");
        String pessoas = s.nextLine();

        String[] nomes = pessoas.split(",");

        List<String> lista = new ArrayList<String>();

        Collections.addAll(lista, nomes);
        Collections.sort(lista);
        System.out.println(lista);
    }

    private static void listaGenero(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome de pessoas e seu gênero: ");
        String pessoas = s.nextLine();

        String[] nomes = pessoas.split(",");
        Map<String, List<String>> grupos = new HashMap<>();
        grupos.put("M", new ArrayList<>());
        grupos.put("F", new ArrayList<>());

        for (String nome : nomes){
            String[] entrada = nome.split("-");
            String nomeEntrada = entrada[0].toUpperCase();
            String sexoEntrada = entrada[1].toUpperCase();
            grupos.get(sexoEntrada).add(nomeEntrada);
        }

        System.out.println(grupos);
    }
}
