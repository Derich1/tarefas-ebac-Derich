package br.com.derich;

public class FatorialPD {

    private static final int elementos = 100;
    private static final long[] lista = new long[elementos];

    public static long pd(long n) {
        for (int i = 0; i < elementos; i++) {
            lista[i] = -1;
        }
        return calcular(n);
    }

    public static long calcular(long n) {
        if (lista[(int) n] == -1) {
            if (n <= 1) {
                lista[(int) n] = 1;
            } else {
                lista[(int) n] = n * calcular(n - 1);
            }
        }
        return lista[(int) n];
    }


    public static void main(String[] args) {
        long n = 70;
        System.out.println(pd(n));
    }
}
