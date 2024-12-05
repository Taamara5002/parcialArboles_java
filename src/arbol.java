public class arbol {

    nodoArbol inicial; // Nodo raíz del árbol

    // Constructor que inicializa el árbol vacío
    public arbol() {
        this.inicial = null;
    }

    // Método para insertar un valor en el árbol
    public void insertar(int valor) {
        if (this.inicial == null) { // Si el árbol está vacío, se asigna el valor a la raíz
            this.inicial = new nodoArbol(valor);
        } else {
            this.inicial.insertar(valor); // Si no, se inserta el valor recursivamente
        }
    }

    // Métodos para recorrer el árbol

    // Método que inicia el recorrido en preorden
    public void dispararPreOrden(){
        this.preOrden(this.inicial);
    }

    // Método recursivo para recorrer el árbol en preorden (raíz, izquierda, derecha)
    public void preOrden(nodoArbol nodo){
        if (nodo == null) {
            return; // Detener la recursividad cuando se llegue a un nodo vacío (caso base)
        }else{
            System.out.println(nodo.getValor()); // Imprimir el valor del nodo
            preOrden(nodo.getNodoIzq()); // Recursión para el subárbol izquierdo
            preOrden(nodo.getNodoDerecho()); // Recursión para el subárbol derecho
        }
    }
    
    // Método para eliminar un valor del árbol
    public void eliminar(int valor) {
        this.inicial = eliminarNodo(this.inicial, valor); // Iniciar el proceso de eliminación desde la raíz
    }

    // Método recursivo para manejar la eliminación de un nodo
    private nodoArbol eliminarNodo(nodoArbol nodo, int valor) {
        if (nodo == null) {
            return null; // Caso base: si el nodo no existe, retornar null
        }

        // Buscar el nodo a eliminar
        if (valor < nodo.getValor()) {
            nodo.setNodoIzq(eliminarNodo(nodo.getNodoIzq(), valor)); // Eliminar en el subárbol izquierdo
        } else if (valor > nodo.getValor()) {
            nodo.setNodoDerecho(eliminarNodo(nodo.getNodoDerecho(), valor)); // Eliminar en el subárbol derecho
        } else {
            // Nodo encontrado: manejar los 3 casos
            // Caso 1: El nodo no tiene hijos
            if (nodo.getNodoIzq() == null && nodo.getNodoDerecho() == null) {
                return null; // Se elimina el nodo asignando null
            }

            // Caso 2: El nodo tiene un solo hijo
            if (nodo.getNodoIzq() == null) {
                return nodo.getNodoDerecho(); // Reemplazar el nodo por su hijo derecho
            }
            if (nodo.getNodoDerecho() == null) {
                return nodo.getNodoIzq(); // Reemplazar el nodo por su hijo izquierdo
            }

            // Caso 3: El nodo tiene dos hijos
            // Encontrar el sucesor inorden (el más pequeño del subárbol derecho)
            nodoArbol sucesor = encontrarMinimo(nodo.getNodoDerecho());
            nodo.setValor(sucesor.getValor()); // Reemplazar el valor del nodo por el del sucesor
            nodo.setNodoDerecho(eliminarNodo(nodo.getNodoDerecho(), sucesor.getValor())); // Eliminar el sucesor
        }
        return nodo; // Retornar el nodo actualizado
    }

    // Método para encontrar el nodo más pequeño de un subárbol
    private nodoArbol encontrarMinimo(nodoArbol nodo) {
        while (nodo.getNodoIzq() != null) { // Recorrer el subárbol izquierdo hasta encontrar el nodo más pequeño
            nodo = nodo.getNodoIzq();
        }
        return nodo; // Retornar el nodo más pequeño
    }

}
