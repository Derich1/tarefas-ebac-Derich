package br.com.derich;

public abstract class Carro {

    private String cor;
    private Float potencia;

    public Carro(String cor, Float potencia){
        this.cor = cor;
        this.potencia = potencia;
    }

    public void infoCarro(){
        System.out.println("O Carro tem a cor " + cor + " e o motor é " + potencia);
    }
}
