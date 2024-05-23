public class Fila<E> {
    private No<E> primeiro;
    private No<E> ultimo;
    private int tamanho;

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void enfileira(E item) {
        No<E> novo = new No<>(item);
        if (estaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;
        tamanho++;
    }

    public E desenfileira() {
        if (estaVazia()) {
            return null;
        }
        E temp = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        if (primeiro == null) {
            ultimo = null;
        }
        tamanho--;
        return temp;
    }

    public int tamanho() {
        return tamanho;
    }

    public E consultaPrimeiro() {
        return estaVazia() ? null : primeiro.getInfo();
    }

    @Override
    public String toString() {
        if (estaVazia()) {
            return "fila vazia";
        }
        StringBuilder s = new StringBuilder();
        No<E> aux = primeiro;
        while (aux != ultimo) {
            s.append(aux).append(" - ");
            aux = aux.getProximo();
        }
        s.append(aux);
        return s.toString();
    }
}
