package br.com.derich;

public abstract class Car {

    private int potencia;
    private String combustivel;
    private String cor;

    public Car (int potencia, String combustivel, String cor) {
        this.potencia = potencia;
        this.combustivel = combustivel;
        this.cor = cor;
    }

    public void limpar(){
        System.out.println("O carro está limpo e a cor " + cor + " está brilhando");
    }
    
    public void combustivel(){
        System.out.println("O carro está com o tanque " + combustivel + " e está pronto para aproveitar seus " + potencia + " cavalos de potência");
    }
}
