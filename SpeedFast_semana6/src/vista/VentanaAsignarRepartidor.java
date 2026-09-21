package vista;

/**
 * Ventana de la interfaz gráfica que permite la asignación de un repartidor
 * para dar inicio al proceso de entrega de pedidos en la aplicación SpeedFast.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import model.SistemaEntrega;
import javax.swing.*;

public class VentanaAsignarRepartidor extends JFrame {
    private JTextField txtNombre;
    private JButton btnRegistrarRepartidor;
    private JPanel RegistroRepartidor;

    private SistemaEntrega sistema;

    public VentanaAsignarRepartidor(SistemaEntrega sistema) {
        this.sistema = sistema;

        setTitle("SpeedFast - Asignar Repartidor");
        setContentPane(RegistroRepartidor);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);

        btnRegistrarRepartidor.addActionListener(e -> asignarRepartidor());
    }

    private void asignarRepartidor() {
        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, ingrese el nombre del repartidor.",
                    "Campo Vacío",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
                this,
                "Se ha iniciado la entrega y asignado el repartidor: " + nombre,
                "Entrega Iniciada",
                JOptionPane.INFORMATION_MESSAGE
        );

        txtNombre.setText("");
        this.dispose();
    }
}