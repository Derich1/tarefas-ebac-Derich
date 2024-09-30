package br.com.derich;

public class Demo {

    public static void main(String[] args) {
        
        Customer cliente = new Customer("A", false);
        Factory fabrica = getFactory(cliente);
        Car car = fabrica.create(cliente.getNota());
    }

    private static Factory getFactory(Customer cliente){
        if (cliente.isCompanhia()){
            return new CarFactory();
        }else{
            return new CompanyCarFactory();
        }
    }
}
