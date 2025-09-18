package proj.inteligencia_negocios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.inteligencia_negocios.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}


