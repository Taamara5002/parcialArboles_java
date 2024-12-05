
public class main {
    public static void main(String[] args) {
        arbol _arbol = new arbol();
        
        // Insertar valores en el árbol
        _arbol.insertar(10);  // Inserta 10
        _arbol.insertar(5);   // Inserta 5
        _arbol.insertar(15);  // Inserta 15
        _arbol.insertar(3);   // Inserta 3
        _arbol.insertar(7);   // Inserta 7
        _arbol.insertar(12);  // Inserta 12
        _arbol.insertar(18);  // Inserta 18
        
        // Imprimir los valores del árbol en preorden
        System.out.println("Recorrido en Preorden del árbol:");
        _arbol.dispararPreOrden();
        
        //Eliminar valores en el arbol
        _arbol.eliminar(18);
        System.out.println("Recorrido en Preorden del árbol:");
        _arbol.dispararPreOrden();
    }
}
