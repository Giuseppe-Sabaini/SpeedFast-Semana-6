package app;

/**
 * Clase principal y punto de entrada de la aplicación SpeedFast.
 * Se encarga de inicializar el sistema en memoria y lanzar la interfaz
 * gráfica.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import model.SistemaEntrega;
import vista.VentanaPrincipal;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // Ejecuta la interfaz gráfica
        SwingUtilities.invokeLater(() -> {

            // Instancia el controlador
            SistemaEntrega sistema = new SistemaEntrega();

            // Instancia la ventana principal pasando el sistema
            VentanaPrincipal principal = new VentanaPrincipal(sistema);

            //Hace visible la ventana
            principal.setVisible(true);
        });
    }
}