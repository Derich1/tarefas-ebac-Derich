package br.com.derich;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestesFeminino {

    @Test
    public void test(){
        Assert.assertEquals("F", TesteGenero.listaGenero());
    }
}
