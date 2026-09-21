package vista;

/**
 * Ventana principal de la aplicación SpeedFast.
 * Funciona como el menú central desde el cual se puede navegar hacia las distintas
 * funcionalidades del sistema: registrar pedidos, listar pedidos y asignar repartidores.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import model.SistemaEntrega;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    private JPanel mainPanel;
    private JButton btnRegistrar;
    private JButton btnListarPedidos;
    private JButton btnAsignarRepartidor;

    private SistemaEntrega sistema;

    public VentanaPrincipal(SistemaEntrega sistema){
        this.sistema = sistema;

        setTitle("SpeedFast - Sistema de Gestión");
        setContentPane(mainPanel); // Enlaza la vista gráfica con el código
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Agrega los botones para cerrar la Ventana
        setSize(400, 300); // Ajusta el tamaño de la ventana Alto/ancho
        setLocationRelativeTo(null); // Centra la ventana


        btnRegistrar.addActionListener(e -> {
            VentanaRegistroPedido vRegistro = new VentanaRegistroPedido(sistema);
            vRegistro.setVisible(true);
        });

        btnListarPedidos.addActionListener(e -> {
            VentanaListaPedidos vLista = new VentanaListaPedidos(sistema);
            vLista.setVisible(true);
        });



        btnAsignarRepartidor.addActionListener(e -> {
            VentanaAsignarRepartidor vAsignar = new VentanaAsignarRepartidor(sistema);
            vAsignar.setVisible(true);
        });
    }

}
