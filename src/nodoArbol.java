public class nodoArbol {
    private int valor; // Valor almacenado en el nodo
    private nodoArbol nodoIzq; // Nodo hijo izquierdo
    private nodoArbol nodoDerecho; // Nodo hijo derecho

    // Constructor que inicializa el nodo con un valor y sin hijos
    public nodoArbol(int valor){
        this.valor = valor;
        this.nodoIzq = null;
        this.nodoDerecho = null;
    }

    // Método para obtener el valor del nodo
    public int getValor() {
        return valor;
    }

    // Método para establecer el valor del nodo
    public void setValor(int valor) {
        this.valor = valor;
    }

    // Método para obtener el nodo hijo izquierdo
    public nodoArbol getNodoIzq() {
        return nodoIzq;
    }
    
    // Método para establecer el nodo hijo izquierdo
    public void setNodoIzq(nodoArbol nodoIzq) {
        this.nodoIzq = nodoIzq;
    }

    // Método para obtener el nodo hijo derecho
    public nodoArbol getNodoDerecho() {
        return nodoDerecho;
    }
    
    // Método para establecer el nodo hijo derecho
    public void setNodoDerecho(nodoArbol nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }
    
    // Método para insertar un valor en el árbol binario de búsqueda
    public void insertar(int _valor){
        if (_valor < this.valor) { // Si el valor es menor, va al subárbol izquierdo
            if (this.nodoIzq == null) {
                this.nodoIzq = new nodoArbol(_valor); // Crea un nuevo nodo a la izquierda
            } else {
                this.nodoIzq.insertar(_valor); // Recursión: llama al método para insertar en el subárbol izquierdo
            }
        } else { // Si el valor es mayor o igual, va al subárbol derecho
            if (this.nodoDerecho == null) {
                this.nodoDerecho = new nodoArbol(_valor); // Crea un nuevo nodo a la derecha
            } else {
                this.nodoDerecho.insertar(_valor); // Recursión: llama al método para insertar en el subárbol derecho
            }
        }
    }
}
