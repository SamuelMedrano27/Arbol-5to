import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Interfaz extends  JFrame{
    private JButton aa;
    private JPanel rootPanel;
    private JButton mostrarARBOLButton;
    private JButton inserteElNombreDelButton;
    private JButton mostrarHijosButton;
    private JButton insertaDentroDeHijosButton;
    private JButton eliminarHijosButton;
    private JButton rutaActualButton;
    private JButton rutaEspecíficaButton;
    private JButton crearUnaRutaButton;
    private JButton atrasButton;
    private JButton salirButton;
    private JTextField textField1;
    Arbol arbolTotal = new Arbol();
    Arbol arbolSecundario = null;

    public Interfaz(){
        add(rootPanel);

        setTitle("Registro de Pacientes");
        setSize(800,500);

        aa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena=JOptionPane.showInputDialog("Inserte el nombre del Padre");
                arbolTotal.nombre(cadena);
                if (arbolSecundario == null) {
                    textField1.setText( arbolTotal.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolTotal.miRuta());
                } else {
                    textField1.setText( arbolSecundario.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolSecundario.miRuta());
                }
            }
        });
        mostrarARBOLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arbolTotal.mostrarTodo(arbolTotal.padre, 0);
            }
        });
        inserteElNombreDelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadena=JOptionPane.showInputDialog("Inserte el nombre del Hijo");
                if (arbolSecundario == null) {
                    arbolTotal.insertarHijo(cadena);
                } else {
                    arbolSecundario.insertarHijo(cadena);
                }
                if (arbolSecundario == null) {
                    textField1.setText( arbolTotal.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolTotal.miRuta());
                } else {
                    textField1.setText(arbolSecundario.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolSecundario.miRuta());
                }

            }
        });
        mostrarHijosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arbolSecundario == null) {
                    arbolTotal.mostrarHijos();
                } else {
                    arbolSecundario.mostrarHijos();
                }
            }
        });
        insertaDentroDeHijosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String val=JOptionPane.showInputDialog("Ingrese al hijo");
                if (arbolSecundario == null) {
                    arbolSecundario = arbolTotal.ingresarAHijo(val, arbolTotal);
                } else {
                    arbolSecundario = arbolSecundario.ingresarAHijo(val, arbolSecundario);
                }
                if (arbolSecundario == null) {
                    textField1.setText( arbolTotal.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolTotal.miRuta());
                } else {
                    textField1.setText( arbolSecundario.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolSecundario.miRuta());
                }
            }
        });
        eliminarHijosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arbolSecundario == null) {
                    String val=JOptionPane.showInputDialog("Inserte el nombre del hijo a eliminar");
                    arbolTotal.eliminarHijo(val);
                } else {
                    String val=JOptionPane.showInputDialog("Inserte el nombre del hijo a eliminar");
                    arbolSecundario.eliminarHijo(val);
                }
                if (arbolSecundario == null) {
                    textField1.setText( arbolTotal.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolTotal.miRuta());
                } else {
                    textField1.setText( arbolSecundario.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolSecundario.miRuta());
                }
            }
        });
        rutaActualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arbolSecundario == null) {
//                    textField1.setText(arbolTotal.miRuta());
                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolTotal.miRuta());
                } else {
//                    textField1.setText(arbolSecundario.miRuta());
                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolSecundario.miRuta());
                }

            }
        });
        rutaEspecíficaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String val=JOptionPane.showInputDialog("Ingresar Ruta --->" + arbolTotal.padre.nombre + "/");
                if (arbolSecundario == null) {
                    arbolSecundario = arbolTotal.ingresarRuta(val, arbolTotal);
                } else {
                    arbolSecundario = arbolSecundario.ingresarRuta(val, arbolTotal);
                }
                if (arbolSecundario == null) {
                    textField1.setText(  arbolTotal.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolTotal.miRuta());
                } else {
                    textField1.setText( arbolSecundario.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolSecundario.miRuta());
                }
            }
        });
        crearUnaRutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String val=JOptionPane.showInputDialog("Crear Ruta --->" + arbolTotal.padre.nombre + "/");
                System.out.print("Crear Ruta --->" + arbolTotal.padre.nombre + "/");
                if (arbolSecundario == null) {
                    arbolSecundario = arbolTotal.crearRuta(val, arbolTotal);
                } else {
                    arbolSecundario = arbolSecundario.crearRuta(val, arbolTotal);
                }
                if (arbolSecundario == null) {
                    textField1.setText( arbolTotal.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolTotal.miRuta());
                } else {
                    textField1.setText( arbolSecundario.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolSecundario.miRuta());
                }
            }
        });
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (arbolSecundario == null) {
                    arbolTotal = arbolTotal.regresar();
                } else {
                    arbolSecundario = arbolSecundario.regresar();
                }
                if (arbolSecundario == null) {
                    textField1.setText( arbolTotal.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolTotal.miRuta());
                } else {
                    textField1.setText( arbolSecundario.miRuta());
//                    JOptionPane.showMessageDialog(null,"Tu ruta es --->" + arbolSecundario.miRuta());
                }
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null," FIN DEL PROGRAMA ");
                System.exit(0);



            }
        });

    }
}
