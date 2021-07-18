
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Arbol{
    Nodo padre = null;

    Arbol() {
    }

    Arbol(Nodo nodoPadre) {
        padre = new Nodo();
        padre = nodoPadre;
    }

    public void nombre(String nombre) {
        if (padre == null) {
            padre = new Nodo();
            padre.nombre = nombre;
        } else {
            JOptionPane.showMessageDialog(null,"Usted modifico el nombre del padre");
            padre.nombre = nombre;
        }
    }

    public void insertarHijo(String nombre) {
        Nodo hijo = new Nodo();
        hijo.nombre = nombre;
        hijo.padre = padre;
        Nodo temporal = new Nodo();
        temporal = padre;
        if (temporal.hijo == null) { // inicialmente insertamos el hijo
            temporal.hijo = hijo;
        } else { // luego del hijo como sus hermanos
            temporal = temporal.hijo; //ingresamos a su primer hijo
            while (temporal != null) {
                if (temporal.hermano == null) {
                    temporal.hermano = hijo; // insertar al final nuevo hermano
                    break;
                }
                temporal = temporal.hermano;
            }
        }
    }

    public Arbol ingresarAHijo(String nombreBuscar, Arbol arbolPadre) {
        Nodo temporal = arbolPadre.padre;
        temporal = temporal.hijo;
        boolean encontrado = false;
        while (temporal != null) {
            if (nombreBuscar.equals(temporal.nombre)) {
// con el break estamos haciendo que se seleccione al hijo PERO con los hermanos siguientes que tiene,
// de esa manera no se pierde el puntero
                encontrado = true;
                break;
            }
            temporal = temporal.hermano;
        }
        if (encontrado == true) {
            JOptionPane.showMessageDialog(null," Se encontro Elemento !! :)");
            return new Arbol(temporal);

        } else {
            JOptionPane.showMessageDialog(null," NO se encontro  !! :(");
            return arbolPadre; //le retornamos el mismo padre
        }
    }

    public void eliminarHijo(String nombreAEliminar) {
        Nodo temporal = padre;
        temporal = temporal.hijo;
        Nodo temporalDetras = padre;
        temporalDetras = temporalDetras.hijo;
        while (temporal != null) {
            if (nombreAEliminar.equals(temporal.nombre)) {
               JOptionPane.showMessageDialog(null," Se ENCONTRO, Eliminando ......... ! ");
                if (padre.hijo != temporal) {
                    temporal = temporal.hermano;
                    temporalDetras.hermano = temporal;
                    break; // Para que no se preoduzca error cuando es el ultimo hermano.
                } else { // cuando es el primer hermano
                    padre.hijo = padre.hijo.hermano;
                }


            }
            temporalDetras = temporal;
            temporal = temporal.hermano;
        }

    }

    public Arbol regresar() {
        if (padre.padre == null) { // esto es para que no haya error en el primer hijo del nodo principal
            return new Arbol(padre);
        } else {
            return new Arbol(padre.padre);
        }
    }

    public String miRuta() {
        Nodo sacrificado = new Nodo();
        sacrificado = padre;
        ListaSimple rutaList = new ListaSimple();
        String ruta = "";
        while (sacrificado != null) {
            rutaList.inserta(sacrificado.nombre);
            sacrificado = sacrificado.padre;
        }
        for (int i = rutaList.tamano() - 1; i >= 0; i--) {
            if (i == 0) { // para que al final no le coloque el /
                ruta += rutaList.get(i);
            } else {
                ruta += rutaList.get(i) + "/";
            }
        }
        return ruta;
    }

    public Arbol ingresarRuta(String ruta, Arbol arbolTotal) {

        Arbol arbolSacrificado = arbolTotal;
        int InicioLongitud = 0; //nos indica el inicio que vamos a cortar del string
        ListaSimple rutaList = new ListaSimple();
        for (int i = 0; i < ruta.length(); i++) {
            if (ruta.charAt(i) == '/') {
//se ignora el / y alistamos el siguiente indice
                rutaList.inserta(ruta.substring(InicioLongitud, i));
                InicioLongitud = i + 1;
            }
            if (i == ruta.length() - 1) { // Cuando este al final de la ruta solicitado
                rutaList.inserta(ruta.substring(InicioLongitud, i + 1));
            }
        }
        try {
            for (int i = 0; i < rutaList.tamano(); i++) {
                arbolSacrificado = arbolSacrificado.ingresarAHijo(rutaList.get(i), arbolSacrificado);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null," Esta ruta no existe :( ");

//Regresa al inicio
            return new Arbol(padre); // Si no se encuentra la ruta, retornamos el arbol con el nodo Padre
        }
        return arbolSacrificado;
    }

    public Arbol crearRuta(String ruta, Arbol arbolTotal) {
        Arbol arbolSacrificado = arbolTotal;
        int InicioLongitud = 0; //nos indica el inicio que vamos a cortar del string
        ListaSimple rutaList = new ListaSimple();
        for (int i = 0; i < ruta.length(); i++) {
            if (ruta.charAt(i) == '/') {
//se ignora el / y alistamos el siguiente indice
                rutaList.inserta(ruta.substring(InicioLongitud, i));
                InicioLongitud = i + 1;
            }
            if (i == ruta.length() - 1) { // Cuando este al final de la ruta solicitado
                rutaList.inserta(ruta.substring(InicioLongitud, i + 1));
            }
        }
        for (int i = 0; i < rutaList.tamano(); i++) {
            if (arbolSacrificado.existeHijo(rutaList.get(i))) {
                arbolSacrificado = arbolSacrificado.ingresarAHijo(rutaList.get(i), arbolSacrificado);
            } else {
                arbolSacrificado.insertarHijo(rutaList.get(i)); // se crea el hijo y se ingresa al instante
                arbolSacrificado = arbolSacrificado.ingresarAHijo(rutaList.get(i), arbolSacrificado);
            }
        }
        return arbolSacrificado;
    }

    public void mostrarHijos() {
        Nodo sacrificado = new Nodo();
        sacrificado = padre.hijo;
        if (sacrificado == null) {
            JOptionPane.showMessageDialog(null, "No tiene Elementos :c ");
        } else {
            ArrayList<String> arr = new ArrayList<>();
            while (sacrificado != null) {
                arr.add(sacrificado.nombre);
                sacrificado = sacrificado.hermano;
            }
            JOptionPane.showMessageDialog(null, arr);
        }
    }

    public void mostrarTodo(Nodo nodo, int contRama) {
// HACER RECURSIVIDAD PARA ENTRAR DE HIJO EN HIJO//
        String lineaSeparadora = "/";
        String  lineaSeparadora1 = "Elemento";
        String puntos = " ";
        for (int i = 0; i < contRama; i++) {
            lineaSeparadora += "==>";
            lineaSeparadora1 += " -Sub ";
        }
        Nodo sacrificado = new Nodo();
        sacrificado = nodo.hijo;
        Nodo a = new Nodo();
        if (contRama == 0) {

            JOptionPane.showMessageDialog(null, "Hospital :" + nodo.nombre);
        }

        while (sacrificado != null) {

//funciones recursia

            JOptionPane.showMessageDialog(null, lineaSeparadora1 + lineaSeparadora + sacrificado.nombre);

            a = sacrificado;
            //Cuando tiene hijos
            if (a != null) {
                mostrarTodo(a, contRama + 1);
            }

            sacrificado = sacrificado.hermano;
            ;
        }
    }

    public boolean existeHijo(String nombreBuscar) {
        Nodo temporal = new Nodo();
        temporal = padre.hijo;
        boolean encontrado = false;
        while (temporal != null) {
            if (nombreBuscar.equals(temporal.nombre)) {
                encontrado = true;
                break;
            }
            temporal = temporal.hermano;
        }
        return encontrado;
    }
}