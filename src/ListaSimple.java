
public class ListaSimple {
    NodoLista top = null;//puntero al inicio

    public void inserta(String x) {
        NodoLista nuevo, p = new NodoLista();
        p = top;
// Crear nuevo dato
        nuevo = new NodoLista();
        nuevo.info = x;
        nuevo.sig = null;
// Primer dato
        if (p == null) {
            top = nuevo;
        } else //valor antes de comienzo
            while (p != null) {
                if (p.sig == null) {
                    p.sig = nuevo;
                    break;
                }
                p = p.sig;
            }
    }

    public void contenido() {
        NodoLista p;
        System.out.println("Impresion de la lista");
        p = top;
        while (p != null) {

            p = p.sig;
        }
        System.out.println();
    }

    public void suprime(String val) {
        NodoLista q, p;
        p = new NodoLista();
        q = top;
        if (q == null)
            System.out.println("Lista vacia");
        else {
            while (q != null && val != q.info) {
                p = q;
                q = q.sig;
            }
            if (q == null)
                System.out.println("valor no encontrado");
            else if (q == top)
                top = top.sig;
            else
                p.sig = q.sig;
        }
    }

    public int tamano() {
        NodoLista p;
        int indice = 0;
        p = top;
        while (p != null) {
            indice++;
            p = p.sig;
        }
        return indice;
    }

    public String get(int x) {
        NodoLista p;
        boolean encontrado;

        encontrado = false;
        p = top;
        try {
            for (int i = 0; i < x; i++) {
                p = p.sig;
            }
        } catch (Exception e) {
            return "-1";
        }
        return p.info;
    }
}

    

