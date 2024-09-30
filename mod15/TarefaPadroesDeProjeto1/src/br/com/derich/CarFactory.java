package br.com.derich;

public class CarFactory extends Factory {
    
    Car retornarCar(String nota){
        switch (nota){
            case "A":
                return new Mercedes(650, "cheio", "azul");
            default:
                System.out.println("Esse carro não existe.");
                return null;
        }
    }
}
