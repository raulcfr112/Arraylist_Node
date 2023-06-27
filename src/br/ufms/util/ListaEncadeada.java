package br.ufms.util;

public class ListaEncadeada<E> implements Lista<E> {

    private No<E> inicio;
    private No<E> fim; // pode ser uma boa ideia para alocar em tempo O(1)
    private int tamanho; // pode ser uma ideia para retornar o tamanho em tempo O(1)

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }

    @Override
    public boolean add(E elem) {
        No<E> no = new No<>();
        no.elem = elem;
        if (isEmpty()) {
            this.inicio = this.fim = no;
        } else {
            this.fim.prox = no;
            this.fim = no;
        }
        tamanho++;
        return true;
    }

    @Override
    public void add(int pos, E elem) {
        if (pos > tamanho) {
            throw new IndexOutOfBoundsException();
        }
        No<E> no = new No<>();
        no.elem = elem;

        No<E> anterior = getNode(pos - 1);
        no.prox = anterior.prox;
        anterior.prox = no;
        this.tamanho++;

    }

    @Override
    public E get(int pos) {
        int atual = 1;
        No<E> no = this.inicio;

        while (atual < pos) {
            no = no.prox;
            atual++;
        }
        return no.elem;
    }

    public No<E> getNode(int pos) {
        int atual = 1;
        No<E> no = this.inicio;

        if (pos > this.tamanho) {
            return null;
        }
        while (atual < pos) {
            no = no.prox;
            atual++;
        }
        return no;
    }

    @Override
    public int indexOf(E elem) {
        int contador = 1;
        No<E> no = inicio;

        while (no != null) {
            if (no.elem == elem) {
                return contador;
            }
            no = no.prox;
            contador++;
        }
        return 0;
    }

    @Override
    public boolean contains(E elem) {
        No<E> no = inicio;

        while (no != null) {
            if (no.elem == elem) {
                return true;
            }
            no = no.prox;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (tamanho == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(E elem) {
        int pos = indexOf(elem);
        No<E> no;

        if (pos != 0) {
            no = getNode(pos);
            if (no == inicio && no == fim) {
                inicio = fim = null;
                tamanho--;
            }
            if (no == inicio) {
                inicio = no.prox;
                no.prox = null;
                tamanho--;
                return true;
            }
            if (no == fim) {
                fim = getNode(pos - 1);
                fim.prox = null;
                tamanho--;
                return true;
            }
            getNode(pos - 1).prox = no.prox;
            no.prox = null;
            tamanho--;
            return true;
        }

        return false;
    }

    @Override
    public E remove(int pos) {
        No<E> no;
        if (pos <= tamanho) {
            no = getNode(pos);
            if (no == this.inicio && no == this.fim) {
                this.inicio = this.fim = null;
                tamanho--;
            }
            if (no == this.inicio) {
                this.inicio = no.prox;
                no.prox = null;
                tamanho--;
                return no.elem;
            }
            if (no == this.fim) {
                this.fim = getNode(pos - 1);
                this.fim.prox = null;
                tamanho--;
                return no.elem;
            }
            getNode(pos - 1).prox = no.prox;
            no.prox = null;
            tamanho--;
            return no.elem;
        }
        return null;
    }

    @Override
    public void clear() {
        this.inicio = this.fim = null;
        tamanho = 0;
    }

    @Override
    public int size() {
        return tamanho;
    }

    private class No<E> {
        E elem;
        No<E> prox;
    }
}
