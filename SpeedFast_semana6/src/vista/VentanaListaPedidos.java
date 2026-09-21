package vista;

/**
 * Ventana de la interfaz gráfica que despliega el listado completo de pedidos
 * registrados en el sistema mediante un componente JTable.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import model.Pedido;
import model.SistemaEntrega;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaListaPedidos extends JFrame {
    private JPanel panelLista;
    private JTable tablaPedidos;
    private JButton btnRefrescar;

    private SistemaEntrega sistema;
    private DefaultTableModel modeloTabla;


    public VentanaListaPedidos(SistemaEntrega sistema) {
        this.sistema = sistema;

        setTitle("SpeedFast - Listado de Pedidos");
        setContentPane(panelLista);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);

        configurarTabla();

        cargarDatos();

        btnRefrescar.addActionListener(e -> cargarDatos());
    }

    private void configurarTabla(){
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID Pedido");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Tipo");
        tablaPedidos.setModel(modeloTabla);
    }

    private void cargarDatos(){
        modeloTabla.setRowCount(0);

        if (sistema != null && sistema.getListaPedidos() != null) {
            for (Pedido p : sistema.getListaPedidos()) {
                modeloTabla.addRow(new Object[]{
                        p.getId(),
                        p.getDireccion(),
                        p.getTipoPedido()
                });
            }
        }
    }

}
