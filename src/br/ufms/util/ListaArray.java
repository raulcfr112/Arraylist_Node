package br.ufms.util;

public class ListaArray<E> implements Lista<E> {

    private Object[] elemData;
    private int tamanho;
    private int capacidade;

    private static final int CAPACIDADE_INICIAL = 10;

    public ListaArray() {
        this.elemData = new Object[CAPACIDADE_INICIAL];
        this.capacidade = CAPACIDADE_INICIAL;
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
}
