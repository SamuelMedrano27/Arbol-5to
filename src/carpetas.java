
import java.util.Scanner;

public class carpetas {
    public static void main(String[] args) {
        boolean iteracionTerminado = false;
        Scanner input = new Scanner(System.in);
        String opcionSeleccionado = "";
        Arbol arbolTotal = new Arbol();
        Arbol arbolSecundario = null; //comenzara nulo para cuando se inicalize trabaje solo con el
        do {
            System.out.println("");
            System.out.println("************** OPCIONES **************");
            System.out.println("a) Nombre del padre");
            if (arbolTotal.padre != null) { // Cuando tiene un Nombre el padre raiz
                System.out.println("b) Insertar Hijos");
                System.out.println("c) Ingresar a Hijo");
                System.out.println("d) Eliminar Hijo");
                System.out.println("e) Ruta actual");
                System.out.println("f) Ingresar a una Ruta");
                System.out.println("g) Crear una Ruta ");
                System.out.println("h) Atras");
                System.out.println("i) Mostrar Hijos");
                System.out.println("j) Mostrar Arbol");
                System.out.println("x) Terminar");
            }
            System.out.println("**************************************");
            System.out.print("--->");
            opcionSeleccionado = input.next();
            opcionSeleccionado = opcionSeleccionado.toLowerCase();
            switch (opcionSeleccionado) {
//INGRESAR NOMBRE AL PADRE
                case "a":
                    if (arbolSecundario == null) {
                        System.out.print("---> nombre del Padre: ");
                        arbolTotal.nombre(input.next());
                    } else {
                        System.out.print("---> Cambiar nombre del Padre: ");
                        arbolSecundario.nombre(input.next());
                    }
                    break;
//INSERTAR HIJOS
                case "b":
                    System.out.print("---> nombre del hijo: ");
                    if (arbolSecundario == null) {
                        arbolTotal.insertarHijo(input.next());
                    } else {
                        arbolSecundario.insertarHijo(input.next());
                    }
                    break;
//INGRESAR HIJOS
                case "c":
                    System.out.print("---> Ingresar a: ");
                    String val = input.next();
                    if (arbolSecundario == null) {
                        arbolSecundario = arbolTotal.ingresarAHijo(val, arbolTotal);
                    } else {
                        arbolSecundario = arbolSecundario.ingresarAHijo(val, arbolSecundario);
                    }
                    break;
//ELIMINAR HIJOS
                case "d":
                    System.out.print("---> Eliminar a: ");
                    if (arbolSecundario == null) {
                        arbolTotal.eliminarHijo(input.next());
                    } else {
                        arbolSecundario.eliminarHijo(input.next());
                    }
                    break;
//RUTA ACTUAL
                case "e":
                    if (arbolSecundario == null) {
                        System.out.println("Tu ruta es --->" + arbolTotal.miRuta());
                    } else {
                        System.out.println("Tu ruta es --->" + arbolSecundario.miRuta());
                    }
                    break;
//RUTA ESPECIFICA
                case "f":
                    System.out.print("Ingresar Ruta --->" + arbolTotal.padre.nombre + "/");
                    if (arbolSecundario == null) {
                        arbolSecundario = arbolTotal.ingresarRuta(input.next(), arbolTotal);
                    } else {
                        arbolSecundario = arbolSecundario.ingresarRuta(input.next(), arbolTotal);
                    }
                    break;
//CREAR UNA RUTA
                case "g":
                    System.out.print("Crear Ruta --->" + arbolTotal.padre.nombre + "/");
                    if (arbolSecundario == null) {
                        arbolSecundario = arbolTotal.crearRuta(input.next(), arbolTotal);
                    } else {
                        arbolSecundario = arbolSecundario.crearRuta(input.next(), arbolTotal);
                    }
                    break;
//ATRAS
                case "h":
                    if (arbolSecundario == null) {
                        arbolTotal = arbolTotal.regresar();
                    } else {
                        arbolSecundario = arbolSecundario.regresar();
                    }
                    break;
//MOSTRAR HIJOS
                case "i":
                    System.out.println("");
                    if (arbolSecundario == null) {
                        arbolTotal.mostrarHijos();
                    } else {
                        arbolSecundario.mostrarHijos();
                    }
                    break;
//MOSTRAR ARBOL COMPLETO
                case "j":
                    System.out.println("--------------------------------------");
                    System.out.println(" Arbol ");
                    System.out.println("--------------------------------------");
                    System.out.println("");
                    arbolTotal.mostrarTodo(arbolTotal.padre, 0);
                    break;
//TERMINAR EL PROGRAMA
                case "x":
                    iteracionTerminado = true;
                    System.out.println(":) - :) - :) - :) - :3 - :3 - :3 - :3 - :3");
                    System.out.println(" FIN DEL PROGRAMA ");
                    System.out.println(":) - :) - :) - :) - :3 - :3 - :3 - :3 - :3");
                    break;
                default:
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("@@!!xx#$ INGRESE BIEN LA OPCION >:C #xx!!@@ ");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    break;
            }
        } while (!iteracionTerminado);
    }
}