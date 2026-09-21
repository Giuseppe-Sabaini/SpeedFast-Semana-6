package model;

/**
 * Representa un pedido dentro del sistema de gestión de entregas SpeedFast.
 * Contiene la información básica asociada a una solicitud de envío.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

public class Pedido {
    private String id;
    private String direccion;
    private String tipoPedido;

    public Pedido(String id, String direccion, String tipoPedido) {
        this.id = id;
        this.direccion = direccion;
        this.tipoPedido = tipoPedido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

}
