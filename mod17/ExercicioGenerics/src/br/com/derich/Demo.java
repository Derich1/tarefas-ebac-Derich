package br.com.derich;

import br.com.derich.carros.Civic;
import br.com.derich.carros.Corolla;
import br.com.derich.carros.Golf;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String args[]){

        List<Carro> listaCarros = new ArrayList<>();
        Carro carro = new Civic("Preto", 2.0f);
        Carro carro1 = new Corolla("Azul", 1.6f);
        Carro carro2 = new Golf("Prata", 2.0f);

        listaCarros.add(carro1);
        listaCarros.add(carro2);
        listaCarros.add(carro);

        carro.infoCarro();
    }
}
