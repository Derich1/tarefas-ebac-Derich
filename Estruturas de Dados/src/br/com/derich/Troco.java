package br.com.derich;

public class Troco {

    // Greedy Algorithm

    private static int um_moeda = 1;
    private static int dois_moeda = 2;
    private static int cinco_moeda = 5;
    private static int moedas;

    private static int contar(int quantia){

        if (quantia >= 5){
            moedas++;
            quantia -= cinco_moeda;
            return contar(quantia);
        }

        if (quantia >= 2){
            moedas++;
            quantia -= dois_moeda;
            return contar(quantia);
        }

        if (quantia >= 1){
            moedas++;
            quantia -= um_moeda;
            return contar(quantia);
        }
        return moedas;
    }

    public static void main(String[] args) {
        int quantia = 33;
        System.out.println(contar(quantia));
    }
}
