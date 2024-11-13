package br.com.derich;

public class Fatorial {

    public static long calcular(long n){
        long result = 0;
        for (long i = 0; i < n+1; i++){
            if(i == 1){
                result = 1;
            }
            if (i > 1){
                result *= i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long n = 70;
        System.out.println(calcular(n));
    }
}
