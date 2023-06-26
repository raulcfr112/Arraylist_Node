package br.ufms.util;

public class ListaEncadeada<E> implements Lista<E> {

    private No<E> inicio;
//    private No<E> fim; // pode ser uma boa ideia para alocar em tempo O(1)
    private int tamanho; // pode ser uma ideia para retornar o tamanho em tempo O(1)

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    @Override
    public boolean add(E elem) {
        return false;
    }

    @Override
    public void add(int pos, E elem) {

    }

    @Override
    public E get(int pos) {
        return null;
    }

    @Override
    public int indexOf(E elem) {
        return 0;
    }

    @Override
    public boolean contains(E elem) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean remove(E elem) {
        return false;
    }

    @Override
    public E remove(int pos) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    private class No<E> {
        E elem;
        No<E> prox;
    }
}
