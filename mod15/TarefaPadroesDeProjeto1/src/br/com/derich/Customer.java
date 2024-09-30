package br.com.derich;

public class Customer {

    private String nota;
    private Boolean isCompanhia;
    
    public Customer(String nota, boolean isCompanhia){
        this.nota = nota;
        this.isCompanhia = isCompanhia;
    }

    public boolean isCompanhia(){
        return isCompanhia;
    }
    public String getNota(){
        return nota;
    }
    
}
