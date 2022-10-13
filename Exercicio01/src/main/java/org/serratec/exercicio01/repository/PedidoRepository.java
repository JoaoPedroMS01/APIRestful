package org.serratec.exercicio01.repository;

import org.serratec.exercicio01.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
