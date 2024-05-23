public class Pilha<T> {
    private No<T> topo;
    private int tamanho;

    public boolean estaVazia() {
        return topo == null;
    }

    public void push(T item) {
        No<T> novo = new No<>(item);
        if (!estaVazia()) {
            novo.setProximo(topo);
        }
        topo = novo;
        tamanho++;
    }

    public T pop() {
        if (estaVazia()) {
            return null;
        }
        T aux = topo.getInfo();
        topo = topo.getProximo();
        tamanho--;
        return aux;
    }

    public int tamanho() {
        return tamanho;
    }

    public T consultaTopo() {
        return estaVazia() ? null : topo.getInfo();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Pilha: ");
        if (estaVazia()) {
            s.append("vazia");
        } else {
            No<T> temp = topo;
            while (temp != null) {
                s.append(temp).append("\n");
                temp = temp.getProximo();
            }
            s.append("\\\\");
        }
        return s.toString();
    }
}
