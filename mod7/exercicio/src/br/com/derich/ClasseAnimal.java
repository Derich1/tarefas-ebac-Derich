package br.com.derich;

public class ClasseAnimal {

    public class Cachorro {
        public int peso;

        // Dependendo do peso do cachorro ele é classificado como pequeno, médio ou grande porte.
        void porte() {
            if (peso <= 20) {
                System.out.println("Pequeno porte");
            }

            else if (peso <= 40) {
                System.out.println("Médio porte");
            }

            else {
                System.out.println("Grande Porte");
            }
        }
    }
}
