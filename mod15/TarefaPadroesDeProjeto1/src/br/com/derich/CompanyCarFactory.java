package br.com.derich;

public class CompanyCarFactory  extends Factory {

    Car retornarCar(String nota){
        switch (nota){
            case "A":
                return new BMW(600, "cheio", "preto");
            default:
                System.out.println("Esse carro não existe.");
                return null;
        }
    }
}
