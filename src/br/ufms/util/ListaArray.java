package br.ufms.util;

import java.util.Arrays;

public class ListaArray<E> implements Lista<E> {

    private Object[] elemData;
    private static final Object[] CAPACIDADE_PADRAO_ELEMDATA_VAZIO = {};
    private int tamanho;
    private int capacidade;
    private static final int CAPACIDADE_INICIAL = 10;
    public static final int COMPRIMENTO_MAX_ARRAY = Integer.MAX_VALUE - 8;

    public ListaArray() {
        this.elemData = new Object[CAPACIDADE_INICIAL];
        this.capacidade = CAPACIDADE_INICIAL;
        this.tamanho = 0;
    }

    @Override
    public boolean add(E elem) {
        add(elem, elemData, tamanho);
        return true;
    }

    private void add(E e, Object[] elemData, int s) {
        if (s == elemData.length)
            elemData = aumentarArray();
        elemData[s] = e;
        tamanho = s + 1;
    }

    @Override
    public void add(int pos, E elem) {
        if (tamanho < pos || pos < 0) {
            throw new IndexOutOfBoundsException();
        }
        checkarDistancia(pos);
        final int s;
        Object[] elementData;
        if ((s = tamanho) == (elementData = this.elemData).length)
            elementData = aumentarArray();
        System.arraycopy(elementData, pos,
                elementData, pos + 1,
                s - pos);
        elementData[pos] = elem;
        tamanho = s + 1;

    }

    @Override
    public E get(int pos) {
        return (E) elemData[pos];
    }

    @Override
    public int indexOf(E elem) {
        for (int i = 0; i < tamanho; i++) {
            if (elem.equals(elemData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E elem) {
        if (indexOf(elem) < 0) {
            return false;
        }
        return indexOf(elem) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return tamanho == 0;
    }

    @Override
    public boolean remove(E elem) {
        int pos = indexOf(elem);

        if (pos != -1) {
            remove(pos);
            return true;
        }
        return false;
    }

    @Override
    public E remove(int pos) {
        if (pos < 0 || pos >= tamanho) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = pos + 1; i < tamanho; i++) {
            elemData[i - 1] = elemData[i];
        }

        elemData[tamanho - 1] = null;
        tamanho--;
        return (E) elemData[tamanho - 1];
    }

    @Override
    public void clear() {
        this.elemData = new Object[CAPACIDADE_INICIAL];
    }

    @Override
    public int size() {
        return tamanho;
    }

    private void checkarDistancia(int pos) {
        if (pos > tamanho || pos < 0)
            throw new IndexOutOfBoundsException();
    }

    private Object[] aumentarArray(int capacidadeMinima) {
        int capacidadeAntiga = elemData.length;

        if (capacidadeAntiga > 0 || elemData != CAPACIDADE_PADRAO_ELEMDATA_VAZIO) {
            int novaCapacidade = novoComprimento(capacidadeAntiga,
                    capacidadeMinima - capacidadeAntiga,
                    capacidadeAntiga >> 1);
            return elemData = Arrays.copyOf(elemData, novaCapacidade);
        } else {
            return elemData = new Object[Math.max(CAPACIDADE_INICIAL, capacidadeMinima)];
        }
    }

    private Object[] aumentarArray() {
        return aumentarArray(capacidade + 1);
    }

    public static int novoComprimento(int antigoComprimento, int crescimentoMin, int crescimentoPref) {
        int tamanhoPref = antigoComprimento + Math.max(crescimentoMin, crescimentoPref);

        if (0 < tamanhoPref && tamanhoPref <= COMPRIMENTO_MAX_ARRAY) {
            return tamanhoPref;
        } else {
            return maxComprimento(antigoComprimento, crescimentoMin);
        }
    }

    private static int maxComprimento(int comprimentoAntigo, int crescimentoMin) {
        int comprimentoMin = comprimentoAntigo + crescimentoMin;

        if (comprimentoMin < 0) {
            throw new OutOfMemoryError();
        } else if (comprimentoMin <= COMPRIMENTO_MAX_ARRAY) {
            return COMPRIMENTO_MAX_ARRAY;
        } else {
            return comprimentoMin;
        }
    }
}
