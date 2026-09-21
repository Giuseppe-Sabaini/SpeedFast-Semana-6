package model;

/**
 * Gestor en memoria encargada de administrar los pedidos en el sistema SpeedFast.
 * Permite registrar nuevos pedidos, listar los existentes y validar IDs duplicados.
 *
 * @author Giuseppe Sabaini
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class SistemaEntrega {
    private List<Pedido> listaPedidos;


    public SistemaEntrega(){
        this.listaPedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public List<Pedido> getListaPedidos(){
        return listaPedidos;
    }

    public boolean existePedido(String id) {
        for (Pedido p : listaPedidos){
            if (p.getId().equalsIgnoreCase(id.trim())){
                return true;
            }
        }
        return false;
    }
}

