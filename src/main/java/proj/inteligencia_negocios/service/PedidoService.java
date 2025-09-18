package proj.inteligencia_negocios.service;

import proj.inteligencia_negocios.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> findAll();
    Optional<Pedido> findById(Long idPedido);
    Pedido create(Pedido pedido);
    Optional<Pedido> update(Long idPedido, Pedido pedido);
    void delete(Long idPedido);
}


