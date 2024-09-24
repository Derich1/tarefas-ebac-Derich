import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Colecoes {

    public static void main(String[] args) {
        listaGenero();
    }

    private static void listaGenero(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome de pessoas e seu gênero: ");
        String pessoas = s.nextLine();

        String[] nomes = pessoas.split(",");
        Map<String, List<String>> grupos = new TreeMap<>();
        grupos.put("M", new ArrayList<>());
        grupos.put("F", new ArrayList<>());

        for (String nome : nomes){
            String[] entrada = nome.split("-");
            String nomeEntrada = entrada[0].toUpperCase();
            String sexoEntrada = entrada[1].toUpperCase();
            grupos.get(sexoEntrada).add(nomeEntrada);
        }

        // Ordena a lista de nomes alfabeticamente
        for (Map.Entry<String, List<String>> grupo : grupos.entrySet()) {
            Collections.sort(grupo.getValue()); 
        }

        System.out.println(grupos);
    }
}
