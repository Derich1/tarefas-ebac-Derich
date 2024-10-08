package br.com.derich;

public class TabelaValores {

    public static void main(String[] args){
        nomeDaTabela();
    }

    private static void nomeDaTabela() {
        String nameTabela = Tabela.class.getName();
        System.out.println(nameTabela);
    }
}
