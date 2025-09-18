package proj.inteligencia_negocios.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.inteligencia_negocios.model.Pedido;
import proj.inteligencia_negocios.repository.PedidoRepository;
import proj.inteligencia_negocios.service.PedidoService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pedido> findById(Long idPedido) {
        return pedidoRepository.findById(idPedido);
    }

    @Override
    public Pedido create(Pedido pedido) {
        pedido.setIdPedido(null);
        return pedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> update(Long idPedido, Pedido pedido) {
        return pedidoRepository.findById(idPedido).map(existing -> {
            existing.setFecha(pedido.getFecha());
            existing.setUsuario(pedido.getUsuario());
            return pedidoRepository.save(existing);
        });
    }

    @Override
    public void delete(Long idPedido) {
        pedidoRepository.deleteById(idPedido);
    }
}


