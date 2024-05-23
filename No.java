public class No<E> {
    private E info;
    private No<E> proximo;

    public No(E info) {
        this.info = info;
        this.proximo = null;
    }

    public E getInfo() {
        return info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public No<E> getProximo() {
        return proximo;
    }

    public void setProximo(No<E> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
