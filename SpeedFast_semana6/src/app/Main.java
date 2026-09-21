package app;

import model.SistemaEntrega;
import vista.VentanaPrincipal;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // Ejecuta la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {

            // Instancia el controlador/lista compartido
            SistemaEntrega sistema = new SistemaEntrega();

            // Instancia la ventana principal pasando el sistema
            VentanaPrincipal principal = new VentanaPrincipal(sistema);

            //Hace visible la ventana
            principal.setVisible(true);
        });
    }
}