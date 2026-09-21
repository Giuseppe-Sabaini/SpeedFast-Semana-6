package vista;

/**
 * Ventana de la interfaz gráfica que permite el formulario de registro
 * para nuevos pedidos en la aplicación SpeedFast. Incluye validaciones de
 * campos obligatorios y verificación de IDs duplicados.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import model.Pedido;
import model.SistemaEntrega;

import javax.swing.*;

public class VentanaRegistroPedido extends JFrame {
    private JTextField txtId;
    private JTextField txtDireccion;
    private JComboBox<String> cbTipo;
    private JButton btnGuardar;
    private JPanel panelRegistro;

    private SistemaEntrega sistema;

    public VentanaRegistroPedido(SistemaEntrega sistema) {
        this.sistema = sistema;

        setTitle("SpeedFast - Registrar Pedido");
        setContentPane(panelRegistro);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        cbTipo.setModel(new DefaultComboBoxModel<>(new String[]{"comida", "encomienda", "express"}));

        btnGuardar.addActionListener(e -> guardarPedido());
    }

    private void guardarPedido() {
        String id = txtId.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String tipo = (String) cbTipo.getSelectedItem();

        // Validar campos obligatorios
        if (id.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, complete todos los campos obligatorios.",
                    "Error de Validación",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Validar si el ID ya existe
        if (sistema.existePedido(id)) {
            JOptionPane.showMessageDialog(
                    this,
                    "El ID: " + id + " ya se encuentra registrado. Ingrese un nuevo ID.",
                    "ID duplicado",
                    JOptionPane.ERROR_MESSAGE
            );
            txtId.requestFocus(); // Devuelve el foco al campo ID
            return; // Interrumpe el flujo para no guardar el pedido duplicado
        }

        // Agrega el pedido a la lista en memoria
        Pedido nuevoPedido = new Pedido(id, direccion, tipo);
        sistema.agregarPedido(nuevoPedido);

        // Esto es una confirmacion de que el pedido fue agregado
        JOptionPane.showMessageDialog(
                this,
                "Pedido agregado con éxito",
                "Confirmación",
                JOptionPane.INFORMATION_MESSAGE
        );

       // Limpia y cierra las ventanas
        txtId.setText("");
        txtDireccion.setText("");
        this.dispose();
    }
}