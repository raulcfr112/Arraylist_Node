package br.ufms.util;

public interface Lista<E> {

    boolean add(E elem);

    void add(int pos, E elem);

    E get(int pos);

    int indexOf(E elem);

    boolean contains(E elem);

    boolean isEmpty();

    boolean remove(E elem);

    E remove(int pos);

    void clear();

    int size();
}
