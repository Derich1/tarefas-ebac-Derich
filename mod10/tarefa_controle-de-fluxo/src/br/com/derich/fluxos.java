package br.com.derich;

import java.util.Scanner;

public class fluxos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite a primeira nota: ");
        int nota1 = s.nextInt();

        System.out.println("Digite a segunda nota: ");
        int nota2 = s.nextInt();

        System.out.println("Digite a terceira nota: ");
        int nota3 = s.nextInt();

        System.out.println("Digite a quarta nota: ");
        int nota4 = s.nextInt();

        int media = (nota1 + nota2 + nota3 + nota4) / 4;

        if (media >= 7){
            System.out.println("Aprovado");
        } else if (media >= 5){
            System.out.println("De recuperação");
        } else{
            System.out.println("Reprovado");
        }
    }
}
