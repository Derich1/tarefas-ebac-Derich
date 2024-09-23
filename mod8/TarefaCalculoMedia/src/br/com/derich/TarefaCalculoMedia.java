package br.com.derich;

public class TarefaCalculoMedia {

    public static void main(String[] args) {
        calcularMedia();
    }

    public static void calcularMedia() {
        int nota1 = 10;
        float nota2 = 8.5f;
        int nota3 = 9;
        float nota4 = 9.5f;

        float media = (nota1 + nota2 + nota3 + nota4) / 4.0f;

        System.out.println(media);
    }
}
