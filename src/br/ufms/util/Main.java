package br.ufms.util;

public class Main {

    public static void main(String[] args) {
        ListaArray<Integer> listaArray = new ListaArray<>();

        System.out.println("testes lista array:");

        listaArray.add(1);
        listaArray.add(2);
        listaArray.add(3);
        listaArray.add(4);
        listaArray.add(5);
        listaArray.add(6);
        listaArray.add(8);
        listaArray.add(9);
        listaArray.add(10);
        listaArray.add(11);
        for (int i = 0; i < listaArray.size(); i++) {
            System.out.println(listaArray.get(i));
        }

        listaArray.remove(5);
        listaArray.remove((Integer) 1);
        System.out.println(listaArray.contains(12));
        System.out.println(listaArray.contains(3));
        System.out.println(listaArray.indexOf(2));
        System.out.println();

        listaArray.add(2, 5);
        for (int i = 0; i < listaArray.size(); i++) {
            System.out.println(listaArray.get(i));
        }


        System.out.println("\ntestes lista encadeada:");

        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.add(7);
        lista.add(2);
        lista.add(3);

        System.out.println(lista.get(1));
        System.out.println(lista.get(2));
        System.out.println(lista.get(3));
        System.out.println(lista.getNode(4));
        System.out.println();

        lista.add(3, 7);

        System.out.println(lista.get(1));
        System.out.println(lista.get(2));
        System.out.println(lista.get(3));
        System.out.println(lista.get(4));
        System.out.println();

        System.out.println(lista.indexOf(7));
        System.out.println(lista.indexOf(4));
        System.out.println();

        System.out.println(lista.contains(3));
        System.out.println(lista.contains(10));
        System.out.println();

        lista.remove((Integer) 7);
        lista.remove((Integer) 9);
        System.out.println(lista.size());
        System.out.println(lista.indexOf(7));
        System.out.println();

        for (int a = 0; a < lista.size(); a++) {
            System.out.println(lista.get(a + 1));
        }
        System.out.println();

        lista.remove(2);

        for (int a = 0; a < lista.size(); a++) {
            System.out.println(lista.get(a + 1));
        }
    }
}
